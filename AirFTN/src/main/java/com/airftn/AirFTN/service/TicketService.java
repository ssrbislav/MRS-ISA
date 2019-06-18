package com.airftn.AirFTN.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airftn.AirFTN.dto.SeatDTO;
import com.airftn.AirFTN.dto.TicketDTO;
import com.airftn.AirFTN.enumeration.SeatType;
import com.airftn.AirFTN.model.AirlineCompany;
import com.airftn.AirFTN.model.Airplane;
import com.airftn.AirFTN.model.Flight;
import com.airftn.AirFTN.model.Pricelist;
import com.airftn.AirFTN.model.Seat;
import com.airftn.AirFTN.model.Ticket;
import com.airftn.AirFTN.repository.SeatRepository;
import com.airftn.AirFTN.repository.TicketRepository;

@Service
public class TicketService implements ITicketService {

	@Autowired
	TicketRepository ticketRepository;

	@Autowired
	IAirlinecompanyService airlineService;

	@Autowired
	IFlightService flightService;

	@Autowired
	ISeatService seatService;

	@Autowired
	SeatRepository seatRepository;

	@Autowired
	IPricelistService pricelistService;
	
	@Autowired
	IAirplaneService airplaneService;

	@Override
	public List<Ticket> findAll() {

		return ticketRepository.findAll();
	}

	@Override
	public List<Ticket> findAllByCompanyId(Long id) {

		return ticketRepository.findAllByCompanyId(id);
	}

	@Override
	public List<Ticket> findAllByFlightId(Long id) {

		return ticketRepository.findAllByFlightId(id);
	}

	@Override
	public Ticket getOne(Long id) {

		return ticketRepository.getOne(id);
	}

	@Override
	public Ticket findBySeatId(Long id) {

		return ticketRepository.findBySeatId(id);
	}

	@Override
	public Ticket create(TicketDTO ticket) {

		AirlineCompany company = airlineService.getOne(ticket.getAirlineId());

		Flight flight = flightService.getOne(ticket.getFlightId());

		Seat seat = seatService.getOne(ticket.getSeatId());

		Ticket t = new Ticket();
		t.setCompany(company);
		t.setDeleted(false);
		t.setPrice(calculatePrice(t));
		t.setSeat(seat);
		t.setFlight(flight);

		return ticketRepository.save(t);
	}

	@Override
	public Ticket createFastTicket(SeatDTO seat) {
		
		Ticket ticket = ticketRepository.findBySeatId(seat.getId());
		
		Seat s = seatService.getOne(seat.getId());
		
		Airplane airplane = airplaneService.getOne(seat.getAirplaneId());
		
		ticket.setFastTicket(true);
		s.setOccupied(true);
		s.setAirplane(airplane);
		
		seatRepository.save(s);

		return update(ticket);
	}

	@Override
	public double calculatePrice(Ticket ticket) {

		double totalPrice = 0;

		double price = 0;

		AirlineCompany company = ticket.getCompany();

		Seat seat = ticket.getSeat();

		Pricelist pricelist = company.getPricelist();

		SeatType seatClass = seat.getSeatType();

		if (seatClass == SeatType.ECONOMY_CLASS) {
			price = pricelist.getEconomyPricePrecentage();
			totalPrice *= ((price / 100) + 1);
		} else if (seatClass == SeatType.BUSINESS_CLASS) {
			price = pricelist.getEconomyPricePrecentage();
			totalPrice *= ((price / 100) + 1);
		} else if (seatClass == SeatType.FIRST_CLASS) {
			price = pricelist.getEconomyPricePrecentage();
			totalPrice *= ((price / 100) + 1);
		}
		
		if(ticket.isFastTicket()) {
			totalPrice *= ((price / 100) - 1);
		}

		return totalPrice;
	}

	@Override
	public Ticket update(Ticket ticket) {

		Ticket t = ticketRepository.getOne(ticket.getId());
		t.setCompany(ticket.getCompany());
		t.setDeleted(ticket.isDeleted());
		t.setSeat(ticket.getSeat());
		t.setPrice(calculatePrice(ticket));

		return ticketRepository.save(t);
	}

	@Override
	public List<Ticket> findAllFastTickets() {

		return ticketRepository.findAllByFastTicketIsTrue();
	}

	// public Ticket updateTicketPrice(List<Ticket> tickets) {
	//
	// for(Ticket ticket : tickets) {
	// Ticket t = ticketRepository.getOne(ticket.getId());
	// t.setPrice(calculatePrice(ticket));
	// }

	// hhhmmmm, ovo bi trebalo izmeniti
	//
	//
	// }
	//

}
