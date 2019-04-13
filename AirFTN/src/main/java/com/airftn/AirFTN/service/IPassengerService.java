package com.airftn.AirFTN.service;

import java.util.List;

import com.airftn.AirFTN.dto.PassengerDTO;
import com.airftn.AirFTN.model.Passenger;
import com.airftn.AirFTN.model.User;
import com.airftn.AirFTN.model.VerificationToken;

public interface IPassengerService {
	
	List<Passenger> findAll();
	
	Passenger getOne(Long id);
	
	Passenger create(PassengerDTO passenger);

	Passenger update(Passenger passenger);
	
	boolean delete(Long id);
	
	boolean activate(Long id);

	void createVerificationToken(Passenger passenger, String token);

	VerificationToken getVerificationToken(String token);
	
}
