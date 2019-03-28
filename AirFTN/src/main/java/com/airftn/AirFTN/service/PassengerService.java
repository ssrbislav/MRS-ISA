package com.airftn.AirFTN.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.airftn.AirFTN.model.Passenger;
import com.airftn.AirFTN.repository.PassengerRepository;

public class PassengerService implements IPassengerService {

	@Autowired
	PassengerRepository passengerRepository;

	@Override
	public List<Passenger> findAll() {

		return passengerRepository.findAll();
	}

	@Override
	public Passenger getOne(Long id) {

		return passengerRepository.getOne(id);
	}

	@Override
	public Passenger create(Passenger passenger) {
		
		for(Passenger p: findAll()) 
			if(p.getUsername().equals(passenger.getUsername()) || 
					p.getEmail().equals(passenger.getEmail()))
				return null;
		
		return passengerRepository.save(passenger);
	}

	@Override
	public Passenger update(Passenger passenger) {
		
		return passengerRepository.save(passenger);
	}

	@Override
	public boolean delete(Long id) {

		for(Passenger passenger: findAll()) {
			if(passenger.getId() == id) {
				passengerRepository.delete(passenger);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean activate(Long id) {

		// Implement activate method
		return false;
	}

}
