package com.airftn.AirFTN.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airftn.AirFTN.dto.AdminDTO;
import com.airftn.AirFTN.enumeration.RoleType;
import com.airftn.AirFTN.model.AirlineAdmin;
import com.airftn.AirFTN.model.ResponseMessage;
import com.airftn.AirFTN.model.Role;
import com.airftn.AirFTN.model.SysAdmin;
import com.airftn.AirFTN.repository.AirAdminRepository;
import com.airftn.AirFTN.repository.SysAdminRepository;
import com.airftn.AirFTN.service.SysAdminService;

@CrossOrigin
@RestController
@RequestMapping("api/sysadmin")
public class SysAdminController {

	@Autowired
	SysAdminRepository sysAdminRepository;

	@Autowired
	AirAdminRepository airAdminRepository;
	
	@Autowired
	SysAdminService sysAdminService;

	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	ResponseMessage message = new ResponseMessage();

	@GetMapping("")
	public ResponseEntity<List<SysAdmin>> findAll() {

		List<SysAdmin> admins = sysAdminService.findAll();

		return new ResponseEntity<>(admins, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_SYSADMIN')")
	@GetMapping("/getAdminById/{id}")
	public ResponseEntity<SysAdmin> getAdmin(@PathVariable Long id) {

		SysAdmin admin = sysAdminRepository.getOne(id);

		if (admin == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(admin, HttpStatus.OK);

	}

	@PreAuthorize("hasRole('ROLE_SYSADMIN')")
	@PostMapping("/registerAirAdmin")
	public ResponseEntity<ResponseMessage> registerAirAdmin(@RequestBody AdminDTO registerRequest) {

		if (airAdminRepository.existsByEmail(registerRequest.getEmail())) {
			message.setMessage("Email already in use");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}

		if (airAdminRepository.existsByUsername(registerRequest.getUsername())) {
			message.setMessage("Admin with that username already exist");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}

		AirlineAdmin admin = new AirlineAdmin(registerRequest.getEmail(), registerRequest.getUsername(),
				encoder.encode(registerRequest.getPassword()), registerRequest.getFirstName(),
				registerRequest.getLastName(), null, null, null);
		

		Role role = new Role();
		role.setName(RoleType.ROLE_AIRLINE_ADMIN);

		Set<Role> roles = new HashSet<>();
		roles.add(role);

		admin.setRoles(roles);

		airAdminRepository.save(admin);
		message.setMessage("Airline Admin registered successfully!");

		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_SYSADMIN')")
	@PostMapping("/registerSysAdmin")
	public ResponseEntity<ResponseMessage> registerSysAdmin(@RequestBody AdminDTO registerRequest) {

		if (sysAdminRepository.existsByEmail(registerRequest.getEmail())) {
			message.setMessage("Email already in use");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}

		if (sysAdminRepository.existsByUsername(registerRequest.getUsername())) {
			message.setMessage("Admin with that username already exist");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}

		SysAdmin admin = new SysAdmin(registerRequest.getEmail(), registerRequest.getUsername(),
				encoder.encode(registerRequest.getPassword()), registerRequest.getFirstName(),
				registerRequest.getLastName(), null, null, null);

		Role role = new Role();
		role.setName(RoleType.ROLE_SYSADMIN);

		Set<Role> roles = new HashSet<>();
		roles.add(role);

		admin.setRoles(roles);

		sysAdminRepository.save(admin);
		message.setMessage("System Admin registered successfully!");

		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_SYSADMIN')")
	@GetMapping("/getAdmin/{username}")
	public ResponseEntity<SysAdmin> getAdmin(@PathVariable String username) {

		SysAdmin admin = sysAdminRepository.findByUsername(username);

		if (admin == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(admin, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_SYSADMIN')")
	@PostMapping("/updateAdmin")
	public ResponseEntity<ResponseMessage> update(@RequestBody SysAdmin admin) {

		SysAdmin a = sysAdminRepository.findByUsername(admin.getUsername());

		SysAdmin administrator = sysAdminService.update(admin, a.getId());

		if (administrator == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		message.setMessage("User information successfully updated!");

		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_SYSADMIN')")
	@PostMapping("/blockAdmin/{id}")
	public ResponseEntity<ResponseMessage> blockAdmin(@PathVariable Long id) {

		SysAdmin admin = sysAdminRepository.getOne(id);
		
		if(admin == null ) {
			message.setMessage("Admin does not exist!");
			return new ResponseEntity<ResponseMessage>(message, HttpStatus.BAD_REQUEST);
		}
		
		admin.setBlocked(true);
		sysAdminRepository.save(admin);

		message.setMessage("Admin successfully blocked!");
		return new ResponseEntity<ResponseMessage>(message, HttpStatus.OK);
	}

}
