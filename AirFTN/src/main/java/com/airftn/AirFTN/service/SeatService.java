package com.airftn.AirFTN.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airftn.AirFTN.dto.SeatDTO;
import com.airftn.AirFTN.enumeration.SeatType;
import com.airftn.AirFTN.model.Airplane;
import com.airftn.AirFTN.model.Seat;
import com.airftn.AirFTN.model.Ticket;
import com.airftn.AirFTN.repository.SeatRepository;
import com.airftn.AirFTN.repository.TicketRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class SeatService implements ISeatService {

	@Autowired
	SeatRepository seatRepository;

	@Autowired
	IAirplaneService airplaneService;
	
	@Autowired
	ITicketService ticketService;
	
	@Autowired
	TicketRepository ticketRepository;

	@Override
	public List<Seat> findAll() {

		return seatRepository.findAllByDeletedIsFalse();
	}

	@Override
	public List<ArrayList<Seat>> findAllByAirplaneId(Long id) {

		Airplane airplane = airplaneService.getOne(id);

		List<Seat> seats = seatRepository.findAllByAirplaneId(id);

		List<ArrayList<Seat>> seatMatrix = new ArrayList<ArrayList<Seat>>();

		for (int i = 0; i < airplane.getNumberOfSeats(); i++) {
			ArrayList<Seat> seatsInRow = new ArrayList<>();
			for (Seat s : seats) {
				if (s.getRow() == i)
					seatsInRow.add(s);
			}
			seatMatrix.add(seatsInRow);
		}

		return seatMatrix;
	}

	@Override
	public List<Seat> findAllBySeatType(int seatType) {

		List<Seat> seats = new ArrayList<>();

		SeatType type = null;

		switch (seatType) {
		case 1:
			type = SeatType.BUSINESS_CLASS;
			break;
		case 2:
			type = SeatType.FIRST_CLASS;
			break;
		case 3:
			type = SeatType.ECONOMY_CLASS;
			break;
		}

		if (type == null)
			return null;

		for (Seat s : seatRepository.findAllByDeletedIsFalse()) {
			if (s.getSeatType() == type)
				seats.add(s);
		}

		return seats;
	}

	@Override
	public Seat getOne(Long id) {

		return seatRepository.getOne(id);
	}

	@Override
	public Seat create(SeatDTO seat) {

		Seat s = new Seat();
		s.setRow(seat.getRow());
		s.setColumn(seat.getColumn());
		s.setSeatType(seat.getSeatType());
		s.setDeleted(false);

		return seatRepository.save(s);

	}

	@Override
	public Seat create(SeatDTO seat, Long airplaneId) {

		Airplane airplane = airplaneService.getOne(airplaneId);

		if (airplane == null)
			return null;

		Seat s = new Seat();
		s.setRow(seat.getRow());
		s.setColumn(seat.getColumn());
		s.setAirplane(airplane);
		s.setSeatType(seat.getSeatType());
		s.setDeleted(false);

		return seatRepository.save(s);

	}

	@Override
	public Seat update(Seat seat) {

		Seat s = seatRepository.getOne(seat.getId());
		s.setRow(seat.getRow());
		s.setColumn(seat.getColumn());
		s.setAirplane(seat.getAirplane());
		s.setSeatType(seat.getSeatType());
		s.setDeleted(false);

		return seatRepository.save(s);

	}
	
	
	public void updateTicketPrice(Seat s) {
		
		Ticket ticket = s.getTicket();
		
		ticket.setPrice(ticketService.calculatePrice(ticket));	
		ticketRepository.save(ticket);
	}

	@Override
	public boolean delete(Long id) throws ObjectNotFoundException {

		Seat seat = seatRepository.getOne(id);
		seat.setDeleted(true);
		seatRepository.save(seat);
		return seat.isDeleted();

	}

	@Override
	public boolean updateSeatType(List<Seat> seats) {

		for(Seat seat: seats) {
			Seat s = seatRepository.getOne(seat.getId());
			s.setSeatType(seat.getSeatType());
			updateTicketPrice(s);
			if(seat.isOccupied()) {
				s.setOccupied(true);
			}
			seatRepository.save(s);
		}
		
		return true;
		
	}

}
