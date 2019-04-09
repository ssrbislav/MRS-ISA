package com.airftn.AirFTN.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.airftn.AirFTN.dto.AdminDTO;
import com.airftn.AirFTN.enumeration.RoleType;
import com.airftn.AirFTN.model.Admin;
import com.airftn.AirFTN.model.AirlineAdmin;
import com.airftn.AirFTN.model.Role;
import com.airftn.AirFTN.repository.AdminRepository;
import com.airftn.AirFTN.service.IAdminService;

@CrossOrigin
@RestController
@RequestMapping(value = "api/admin")
public class AdminController {

	@Autowired
	IAdminService adminService;

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	PasswordEncoder encoder;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Admin>> findAll() {

		List<Admin> administrators = adminService.findAll();

		return new ResponseEntity<>(administrators, HttpStatus.OK);
	}

	// @RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
	// public ResponseEntity<Admin> create(@RequestBody Admin admin) {
	//
	// Admin administrator = adminService.create(admin);
	//
	// if (administrator == null)
	// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	//
	// return new ResponseEntity<>(administrator, HttpStatus.OK);
	// }

	@PostMapping("/registerAdmin")
	public ResponseEntity<?> registerAdmin(@RequestBody AdminDTO registerRequest) {

		if (adminRepository.existsByEmail(registerRequest.getEmail())) {
			return new ResponseEntity<>("Email already in use", HttpStatus.BAD_REQUEST);
		}

		if (adminRepository.existsByUsername(registerRequest.getUsername())) {
			return new ResponseEntity<>("Admin with that username already exist", HttpStatus.BAD_REQUEST);
		}

		Admin admin = new AirlineAdmin(registerRequest.getEmail(), registerRequest.getUsername(),
				encoder.encode(registerRequest.getPassword()));

		Role role = new Role();
		role.setName(RoleType.ROLE_AIRLINE_ADMIN);

		Set<Role> roles = new HashSet<>();
		roles.add(role);

		admin.setRoles(roles);

		adminRepository.save(admin);

		return new ResponseEntity<>("Admin  registered successfully!", HttpStatus.OK);
	}

	@PostMapping("/updateAdmin")
	public ResponseEntity<Admin> update(@RequestBody Admin admin) {

		Admin administrator = adminService.update(admin);

		if (administrator == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(administrator, HttpStatus.OK);
	}

	// @RequestMapping(value = "deleteAdmin/{id}", method = RequestMethod.GET)
	// public ResponseEntity<Boolean> delete(@PathVariable Long id) {
	//
	// boolean delete = adminService.delete(id);
	//
	// return new ResponseEntity<>(delete, HttpStatus.OK);
	// }

}
