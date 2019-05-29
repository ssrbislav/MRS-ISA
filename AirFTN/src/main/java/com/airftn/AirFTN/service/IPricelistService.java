package com.airftn.AirFTN.service;

import java.util.List;

import com.airftn.AirFTN.dto.PricelistDTO;
import com.airftn.AirFTN.model.Pricelist;

public interface IPricelistService {

	List<Pricelist> findAll();
	
	Pricelist getOne(Long id);
	
	Pricelist create(PricelistDTO pricelist,  Long companyId);
	
	Pricelist update(Pricelist pricelist);
	
}
