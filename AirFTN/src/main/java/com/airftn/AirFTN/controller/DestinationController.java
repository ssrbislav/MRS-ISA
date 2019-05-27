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

import com.airftn.AirFTN.dto.DestinationDTO;
import com.airftn.AirFTN.model.Destination;
import com.airftn.AirFTN.model.ResponseMessage;
import com.airftn.AirFTN.repository.DestinationRepository;
import com.airftn.AirFTN.service.DestinationService;

@RestController
@CrossOrigin
@RequestMapping("api/destination")
public class DestinationController {

	@Autowired
	DestinationService destinationService;
	
	@Autowired
	DestinationRepository destinationRepository;
	
	ResponseMessage message = new ResponseMessage();
	
	@GetMapping("")
	public ResponseEntity<List<Destination>> getAll() {
		
		List<Destination> destinations = destinationService.findAll();
		
		return new ResponseEntity<>(destinations, HttpStatus.OK);
		
	}
	
	@GetMapping("/getDestination/{id}")
	public ResponseEntity<Destination> getOne(@PathVariable Long id) {
		
		Destination destination = destinationService.findById(id);
		
		if(destination == null) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(destination, HttpStatus.OK);
	}
	
	@PostMapping("/addDestination")
	public ResponseEntity<ResponseMessage> create(@RequestBody DestinationDTO dest) {
		
		
		
		Destination destination = destinationService.create(dest);
		
		if(destination == null) {
			message.setMessage("Not able to create Destination");
			
			return new ResponseEntity<ResponseMessage>(message, HttpStatus.BAD_REQUEST);
		}
		
		message.setMessage("Destination created successfully!");
		return new ResponseEntity<ResponseMessage>(message, HttpStatus.OK);
	}
	
}
