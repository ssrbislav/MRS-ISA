package com.airftn.AirFTN.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airftn.AirFTN.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	
}
