package com.airftn.AirFTN.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airftn.AirFTN.model.SysAdmin;

public interface SysAdminRepository extends JpaRepository<SysAdmin, Long>{

	List<SysAdmin> findAll();
	
	SysAdmin getOne(Long id);
	
	boolean existsByEmail(String email);
	
	boolean existsByUsername(String username);
	
	SysAdmin findByEmail(String email);
	
	SysAdmin findByUsername(String username);
	
}
