package com.airftn.AirFTN.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airftn.AirFTN.dto.AirplaneDTO;
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
		
		for(int j = 0; j < 4; j++) {
			for(int i = 0; i < airplane.getNumberOfSeats(); i++) {
				Seat s = new Seat();
				s.setColumn(j);
				s.setRow(i);
				s.setAirplane(plane);
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

}
