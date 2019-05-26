package com.airftn.AirFTN.controller;

import java.util.List;

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

import com.airftn.AirFTN.model.AirlineAdmin;
import com.airftn.AirFTN.model.ResponseMessage;
import com.airftn.AirFTN.repository.AirAdminRepository;
import com.airftn.AirFTN.service.AirAdminService;

@CrossOrigin
@RestController
@RequestMapping(value = "api/airadmin")
public class AirAdminController {

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	AirAdminRepository adminRepository;

	@Autowired
	AirAdminService adminService;

	ResponseMessage message = new ResponseMessage();

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<AirlineAdmin>> findAll() {

		List<AirlineAdmin> administrators = adminRepository.findAll();

		return new ResponseEntity<>(administrators, HttpStatus.OK);
	}

	@PostMapping("/updateAdmin")
	public ResponseEntity<ResponseMessage> update(@RequestBody AirlineAdmin admin) {

		AirlineAdmin a = adminRepository.findByUsername(admin.getUsername());

		AirlineAdmin administrator = adminService.update(admin, a.getId());

		if (administrator == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		message.setMessage("User information successfully updated!");

		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@GetMapping("/getAdmin/{username}")
	public ResponseEntity<AirlineAdmin> getAdmin(@PathVariable String username) {

		AirlineAdmin admin = adminRepository.findByUsername(username);

		if (admin == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(admin, HttpStatus.OK);
	}
	
	@GetMapping("/getAdminById/{id}")
	public ResponseEntity<AirlineAdmin> getAdmin(@PathVariable Long id) {

		AirlineAdmin admin = adminRepository.getOne(id);

		if (admin == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(admin, HttpStatus.OK);

	}

}
