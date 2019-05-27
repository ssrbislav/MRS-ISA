package com.airftn.AirFTN.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airftn.AirFTN.dto.AirlineCompanyDTO;
import com.airftn.AirFTN.model.AirlineAdmin;
import com.airftn.AirFTN.model.AirlineCompany;
import com.airftn.AirFTN.model.Destination;
import com.airftn.AirFTN.model.ResponseMessage;
import com.airftn.AirFTN.repository.AirAdminRepository;
import com.airftn.AirFTN.repository.AirlinecompanyRepository;
import com.airftn.AirFTN.service.AirlinecompanyService;

@CrossOrigin
@RestController
@RequestMapping("api/company")
public class AirlinecompanyController {

	@Autowired
	AirAdminRepository adminRepository;

	@Autowired
	AirlinecompanyRepository companyRepository;

	@Autowired
	AirlinecompanyService companyService;

	ResponseMessage message = new ResponseMessage();

	@GetMapping("")
	public ResponseEntity<List<AirlineCompany>> getAll() {

		List<AirlineCompany> companies = companyService.findAll();

		return new ResponseEntity<>(companies, HttpStatus.OK);

	}

	@GetMapping("getCompany/{id}")
	public ResponseEntity<AirlineCompany> getOne(@PathVariable Long id) {

		AirlineCompany company = companyService.getOne(id);

		if (company == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<AirlineCompany>(company, HttpStatus.OK);

	}

	@PostMapping("/createCompany")
	public ResponseEntity<ResponseMessage> create(@RequestBody AirlineCompanyDTO company) {

		AirlineCompany airlineCompany = companyService.create(company);

		if (airlineCompany == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		message.setMessage("Airline Company successfully created!");

		return new ResponseEntity<>(message, HttpStatus.OK);

	}

	@PostMapping("/updateAdmin/{airlineId}/{adminId}")
	public ResponseEntity<ResponseMessage> updateAdmin(@PathVariable("airlineId") Long airlineId,
			@PathVariable("adminId") Long adminId) {

		AirlineAdmin admin = adminRepository.getOne(adminId);

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

		companyRepository.save(company);

		message.setMessage("Admin successfully updated!");

		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@PostMapping("/updateInfo")
	public ResponseEntity<ResponseMessage> updateCompanyInfo(@RequestBody AirlineCompany company) {

		AirlineCompany aircompany = companyService.update(company);

		if (aircompany == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		message.setMessage("Company profile successfully updated!");

		return new ResponseEntity<>(message, HttpStatus.OK);

	}

	@PostMapping("/addDestination/{dest_id}/{company_id}")
	public ResponseEntity<ResponseMessage> addDestinationToCompany(@PathVariable Long dest_id,
			@PathVariable Long company_id) {

		List<Destination> destinations = companyService.addDestinationToCompany(company_id, dest_id);
		
		if(destinations == null) {
			message.setMessage("Destination already added!");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}

		message.setMessage("Destination successfully added to company's list");
		return new ResponseEntity<>(message, HttpStatus.OK);

	}
	
	@GetMapping("/getDestinations/{id}")
	public ResponseEntity<List<Destination>> getAllDestinations(@PathVariable Long id) {
		
		AirlineCompany company = companyRepository.getOne(id);
		
		if(company == null) {
			return new ResponseEntity<List<Destination>>(HttpStatus.NOT_FOUND);
		}
		
		List<Destination> destinations = company.getDestinations();
		
		return new ResponseEntity<List<Destination>>(destinations, HttpStatus.OK);
	}

}
