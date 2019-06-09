package com.airftn.AirFTN.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airftn.AirFTN.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

	List<Flight> findAll();
	
	Optional<Flight> findById(Long id);
	
	List<Flight> findAllByCompanyId(Long id);
	
	List<Flight> findAllByDeletedIsFalse();

	Flight save(Optional<Flight> f);
	
}
