package com.airftn.AirFTN.service;

import java.util.List;

import com.airftn.AirFTN.dto.AirplaneDTO;
import com.airftn.AirFTN.model.Airplane;

public interface IAirplaneService {
	
	List<Airplane> findAll();

	Airplane create(AirplaneDTO airplane);
	
	Airplane update(Airplane airplane);
	
	List<Airplane> findAllByCompanyId(Long id);
	
}
