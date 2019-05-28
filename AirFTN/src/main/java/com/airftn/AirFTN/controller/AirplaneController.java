package com.airftn.AirFTN.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airftn.AirFTN.dto.AirplaneDTO;
import com.airftn.AirFTN.model.AirlineCompany;
import com.airftn.AirFTN.model.Airplane;
import com.airftn.AirFTN.model.ResponseMessage;
import com.airftn.AirFTN.service.AirlinecompanyService;
import com.airftn.AirFTN.service.IAirplaneService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@CrossOrigin
@RequestMapping("api/airplane")
public class AirplaneController {

	@Autowired
	IAirplaneService airplaneService;

	@Autowired
	AirlinecompanyService airlineService;
	
	ResponseMessage message = new ResponseMessage();

	@RequestMapping("")
	public ResponseEntity<List<Airplane>> findAll() {

		List<Airplane> airplanes = airplaneService.findAll();

		return new ResponseEntity<>(airplanes, HttpStatus.OK);
	}

	@RequestMapping("/createAirplane")
	public ResponseEntity<ResponseMessage> create(@RequestBody AirplaneDTO airplane) throws ObjectNotFoundException {

		Airplane plane = airplaneService.create(airplane);

		if (plane == null) {
			message.setMessage("Error during airplane creation!");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}

		message.setMessage("Airplane successfully created!");
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@RequestMapping("/findByCompanyId/{id}")
	public ResponseEntity<List<Airplane>> create(@PathVariable Long id) {
		
		AirlineCompany company = airlineService.getOne(id);
		
		List<Airplane> airplanes = company.getPlanes();

		if (airplanes == null) {
			return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(airplanes, HttpStatus.OK);
	}

}
