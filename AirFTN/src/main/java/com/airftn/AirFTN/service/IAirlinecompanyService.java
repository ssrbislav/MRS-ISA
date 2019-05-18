package com.airftn.AirFTN.service;

import java.util.List;

import com.airftn.AirFTN.model.AirlineCompany;

public interface IAirlinecompanyService {

	List<AirlineCompany> findAll();
	
	AirlineCompany getOne();
	
	AirlineCompany create();
	
	AirlineCompany update();
	
	boolean delete();
	
}
