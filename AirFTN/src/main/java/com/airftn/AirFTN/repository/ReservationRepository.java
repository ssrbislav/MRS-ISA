package com.airftn.AirFTN.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airftn.AirFTN.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}
