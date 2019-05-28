package com.airftn.AirFTN.service;

import java.util.List;

import com.airftn.AirFTN.dto.AirplaneDTO;
import com.airftn.AirFTN.model.Airplane;

import javassist.tools.rmi.ObjectNotFoundException;

public interface IAirplaneService {
	
	List<Airplane> findAll();

	Airplane create(AirplaneDTO airplane) throws ObjectNotFoundException;
	
	Airplane update(Airplane airplane);
	
}
