package com.airftn.AirFTN.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airftn.AirFTN.model.AirlineAdmin;

public interface AirAdminRepository extends JpaRepository<AirlineAdmin, Long> {

	List<AirlineAdmin> findAll();
	
	AirlineAdmin getOne(Long id);
	
	boolean existsByEmail(String email);
	
	boolean existsByUsername(String username);
	
	AirlineAdmin findByEmail(String email);
		
	AirlineAdmin findByUsername(String username);
	
}
