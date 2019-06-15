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

		return reservationRepository.findAllByPassengerId(id);
	}

	@Override
	public Reservation getOne(Long id) {

		return reservationRepository.getOne(id);
	}

	@Override
	public Reservation create(ReservationDTO reservation) {

		Passenger passenger = passengerService.getOne(reservation.getPassengerId());
		
		Reservation res = new Reservation();

		//Flight flight = flightService.getOne(flightId);

		//List<Ticket> tickets = new ArrayList<>();

		//Pricelist pricelist = flight.getCompany().getPricelist();

//		for (Seat seat : seats) {
//			Ticket ticket = new Ticket();
//			ticket.setCompany(flight.getCompany());
//			ticket.setDeleted(false);
//			ticket.setFlight(flight);
//			ticket.setSeat(seat);
//			ticket.setPrice(calculatePrice(pricelist, flight, seat, res.isFastReservation()));
//
//			ticketRepository.save(ticket);
//			tickets.add(ticket);
//		}
		
		for(Ticket ticket: reservation.getTickets()) {
			if(ticket.isFastTicket())
				reservation.setFastReservation(true);
		}

		res.setDeleted(false);
		res.setPassenger(passenger);
		res.setTickets(reservation.getTickets());
		setTicketsToOccupied(res);

		return reservationRepository.save(res);
	}

	@Override
	public Reservation update(Reservation reservation) {

		Reservation res = reservationRepository.getOne(reservation.getId());
		res.setPassenger(reservation.getPassenger());
		res.setTickets(reservation.getTickets());
		res.setFastReservation(reservation.isFastReservation());
		res.setDeleted(reservation.isDeleted());

		return res;
	}

	@Override
	public Reservation setTicketsToOccupied(Reservation reservation) {

		List<Ticket> tickets = reservation.getTickets();

		for (Ticket t : tickets) {
			t.getSeat().setOccupied(true);
		}

		return reservation;
	}
//
//	public double calculatePrice(Pricelist pricelist, Flight flight, Seat seat, boolean isFastReservation) {
//
//		double price = flight.getPrice();
//		double totalPrice = price;
//
//		if (isFastReservation) {
//			price = price * (pricelist.getDiscountedPrecentage() / 100);
//			totalPrice -= price;
//			return totalPrice;
//		}
//
//		if (seat.getSeatType() == SeatType.ECONOMY_CLASS) {
//			price = price * (pricelist.getEconomyPricePrecentage() / 100);
//			totalPrice -= price;
//		}
//		if (seat.getSeatType() == SeatType.BUSINESS_CLASS) {
//			price = price * (pricelist.getBussinessPricePrecentage() / 100);
//			totalPrice -= price;
//		}
//		if (seat.getSeatType() == SeatType.FIRST_CLASS) {
//			price = price * (pricelist.getFirstPricePrecentage() / 100);
//			totalPrice -= price;
//		}
//
//		return totalPrice;
//	}
}
