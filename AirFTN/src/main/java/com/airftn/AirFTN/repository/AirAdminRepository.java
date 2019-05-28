package com.airftn.AirFTN.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airftn.AirFTN.model.AirlineAdmin;

public interface AirAdminRepository extends JpaRepository<AirlineAdmin, Long> {

	List<AirlineAdmin> findAll();
	
	Optional<AirlineAdmin> findById(Long id);
	
	boolean existsByEmail(String email);
	
	boolean existsByUsername(String username);
	
	AirlineAdmin findByEmail(String email);
		
	AirlineAdmin findByUsername(String username);
	
	List<AirlineAdmin> findAllByHasCompanyFalse();
	
}
