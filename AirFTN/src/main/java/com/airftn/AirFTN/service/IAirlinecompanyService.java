package com.airftn.AirFTN.service;

import java.util.List;

import com.airftn.AirFTN.dto.AirlineCompanyDTO;
import com.airftn.AirFTN.model.AirlineAdmin;
import com.airftn.AirFTN.model.AirlineCompany;
import com.airftn.AirFTN.model.User;

public interface IAirlinecompanyService {

	List<AirlineCompany> findAll();
	
	AirlineCompany getOne(Long id);
	
	User findByAdminId(Long id);
	
	AirlineCompany create(AirlineCompanyDTO company);
	
	String update(AirlineCompany company);

	AirlineCompany updateAdmin(AirlineCompany company, AirlineAdmin admin);
	
}
