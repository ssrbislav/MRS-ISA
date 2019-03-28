package com.airftn.AirFTN.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.airftn.AirFTN.model.Passenger;
import com.airftn.AirFTN.service.PassengerService;

@RestController
@RequestMapping(value = "api/passenger")
public class PassengerController {

	@Autowired
	PassengerService passengerService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Passenger>> findAll() {

		List<Passenger> passengers = passengerService.findAll();

		return new ResponseEntity<>(passengers, HttpStatus.OK);
	}

	// Check if insted @RequestBody there should be @PathVariable -- maybe parameteres need to match
	@RequestMapping(value = "getPassenger", method = RequestMethod.GET)
	public ResponseEntity<Passenger> getOne(@RequestBody Passenger passenger) {

		Passenger p = passengerService.getOne(passenger.getId());

		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	@RequestMapping(value = "/addPassenger", method = RequestMethod.POST)
	public ResponseEntity<Passenger> create(@RequestBody Passenger passenger) {

		Passenger p = passengerService.create(passenger);

		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	@RequestMapping(value = "/updatePassenger", method = RequestMethod.POST)
	public ResponseEntity<Passenger> update(@RequestBody Passenger passenger) {

		Passenger p = passengerService.update(passenger);

		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	@RequestMapping(value = "deletePassenger/{id}", method = RequestMethod.GET)
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {

		boolean delete = passengerService.delete(id);

		return new ResponseEntity<>(delete, HttpStatus.OK);
	}
}
