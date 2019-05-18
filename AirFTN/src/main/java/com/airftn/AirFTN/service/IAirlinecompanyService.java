package com.airftn.AirFTN.service;

import java.util.List;

import com.airftn.AirFTN.dto.AirlineCompanyDTO;
import com.airftn.AirFTN.model.AirlineAdmin;
import com.airftn.AirFTN.model.AirlineCompany;

public interface IAirlinecompanyService {

	List<AirlineCompany> findAll();
	
	AirlineCompany getOne(Long id);
	
	AirlineCompany create(AirlineCompanyDTO company);
	
	String update(AirlineCompany company);
	
	boolean delete(Long id);

	AirlineCompany updateAdmin(AirlineCompany company, AirlineAdmin admin);
	
}
