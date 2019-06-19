package com.airftn.AirFTN.service;

import java.sql.Date;
import java.util.List;

import com.airftn.AirFTN.dto.ReservationDTO;
import com.airftn.AirFTN.model.AirlineCompany;
import com.airftn.AirFTN.model.Reservation;
import com.airftn.AirFTN.model.Ticket;

public interface IReservationService {
	
	List<Reservation> findAll();
	
	List<Reservation> findAllByPassengerId(Long id);
	
	Reservation getOne(Long id);
	
	Reservation create(ReservationDTO reservation);
	
	Reservation update(Reservation reservation);
	
	Reservation setTicketsToOccupied(Reservation reservation);
	
	boolean cancelReservation(Reservation reservation);
	
	List<Ticket> createBusinessReport(AirlineCompany airline, Date from, Date to);
	
}
