package com.airftn.AirFTN.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.airftn.AirFTN.dto.AdminDTO;
import com.airftn.AirFTN.enumeration.RoleType;
import com.airftn.AirFTN.model.AirlineAdmin;
import com.airftn.AirFTN.model.ResponseMessage;
import com.airftn.AirFTN.model.Role;
import com.airftn.AirFTN.model.SysAdmin;
import com.airftn.AirFTN.model.User;
import com.airftn.AirFTN.repository.UserRepository;
import com.airftn.AirFTN.service.AdminService;

@CrossOrigin
@RestController
@RequestMapping(value = "api/admin")
public class AdminController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	AdminService adminService;

	ResponseMessage message = new ResponseMessage();

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {

		List<User> administrators = userRepository.findAll();

		return new ResponseEntity<>(administrators, HttpStatus.OK);
	}

	@PostMapping("/registerAirAdmin")
	public ResponseEntity<?> registerAirAdmin(@RequestBody AdminDTO registerRequest) {

		if (userRepository.existsByEmail(registerRequest.getEmail())) {
			message.setMessage("Email already in use");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByUsername(registerRequest.getUsername())) {
			message.setMessage("Admin with that username already exist");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}

		User admin = new AirlineAdmin(registerRequest.getEmail(), registerRequest.getUsername(),
				encoder.encode(registerRequest.getPassword()), registerRequest.getFirst_name(),
				registerRequest.getLast_name(), null, null, null);

		Role role = new Role();
		role.setName(RoleType.ROLE_AIRLINE_ADMIN);

		Set<Role> roles = new HashSet<>();
		roles.add(role);

		admin.setRoles(roles);

		userRepository.save(admin);
		message.setMessage("Airline Admin registered successfully!");

		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@PostMapping("/registerSysAdmin")
	public ResponseEntity<?> registerSysAdmin(@RequestBody AdminDTO registerRequest) {

		if (userRepository.existsByEmail(registerRequest.getEmail())) {
			message.setMessage("Email already in use");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByUsername(registerRequest.getUsername())) {
			message.setMessage("Admin with that username already exist");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}

		User admin = new SysAdmin(registerRequest.getEmail(), registerRequest.getUsername(),
				encoder.encode(registerRequest.getPassword()), registerRequest.getFirst_name(),
				registerRequest.getLast_name(), null, null, null);

		Role role = new Role();
		role.setName(RoleType.ROLE_SYSADMIN);

		Set<Role> roles = new HashSet<>();
		roles.add(role);

		admin.setRoles(roles);

		userRepository.save(admin);
		message.setMessage("System Admin registered successfully!");

		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@PostMapping("/updateAdmin")
	public ResponseEntity<?> update(@RequestBody User admin) {

		User a = userRepository.findByUsername(admin.getUsername());

		User administrator = adminService.update(admin, a.getId());

		if (administrator == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		message.setMessage("User information successfully updated!");
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@GetMapping("/getAdmin/{username}")
	public ResponseEntity<User> getAdmin(@PathVariable String username) {

		User admin = adminService.findByUsername(username);

		if (admin == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(admin, HttpStatus.OK);
	}

}
