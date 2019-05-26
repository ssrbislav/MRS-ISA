package com.airftn.AirFTN.service;

import java.util.List;

import com.airftn.AirFTN.dto.AirlineCompanyDTO;
import com.airftn.AirFTN.model.AirlineCompany;
import com.airftn.AirFTN.model.User;

public interface IAirlinecompanyService {

	List<AirlineCompany> findAll();
	
	AirlineCompany getOne(Long id);
	
	User findByAdminId(Long id);
	
	AirlineCompany create(AirlineCompanyDTO company, Long admin_id);
	
	String updateAdmin(AirlineCompany company, Long admin_id);

	String update(AirlineCompany company);
	
}
