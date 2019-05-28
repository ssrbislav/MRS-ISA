package com.airftn.AirFTN.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airftn.AirFTN.model.AirlineCompany;
import com.airftn.AirFTN.model.Airplane;

public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
	
	List<Airplane> findAllByCompany(AirlineCompany company);

}
