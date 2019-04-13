package com.airftn.AirFTN.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airftn.AirFTN.model.Passenger;
import com.airftn.AirFTN.model.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

	VerificationToken findByToken(String token);

	VerificationToken findByPassenger(Passenger passenger);
}
