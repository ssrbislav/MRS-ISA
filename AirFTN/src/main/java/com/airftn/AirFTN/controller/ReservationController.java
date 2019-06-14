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

import com.airftn.AirFTN.dto.ReservationDTO;
import com.airftn.AirFTN.model.Reservation;
import com.airftn.AirFTN.model.ResponseMessage;
import com.airftn.AirFTN.service.IReservationService;

@CrossOrigin
@RestController
@RequestMapping("api/reservation")
public class ReservationController {

	@Autowired
	IReservationService reservationService;

	ResponseMessage message = new ResponseMessage();
	
	@GetMapping("")
	public ResponseEntity<List<Reservation>> findAll() {

		List<Reservation> reservations = reservationService.findAll();

		if (reservations == null)
			return new ResponseEntity<>(HttpStatus.OK);

		return new ResponseEntity<List<Reservation>>(reservations, HttpStatus.OK);
	}

	@GetMapping("findAllByPassengerId/{id}")
	public ResponseEntity<List<Reservation>> findAllByPassengerId(@PathVariable Long id) {

		List<Reservation> reservations = reservationService.findAllByPassengerId(id);

		if (reservations == null)
			return new ResponseEntity<>(HttpStatus.OK);

		return new ResponseEntity<List<Reservation>>(reservations, HttpStatus.OK);
	}
	
	@GetMapping("findById/{id}")
	public ResponseEntity<Reservation> findById(@PathVariable Long id) {

		Reservation reservation = reservationService.getOne(id);

		if (reservation == null)
			return new ResponseEntity<>(HttpStatus.OK);

		return new ResponseEntity<>(reservation, HttpStatus.OK);
	}
	
	@PostMapping("/createReservation")
	public ResponseEntity<ResponseMessage> createReservation(@RequestBody ReservationDTO reservation) {

		Reservation res = reservationService.create(reservation);

		if (res == null) {
			message.setMessage("Not able to create reservation!");

			return new ResponseEntity<ResponseMessage>(HttpStatus.BAD_REQUEST);
		}

		message.setMessage("Reservation created successfullly");

		return new ResponseEntity<>(message, HttpStatus.OK);
	} 
	
	@PostMapping("/updateReservation")
	public ResponseEntity<ResponseMessage> updateReservation(@RequestBody Reservation reservation) {

		Reservation res = reservationService.update(reservation);

		if (res == null) {
			message.setMessage("Not able to update reservation!");

			return new ResponseEntity<ResponseMessage>(HttpStatus.BAD_REQUEST);
		}

		message.setMessage("Reservation updated successfullly");

		return new ResponseEntity<>(message, HttpStatus.OK);
	} 
	
	

}
