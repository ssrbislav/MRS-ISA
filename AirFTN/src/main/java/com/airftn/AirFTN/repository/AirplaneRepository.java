package com.airftn.AirFTN.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airftn.AirFTN.model.Airplane;

public interface AirplaneRepository extends JpaRepository<Airplane, Long> {

}
