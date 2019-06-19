package com.airftn.AirFTN.service;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airftn.AirFTN.dto.BusinessReportDTO;
import com.airftn.AirFTN.dto.ReservationDTO;
import com.airftn.AirFTN.model.AirlineCompany;
import com.airftn.AirFTN.model.Flight;
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
	
	@Autowired
	IAirlinecompanyService airlineService;

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

		if (reservation.isFastReservation())
			res.setFastReservation(true);

		res.setDeleted(false);
		res.setPassenger(passenger);
		res.setTicket(reservation.getTicket());

		ticket.getSeat().setOccupied(true);

		Reservation r = reservationRepository.save(res);

		ticket.setReservation(r);

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

		// res.setPassenger(null);

		if (!res.getTicket().isFastTicket()) {
			res.getTicket().getSeat().setOccupied(false);
		}

		reservationRepository.save(res);

		return true;
	}

	@Override
	public List<Ticket> createBusinessReport(BusinessReportDTO bussinesReport) {

		 Calendar timeFrom = Calendar.getInstance();
		 timeFrom.setTime(bussinesReport.getFrom());
		
		 Calendar timeTo = Calendar.getInstance();
		 timeTo.setTime(bussinesReport.getTo());
		 
		 
//		 Calendar departure = Calendar.getInstance();
		
		Date from = bussinesReport.getFrom();
		Date to = bussinesReport.getTo();
		
		AirlineCompany airline = airlineService.getOne(bussinesReport.getAirline());

		List<Ticket> brTickets = new ArrayList<>();

		for (Flight flight : airline.getFlights()) {
			
//			departure.setTime(flight.getDepartureDate());
//			
//			if(departure.getTime().after(timeFrom.getTime()))
//				s = true;

			List<Ticket> tickets = ticketRepository.findAllByReservationIsNotNull();

			if (flight.getDepartureDate().after(from) && flight.getDepartureDate().before(to)) {
				List<Ticket> flightTickets = flight.getTickets();

				for (Ticket t : flightTickets) {
					if (tickets.contains(t))
						brTickets.add(t);
				}
			}
		}

		return brTickets;
	}

}
