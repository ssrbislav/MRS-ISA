package com.airftn.AirFTN.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airftn.AirFTN.dto.SeatDTO;
import com.airftn.AirFTN.enumeration.SeatType;
import com.airftn.AirFTN.model.Airplane;
import com.airftn.AirFTN.model.Seat;
import com.airftn.AirFTN.repository.SeatRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class SeatService implements ISeatService {

	@Autowired
	SeatRepository seatRepository;

	@Autowired
	IAirplaneService airplaneService;

	@Override
	public List<Seat> findAll() {

		return seatRepository.findAllByDeletedIsFalse();
	}

	@Override
	public List<Seat> findAllByAirplaneId(Long id) {

		return seatRepository.findAllByAirplaneId(id);
	}

	@Override
	public List<Seat> findAbbBySeatType(SeatType seatType) {

		return seatRepository.findAllBySeatType(seatType);
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
	public Seat create(SeatDTO seat, Long ariplaneId) {

		Airplane airplane = airplaneService.getOne(ariplaneId);

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
		s.setDeleted(false);

		return seatRepository.save(s);

	}

	@Override
	public boolean delete(Long id) throws ObjectNotFoundException {

		Seat seat = seatRepository.getOne(id);
		seat.setDeleted(true);
		return seat.isDeleted();

	}

}
