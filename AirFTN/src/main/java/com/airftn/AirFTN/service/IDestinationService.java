package com.airftn.AirFTN.service;

import java.util.List;

import com.airftn.AirFTN.dto.DestinationDTO;
import com.airftn.AirFTN.model.AirlineCompany;
import com.airftn.AirFTN.model.Destination;

public interface IDestinationService {
	
	Destination create(DestinationDTO destination);
	
	List<Destination> findAll();
	
	Destination update(Destination destination);

	Destination findById(Long id);

	List<AirlineCompany> findAllCompanies(Long id);
	
	List<Destination> findAllByCompaniesId(Long id);

}
