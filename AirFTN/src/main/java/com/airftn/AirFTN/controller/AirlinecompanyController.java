package com.airftn.AirFTN.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airftn.AirFTN.dto.AirlineCompanyDTO;
import com.airftn.AirFTN.model.AirlineAdmin;
import com.airftn.AirFTN.model.AirlineCompany;
import com.airftn.AirFTN.model.ResponseMessage;
import com.airftn.AirFTN.repository.AirlinecompanyRepository;
import com.airftn.AirFTN.service.AdminService;
import com.airftn.AirFTN.service.AirlinecompanyService;

@CrossOrigin
@RestController
@RequestMapping("api/company")
public class AirlinecompanyController {

	@Autowired
	AirlinecompanyService companyService;

	@Autowired
	AirlinecompanyRepository companyRepository;

	@Autowired
	AdminService adminService;

	ResponseMessage message = new ResponseMessage();

	@GetMapping("")
	public ResponseEntity<List<AirlineCompany>> getAll() {

		List<AirlineCompany> companies = companyService.findAll();

		return new ResponseEntity<List<AirlineCompany>>(companies, HttpStatus.OK);

	}

	@GetMapping("getCompany/{id}")
	public ResponseEntity<AirlineCompany> getOne(@PathVariable Long id) {

		AirlineCompany company = companyService.getOne(id);

		if (company == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<AirlineCompany>(company, HttpStatus.OK);

	}

	@PostMapping("/createCompany")
	public ResponseEntity<ResponseMessage> create(AirlineCompanyDTO company) {

		AirlineCompany airlineCompany = companyService.create(company);

		if (airlineCompany == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		companyRepository.save(airlineCompany);

		message.setMessage("Airline Company successfully created!");

		return new ResponseEntity<>(message, HttpStatus.OK);

	}

	@PostMapping("/updateAdmin/{airlineId}/{adminId}")
	public ResponseEntity<ResponseMessage> updateAdmin(@PathVariable("airlineId") Long airlineId,
			@PathVariable("adminId") Long adminId) {

		AirlineAdmin admin = (AirlineAdmin) adminService.getOne(adminId);

		ResponseMessage message = new ResponseMessage();

		if (admin == null) {

			message.setMessage("Admin not found!");

			return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
		}

		AirlineCompany company = companyService.getOne(airlineId);
		
		if (company == null) {

			message.setMessage("Airline company not found!");

			return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
		}

		company.setAdmin(admin);

		message.setMessage("Admin successfully updated!");

		return new ResponseEntity<>(message, HttpStatus.OK);
	}

}
