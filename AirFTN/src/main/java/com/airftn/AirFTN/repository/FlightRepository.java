package com.airftn.AirFTN.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airftn.AirFTN.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

	List<Flight> findAll();
	
	Flight getOne(Long id);
	
	List<Flight> findAllByCompanyId(Long id);
	
}
