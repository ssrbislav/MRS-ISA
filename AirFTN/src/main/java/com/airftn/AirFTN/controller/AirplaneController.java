package com.airftn.AirFTN.controller;

import java.util.ArrayList;
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

	@GetMapping("")
	public ResponseEntity<List<Airplane>> findAll() {

		List<Airplane> airplanes = airplaneService.findAll();

		return new ResponseEntity<>(airplanes, HttpStatus.OK);
	}

	@PostMapping("/createAirplane")
	public ResponseEntity<ResponseMessage> create(@RequestBody AirplaneDTO airplane) throws ObjectNotFoundException {

		Airplane plane = airplaneService.create(airplane);

		if (plane == null) {
			message.setMessage("Error during airplane creation!");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}

		message.setMessage("Airplane successfully created!");
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@GetMapping("/findByCompanyId/{id}")
	public ResponseEntity<List<Airplane>> getPlanesByCompanyId(@PathVariable Long id) {
		
		AirlineCompany company = airlineService.getOne(id);
		
		List<Airplane> airplanes = company.getPlanes();

		if (airplanes == null) {
			return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(airplanes, HttpStatus.OK);
	}
	
	@GetMapping("/findByNotTakend/{id}")
	public ResponseEntity<List<Airplane>> getPlanesByNotTaken(@PathVariable Long id) {
		
		AirlineCompany company = airlineService.getOne(id);
		
		List<Airplane> airplanes = company.getPlanes();
		
		List<Airplane> notTaken = new ArrayList<>();
		
		for(Airplane plane : airplanes) {
			if(!plane.isTaken())
				notTaken.add(plane);
		}

		if (airplanes == null) {
			return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(notTaken, HttpStatus.OK);
	}
	
	@GetMapping("/findByFlightId/{id}")
	public ResponseEntity<Airplane> findByCompanyId(@PathVariable Long id){
		
		Airplane airplane = airplaneService.findByFlightId(id);
		
		if(airplane == null) {
			return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(airplane, HttpStatus.OK);
		
	}
	
	@GetMapping("/findAllNotTaken")
	public ResponseEntity<List<Airplane>> findAllNotTaken() {
		
		List<Airplane> airplanes = airplaneService.findAllNotTaken();
		
		if(airplanes == null) {
			return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(airplanes, HttpStatus.OK);
		
	}

}
