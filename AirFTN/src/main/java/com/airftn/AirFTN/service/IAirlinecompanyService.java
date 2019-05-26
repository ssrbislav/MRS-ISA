package com.airftn.AirFTN.service;

import java.util.List;

import com.airftn.AirFTN.dto.AirlineCompanyDTO;
import com.airftn.AirFTN.model.AirlineCompany;

public interface IAirlinecompanyService {

	List<AirlineCompany> findAll();
	
	AirlineCompany getOne(Long id);
	
	AirlineCompany findByAdminId(Long id);
	
	AirlineCompany create(AirlineCompanyDTO company);
	
	String updateAdmin(AirlineCompany company, Long admin_id);

	AirlineCompany update(AirlineCompany company);
	
}
