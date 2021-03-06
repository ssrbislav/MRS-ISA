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

import com.airftn.AirFTN.dto.FlightDTO;
import com.airftn.AirFTN.model.Flight;
import com.airftn.AirFTN.model.ResponseMessage;
import com.airftn.AirFTN.model.TransferPoint;
import com.airftn.AirFTN.repository.FlightRepository;
import com.airftn.AirFTN.service.FlightService;

@CrossOrigin
@RestController
@RequestMapping("api/flight")
public class FlightController {

	@Autowired
	FlightService flightService;

	@Autowired
	FlightRepository flightRepository;

	ResponseMessage message = new ResponseMessage();

	@GetMapping("")
	public ResponseEntity<List<Flight>> findAllNotDeleted() {

		List<Flight> flights = flightService.findAllNotDeleted();

		return new ResponseEntity<>(flights, HttpStatus.OK);
	}

	@GetMapping("/getFlight/{id}")
	public ResponseEntity<Flight> getOne(@PathVariable Long id) {

		Flight flight = flightService.getOne(id);

		if (flight == null) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(flight, HttpStatus.OK);

	}

	@PostMapping("/createFlight")
	public ResponseEntity<ResponseMessage> create(@RequestBody FlightDTO flight) {

		Flight f = flightService.create(flight);

		if (f == null) {
			message.setMessage("Not able to create Flight");

			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}

		message.setMessage("Flight successfully created!");

		return new ResponseEntity<>(message, HttpStatus.OK);

	}

	@PostMapping("/updateFlight")
	public ResponseEntity<ResponseMessage> update(@RequestBody Flight flight) {

		Flight f = flightService.update(flight);

		if (f == null) {
			message.setMessage("Flight not found!");

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		message.setMessage("Flight profile successfully updated!");

		return new ResponseEntity<>(message, HttpStatus.OK);

	}

	@GetMapping("/getByAirlineId/{id}")
	public ResponseEntity<List<Flight>> getByAirlineId(@PathVariable Long id) {

		List<Flight> flights = flightService.findByCompanyId(id);

		if (flights == null) {
			return new ResponseEntity<List<Flight>>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Flight>>(flights, HttpStatus.OK);

	}
	
	@GetMapping("/getTransferPoints/{id}")
	public ResponseEntity<List<TransferPoint>> getAllTransferPoints(@PathVariable Long id) {
		
		List<TransferPoint> tp = flightService.getAllTransferPoints(id);	
		
		if(tp == null) 
			return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<List<TransferPoint>>(tp, HttpStatus.OK);
		
	}
	
	@GetMapping("/findByCompanyAndDestination/{airlineId}/{destinationId}")
	public ResponseEntity<List<Flight>> findByCompanyAndDestination(@PathVariable Long airlineId, @PathVariable Long destinationId) {

		List<Flight> flights = flightService.findByCompanyAndDestination(airlineId, destinationId);

//		if (flights == null) {
//			return new ResponseEntity<List<Flight>>(HttpStatus.NOT_FOUND);
//		}

		return new ResponseEntity<List<Flight>>(flights, HttpStatus.OK);

	}
	
}
