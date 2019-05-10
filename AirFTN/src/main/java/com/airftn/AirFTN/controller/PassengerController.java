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

import com.airftn.AirFTN.model.Passenger;
import com.airftn.AirFTN.model.ResponseMessage;
import com.airftn.AirFTN.repository.PassengerRepository;
import com.airftn.AirFTN.service.PassengerService;

@CrossOrigin
@RestController
@RequestMapping(value = "api/passenger")
public class PassengerController {

	@Autowired
	PassengerService passengerService;

	@Autowired
	PassengerRepository passengerRepository;
	
	ResponseMessage message = new ResponseMessage();

	@GetMapping("")
	public ResponseEntity<List<Passenger>> findAll() {

		List<Passenger> passengers = passengerService.findAll();

		return new ResponseEntity<>(passengers, HttpStatus.OK);
	}

	@GetMapping("getPassenger/{id}")
	public ResponseEntity<Passenger> getOne(@PathVariable Long id) {

		Passenger p = passengerService.getOne(id);

		if (p == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	@GetMapping("/getPassengerActive/{username}")
	private boolean getPassengerActive(@PathVariable String username) {

		Passenger passenger = passengerRepository.findByUsername(username);

		if (!passenger.isActive())
			return false;

		return true;

	}

	@PostMapping("/updatePassenger")
	public ResponseEntity<?> update(@RequestBody Passenger passenger) {
		
		Passenger pass = passengerRepository.findByUsername(passenger.getUsername());

		Passenger p = passengerService.update(passenger, pass.getId());

		if (p == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		message.setMessage("User info successfully changed!");
		
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

}
