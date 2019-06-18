package com.airftn.AirFTN.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airftn.AirFTN.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

	List<Reservation> findAllByDeletedIsFalse();

	List<Reservation> findAllByPassengerIdAndDeletedIsFalse(Long id);
	
	List<Reservation> findAllByFastReservationIsFalse();
	
	List<Reservation> findAllByFastReservationIsTrue();
	
	Optional<Reservation> findById(Long id);
	
}
