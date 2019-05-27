package com.airftn.AirFTN.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.airftn.AirFTN.model.AirlineCompany;

public interface AirlinecompanyRepository extends JpaRepository<AirlineCompany, Long> {

	List<AirlineCompany> findAll();
	
	Optional<AirlineCompany> findById(Long id);
	
	AirlineCompany findByName(String name);
	
	AirlineCompany findByAdminId(Long id);
}
