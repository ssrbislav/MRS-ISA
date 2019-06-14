package com.airftn.AirFTN.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airftn.AirFTN.model.Pricelist;

public interface PricelistRepository extends JpaRepository<Pricelist, Long> {

	Pricelist findByAirlineId(Long id);
	
}
