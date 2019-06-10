package com.airftn.AirFTN.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airftn.AirFTN.model.TransferPoint;

public interface TransferPointRepository extends JpaRepository<TransferPoint, Long> {

	public Optional<TransferPoint> findById(Long id);
	
	public List<TransferPoint> findAll();
	
	public List<TransferPoint> findByFlightId(Long id);
	
}
