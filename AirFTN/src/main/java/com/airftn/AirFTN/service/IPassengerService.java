package com.airftn.AirFTN.service;

import java.util.List;

import com.airftn.AirFTN.dto.PassengerDTO;
import com.airftn.AirFTN.model.Passenger;

public interface IPassengerService {

	List<Passenger> findAll();

	Passenger getOne(Long id);

	Passenger create(PassengerDTO passenger);

	Passenger update(Passenger passenger);

	//boolean delete(Long id);

	boolean activate(Long id);
	
	public String getRegistrationLink(Long id);

}
