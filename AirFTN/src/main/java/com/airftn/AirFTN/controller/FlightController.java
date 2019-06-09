package com.airftn.AirFTN.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airftn.AirFTN.dto.FlightDTO;
import com.airftn.AirFTN.model.Flight;
import com.airftn.AirFTN.repository.FlightRepository;
import com.airftn.AirFTN.service.FlightService;

@CrossOrigin
@RestController
@RequestMapping("api/flight/")
public class FlightController {
	
	@Autowired
	FlightService flightService;
	
	@Autowired
	FlightRepository flightRepository;
	
	@GetMapping("")
	public ResponseEntity<List<Flight>> findAllNotDeleted() {
		
		List<Flight> flights = flightService.findAllNotDeleted();
		
		return new ResponseEntity<>(flights, HttpStatus.OK);
	}

	@PostMapping("/createFlight")
	public ResponseEntity<Flight> create(@RequestBody FlightDTO flight) {
		
		Flight f = flightService.create(flight);		
		
		return new ResponseEntity<>(f, HttpStatus.OK);
		
	}
	
}
