package com.airftn.AirFTN.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airftn.AirFTN.dto.BusinessReportDTO;
import com.airftn.AirFTN.dto.ReservationDTO;
import com.airftn.AirFTN.model.Passenger;
import com.airftn.AirFTN.model.Reservation;
import com.airftn.AirFTN.model.ResponseMessage;
import com.airftn.AirFTN.model.Ticket;
import com.airftn.AirFTN.service.EmailService;
import com.airftn.AirFTN.service.IPassengerService;
import com.airftn.AirFTN.service.IReservationService;
import com.airftn.AirFTN.service.ITicketService;

@CrossOrigin
@RestController
@RequestMapping("api/reservation")
public class ReservationController {

	@Autowired
	IReservationService reservationService;
	
	@Autowired
	IPassengerService passengerService;
	
	@Autowired
	ITicketService ticketService;
	
	@Autowired
	private ThreadPoolTaskExecutor taskExecutor;

	@Autowired
	private EmailService emailThread;

	ResponseMessage message = new ResponseMessage();
	
	@GetMapping("")
	public ResponseEntity<List<Reservation>> findAll() {

		List<Reservation> reservations = reservationService.findAll();

		if (reservations == null)
			return new ResponseEntity<>(HttpStatus.OK);

		return new ResponseEntity<List<Reservation>>(reservations, HttpStatus.OK);
	}

	@GetMapping("/findAllByPassengerId/{id}")
	public ResponseEntity<List<Reservation>> findAllByPassengerId(@PathVariable Long id) {

		List<Reservation> reservations = reservationService.findAllByPassengerId(id);

		if (reservations == null)
			return new ResponseEntity<>(HttpStatus.OK);

		return new ResponseEntity<List<Reservation>>(reservations, HttpStatus.OK);
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Reservation> findById(@PathVariable Long id) {

		Reservation reservation = reservationService.getOne(id);

		if (reservation == null)
			return new ResponseEntity<>(HttpStatus.OK);

		return new ResponseEntity<>(reservation, HttpStatus.OK);
	}
	
	@PostMapping("/createReservation")
	public ResponseEntity<ResponseMessage> createReservation(@RequestBody ReservationDTO reservation) {

		Reservation res = reservationService.create(reservation);
		
		Passenger passenger = passengerService.getOneByUsername(reservation.getUsername());

		if (res == null) {
			message.setMessage("Not able to create reservation!");

			return new ResponseEntity<ResponseMessage>(HttpStatus.BAD_REQUEST);
		}

		message.setMessage("Reservation created successfullly");

		mailSend(passenger.getEmail(), res);
		
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
	
	@PostMapping("/cancelReservation")
	public ResponseEntity<ResponseMessage> cancelReservation(@RequestBody Reservation reservation) {
		
		boolean canceled = reservationService.cancelReservation(reservation);
		
		if (!canceled) {
			message.setMessage("Not able to cancel reservation!");

			return new ResponseEntity<ResponseMessage>(HttpStatus.BAD_REQUEST);
		}
		
		message.setMessage("Reservation canceled!");

		return new ResponseEntity<>(message, HttpStatus.OK);
		
	}
	
	@PostMapping("/createBusinessReport")
	public ResponseEntity<List<Ticket>> createBusinessReport( @RequestBody BusinessReportDTO bussinesReport) {
		
		List<Ticket> tickets = reservationService.createBusinessReport(bussinesReport);
	

		return new ResponseEntity<>(tickets, HttpStatus.OK);
		
	}
	
	private void mailSend(String mailTo, Reservation reservation) {
		
		String title = "Reservation created!";
		
		String content = "\nDEAR " + reservation.getPassenger().getFirstName() + "\nThis is your reservation for flight 'FLIGHT NUMBER': " + reservation.getTicket().getFlight().getFlightNumber()
				+ "\nFrom: " + reservation.getTicket().getFlight().getCompany().getCity() + " - To: "  + reservation.getTicket().getFlight().getDestination().getCity() + 
				"\nDerature date: " + reservation.getTicket().getFlight().getDepartureDate() + " - Arrival date: " + reservation.getTicket().getFlight().getArrivalDate() + 
				"\nDuration of flight is: " + reservation.getTicket().getFlight().getDurationOfFlight() + " | Millage: " + reservation.getTicket().getFlight().getMileage()
				+ "\nNumber of seat: " + reservation.getTicket().getSeat().getRow() + ":" + reservation.getTicket().getSeat().getColumn() +
				"\nPRICE: " + reservation.getTicket().getPrice() + 
				"\n\nHave a nice flight, \n"
				+ reservation.getTicket().getCompany();
		
		emailThread.setup(mailTo, title, content);
		taskExecutor.execute(emailThread);
	}

}
