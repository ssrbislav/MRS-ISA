package com.airftn.AirFTN.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airftn.AirFTN.enumeration.SeatType;
import com.airftn.AirFTN.model.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {

	List<Seat> findAllByDeletedIsFalse();
	
	List<Seat> findAllByAirplaneId(Long id);
	
	List<Seat> findAllBySeatType(SeatType seatType);
	
	Optional<Seat> findById(Long id);
	
	boolean delete(Long id);
	
}
