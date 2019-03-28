package com.airftn.AirFTN.service;

import java.util.List;

import com.airftn.AirFTN.model.Passenger;

public interface IPassengerService {
	
	List<Passenger> findAll();
	
	Passenger getOne(Long id);
	
	Passenger create(Passenger passenger);

	Passenger update(Passenger passenger);
	
	boolean delete(Long id);
	
	boolean activate(Long id);
	
}
