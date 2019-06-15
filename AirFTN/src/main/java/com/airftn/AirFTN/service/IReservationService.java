package com.airftn.AirFTN.service;

import java.util.List;

import com.airftn.AirFTN.dto.ReservationDTO;
import com.airftn.AirFTN.model.Reservation;

public interface IReservationService {
	
	List<Reservation> findAll();
	
	List<Reservation> findAllByPassengerId(Long id);
	
	Reservation getOne(Long id);
	
	Reservation create(ReservationDTO reservation);
	
	Reservation update(Reservation reservation);
	
	Reservation setTicketsToOccupied(Reservation reservation);
}
