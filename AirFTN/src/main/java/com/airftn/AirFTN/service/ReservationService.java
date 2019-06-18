package com.airftn.AirFTN.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airftn.AirFTN.dto.ReservationDTO;
import com.airftn.AirFTN.model.Passenger;
import com.airftn.AirFTN.model.Reservation;
import com.airftn.AirFTN.model.Ticket;
import com.airftn.AirFTN.repository.ReservationRepository;
import com.airftn.AirFTN.repository.TicketRepository;

@Service
public class ReservationService implements IReservationService {

	@Autowired
	ReservationRepository reservationRepository;

	@Autowired
	IPassengerService passengerService;

	@Autowired
	IFlightService flightService;

	@Autowired
	TicketRepository ticketRepository;

	@Override
	public List<Reservation> findAll() {

		return reservationRepository.findAllByDeletedIsFalse();
	}

	@Override
	public List<Reservation> findAllByPassengerId(Long id) {

		return reservationRepository.findAllByPassengerIdAndDeletedIsFalse(id);
	}

	@Override
	public Reservation getOne(Long id) {

		return reservationRepository.getOne(id);
	}

	@Override
	public Reservation create(ReservationDTO reservation) {

		Passenger passenger = passengerService.getOneByUsername(reservation.getUsername());
		
		Ticket ticket = ticketRepository.getOne(reservation.getTicket().getId());
		
		Reservation res = new Reservation();

		if(reservation.isFastReservation())
			res.setFastReservation(true);

		res.setDeleted(false);
		res.setPassenger(passenger);
		res.setTicket(reservation.getTicket());
		
		ticket.getSeat().setOccupied(true);
		
		reservationRepository.save(res);
		
		ticket.setReservation(res);
		
		ticketRepository.save(ticket);

		return res;
	}

	@Override
	public Reservation update(Reservation reservation) {

		Reservation res = reservationRepository.getOne(reservation.getId());
		res.setPassenger(reservation.getPassenger());
		res.setTicket(reservation.getTicket());
		res.setFastReservation(reservation.isFastReservation());
		res.setDeleted(reservation.isDeleted());

		return res;
	}

	@Override
	public Reservation setTicketsToOccupied(Reservation reservation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cancelReservation(Reservation reservation) {
		
		Reservation res = reservationRepository.getOne(reservation.getId());
		
		res.setDeleted(true);
		
		//res.setPassenger(null);

		if(!res.getTicket().isFastTicket()) {
			res.getTicket().getSeat().setOccupied(false);
		}
		
		reservationRepository.save(res);
		
		return true;
	}

}
