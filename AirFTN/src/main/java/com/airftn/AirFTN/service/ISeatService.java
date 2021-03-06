package com.airftn.AirFTN.service;

import java.util.ArrayList;
import java.util.List;

import com.airftn.AirFTN.dto.SeatDTO;
import com.airftn.AirFTN.model.Seat;

import javassist.tools.rmi.ObjectNotFoundException;

public interface ISeatService {
	
	List<Seat> findAll();

	List<ArrayList<Seat>> findAllByAirplaneId(Long id);
	
	List<Seat> findAllBySeatType(int seatType);
	
	Seat getOne(Long id);
	
	Seat create(SeatDTO seat, Long airplaneId);
	
	Seat update(Seat seat);
	
	boolean delete(Long id) throws ObjectNotFoundException;

	Seat create(SeatDTO seat);
	
	boolean updateSeatType(List<Seat> seats);
	
}
