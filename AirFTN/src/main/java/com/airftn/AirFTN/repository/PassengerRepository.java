package com.airftn.AirFTN.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airftn.AirFTN.model.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

	Passenger findByUsername(String username);

}
