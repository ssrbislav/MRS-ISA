package com.airftn.AirFTN.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airftn.AirFTN.dto.AirplaneDTO;
import com.airftn.AirFTN.enumeration.SeatType;
import com.airftn.AirFTN.model.AirlineCompany;
import com.airftn.AirFTN.model.Airplane;
import com.airftn.AirFTN.model.Seat;
import com.airftn.AirFTN.repository.AirplaneRepository;

@Service
@Transactional
public class AirplaneService implements IAirplaneService {

	@Autowired
	AirplaneRepository airplaneRepository;

	@Autowired
	AirlinecompanyService airlineService;

	@Override
	public List<Airplane> findAll() {

		return airplaneRepository.findAll();
	}

	@Override
	public Airplane getOne(Long id) {
		return airplaneRepository.getOne(id);
	}

	@Override
	public Airplane create(AirplaneDTO airplane) {

		AirlineCompany company = airlineService.getOne(airplane.getAirlineId());

		List<Seat> seats = new ArrayList<>();

		Airplane plane = new Airplane();
		plane.setModel(airplane.getModel());
		plane.setNumberOfSeats(airplane.getNumberOfSeats());
		plane.setCompany(company);

		for (int j = 0; j < airplane.getNumberOfSeats(); j++) {
			for (int i = 0; i < 6; i++) {
				Seat s = new Seat();
				s.setColumn(i);
				s.setRow(j);
				s.setAirplane(plane);
				s.setSeatType(SeatType.ECONOMY_CLASS);
				seats.add(s);
			}
		}

		plane.setSeats(seats);

		return airplaneRepository.save(plane);

	}

	@Override
	public Airplane update(Airplane airplane) {

		Airplane plane = airplaneRepository.getOne(airplane.getId());
		plane.setModel(airplane.getModel());
		plane.setNumberOfSeats(airplane.getNumberOfSeats());

		return null;
	}

	@Override
	public Airplane findByFlightId(Long id) {

		Airplane airplane = airplaneRepository.findByFlightId(id);

		return airplane;
	}

	@Override
	public List<Airplane> findAllNotTaken() {

		return airplaneRepository.findAllByTakenIsFalse();
	}

}
