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

import com.airftn.AirFTN.dto.TicketDTO;
import com.airftn.AirFTN.model.ResponseMessage;
import com.airftn.AirFTN.model.Ticket;
import com.airftn.AirFTN.service.ITicketService;

@CrossOrigin
@RestController
@RequestMapping("api/ticket")
public class TicketController {

	@Autowired
	ITicketService ticketService;
	
	ResponseMessage message;
	
	@RequestMapping("")
	public ResponseEntity<List<Ticket>> findAll() {

		List<Ticket> tickets = ticketService.findAll();

		return new ResponseEntity<>(tickets, HttpStatus.OK);
	}
	
	@GetMapping("/findAllByCompanyId/{id}")
	public ResponseEntity<List<Ticket>> findAllByCompanyId(@PathVariable Long id) {
	
		List<Ticket> tickets = ticketService.findAllByCompanyId(id);
		
		if(tickets == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(tickets, HttpStatus.OK);
	}
	
	@GetMapping("/findAllByFlightId/{id}")
	public ResponseEntity<List<Ticket>> findAllByFlightId(@PathVariable Long id) {
	
		List<Ticket> tickets = ticketService.findAllByFlightId(id);
		
		if(tickets == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(tickets, HttpStatus.OK);
	}
	
	@GetMapping("/findBySeatId/{id}")
	public ResponseEntity<Ticket> findBySeatId(@PathVariable Long id) {
	
		Ticket ticket = ticketService.findBySeatId(id);
		
		if(ticket == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(ticket, HttpStatus.OK);
	}
	
	@PostMapping("/createTicket")
	public ResponseEntity<ResponseMessage> createTicket(@RequestBody TicketDTO ticket) {

		Ticket t = ticketService.create(ticket);

		if (t == null) {
			message.setMessage("Not able to create reservation!");

			return new ResponseEntity<ResponseMessage>(HttpStatus.BAD_REQUEST);
		}

		message.setMessage("Reservation created successfullly");

		return new ResponseEntity<>(message, HttpStatus.OK);
	} 
	
	@PostMapping("/updateTicket")
	public ResponseEntity<ResponseMessage> updateTicket(@RequestBody Ticket ticket) {

		Ticket t = ticketService.update(ticket);

		if (t == null) {
			message.setMessage("Not able to update reservation!");

			return new ResponseEntity<ResponseMessage>(HttpStatus.BAD_REQUEST);
		}

		message.setMessage("Reservation updated successfullly");

		return new ResponseEntity<>(message, HttpStatus.OK);
	} 
	
}
