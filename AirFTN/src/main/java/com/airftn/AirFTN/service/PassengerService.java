package com.airftn.AirFTN.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.airftn.AirFTN.dto.PassengerDTO;
import com.airftn.AirFTN.model.Passenger;
import com.airftn.AirFTN.repository.PassengerRepository;

@Service
@Transactional
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

		for (Passenger p : findAll())
			if (p.getUsername().equals(passenger.getUsername()) || p.getEmail().equals(passenger.getEmail()))
				return null;

		Passenger p = new Passenger();
		p.setEmail(passenger.getEmail());
		p.setUsername(passenger.getUsername());
		p.setPassword(passenger.getPassword());
		p.setFirstName(passenger.getFirstName());
		p.setLastName(passenger.getLastName());
		p.setAddress(passenger.getAddress());
		p.setPhoneNumber(passenger.getPhoneNumber());
		p.setDateOfBirth(passenger.getDateOfBirth());
		
		return passengerRepository.save(p);
	}

	@Override
	public Passenger update(Passenger passenger, Long id) {

		Passenger p = passengerRepository.getOne(id);
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		p.setId(id);
		p.setUsername(passenger.getUsername());
		p.setEmail(passenger.getEmail());
		p.setPassword(encoder.encode(passenger.getPassword()));
		p.setFirstName(passenger.getFirstName());
		p.setLastName(passenger.getLastName());
		p.setAddress(passenger.getAddress());
		p.setDateOfBirth(passenger.getDateOfBirth());
		p.setPhoneNumber(passenger.getPhoneNumber());
		p.setActive(passenger.isActive());

		return passengerRepository.save(p);
	}
	
	@Override
	public Passenger update(Passenger passenger) {

		Passenger p = passengerRepository.getOne(passenger.getId());
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		p.setId(passenger.getId());
		p.setUsername(passenger.getUsername());
		p.setEmail(passenger.getEmail());
		p.setPassword(encoder.encode(passenger.getPassword()));
		p.setFirstName(passenger.getFirstName());
		p.setLastName(passenger.getLastName());
		p.setAddress(passenger.getAddress());
		p.setDateOfBirth(passenger.getDateOfBirth());
		p.setPhoneNumber(passenger.getPhoneNumber());
		p.setActive(passenger.isActive());

		return passengerRepository.save(p);
	}

	@Override
	public boolean activate(Long id) {

		for (Passenger passenger : findAll()) {
			if (passenger.getId() == id) {
				passenger.setActive(true);
				passengerRepository.save(passenger);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String getRegistrationLink(Long id) {
		
		Passenger p = passengerRepository.getOne(id);
		
		return p.getRegistrationLink();
	}

}
