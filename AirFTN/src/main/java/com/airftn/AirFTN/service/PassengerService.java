package com.airftn.AirFTN.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airftn.AirFTN.dto.PassengerDTO;
import com.airftn.AirFTN.model.Passenger;
import com.airftn.AirFTN.repository.PassengerRepository;

@Service
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
	public Passenger create(PassengerDTO passenger) {
		
		for(Passenger p: findAll()) 
			if(p.getUsername().equals(passenger.getUsername()) || 
					p.getEmail().equals(passenger.getEmail()))
				return null;
		
		Passenger p  = new Passenger(true, passenger.getEmail(), passenger.getUsername(),
				passenger.getPassword(), passenger.getFirst_name(), passenger.getLast_name(),
				passenger.getAddress(), passenger.getPhone_number(), passenger.getDate_of_birth());
		
		return passengerRepository.save(p);
	}

	@Override
	public Passenger update(Passenger passenger) {
		
		Passenger p = passengerRepository.getOne(passenger.getId());
		
		p.setId(passenger.getId());
		p.setUsername(passenger.getUsername());
		p.setEmail(passenger.getEmail());
		p.setFirst_name(passenger.getFirst_name());
		p.setLast_name(passenger.getLast_name());
		p.setAddress(passenger.getAddress());
		p.setDate_of_birth(passenger.getDate_of_birth());
		p.setPhone_number(passenger.getPhone_number());
		p.setActive(passenger.isActive());
		
		return passengerRepository.save(p);
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
