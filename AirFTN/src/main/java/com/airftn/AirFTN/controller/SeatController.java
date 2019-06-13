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

import com.airftn.AirFTN.dto.SeatDTO;
import com.airftn.AirFTN.enumeration.SeatType;
import com.airftn.AirFTN.model.ResponseMessage;
import com.airftn.AirFTN.model.Seat;
import com.airftn.AirFTN.service.ISeatService;

import javassist.tools.rmi.ObjectNotFoundException;

@CrossOrigin
@RestController
@RequestMapping("api/seat")
public class SeatController {

	@Autowired
	ISeatService seatService;

	ResponseMessage message = new ResponseMessage();

	@GetMapping("")
	public ResponseEntity<List<Seat>> findAll() {

		List<Seat> seats = seatService.findAll();

		return new ResponseEntity<List<Seat>>(seats, HttpStatus.OK);

	}

	@GetMapping("/findAllByAirplaneId/{id}")
	public ResponseEntity<List<Seat>> findAllByAirplaneId(@PathVariable Long id) {

		List<Seat> seats = seatService.findAllByAirplaneId(id);

		return new ResponseEntity<List<Seat>>(seats, HttpStatus.OK);

	}

	@GetMapping("/findAllBySeatType/{seatType}")
	public ResponseEntity<List<Seat>> findAllBySeatType(@PathVariable int seatType) {

		List<Seat> seats = seatService.findAllBySeatType(seatType);

		return new ResponseEntity<List<Seat>>(seats, HttpStatus.OK);

	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Seat> findById(@PathVariable Long id) {

		Seat seat = seatService.getOne(id);

		if (seat == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(seat, HttpStatus.OK);

	}

	@PostMapping("/create")
	public ResponseEntity<ResponseMessage> createSeat(@RequestBody SeatDTO seat) {

		Seat s = seatService.create(seat);

		if (s == null) {
			message.setMessage("Not able to create seat!");

			return new ResponseEntity<ResponseMessage>(HttpStatus.BAD_REQUEST);
		}

		message.setMessage("Seat created successfullly");

		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@PostMapping("/createSeat/{airplaneId}")
	public ResponseEntity<ResponseMessage> createSeat(@RequestBody SeatDTO seat, @PathVariable Long airplaneId) {

		Seat s = seatService.create(seat, airplaneId);

		if (s == null) {
			message.setMessage("Not able to create seat!");

			return new ResponseEntity<ResponseMessage>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@PostMapping("/update/{id}")
	public ResponseEntity<ResponseMessage> update(@PathVariable Long id) {
		
		Seat s = seatService.getOne(id);
		
		if (s == null) {	
			message.setMessage("Not able to create seat!");

			return new ResponseEntity<ResponseMessage>(HttpStatus.BAD_REQUEST);
		}

		Seat ss = seatService.update(s);
		
		if (ss == null) {	
			message.setMessage("Not able to create seat!");

			return new ResponseEntity<ResponseMessage>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@PostMapping("/delete/{id}")
	public ResponseEntity<ResponseMessage> delete(@PathVariable Long id) throws ObjectNotFoundException {

		boolean deleted = seatService.delete(id);
		
		if(!deleted) {
			
			message.setMessage("Not able to delete seat!");

			return new ResponseEntity<ResponseMessage>(HttpStatus.BAD_REQUEST);
			
		}
		
		message.setMessage("Seat deleted successfully!");
		
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

}
