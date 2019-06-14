package com.airftn.AirFTN.service;

import java.util.List;

import com.airftn.AirFTN.dto.TicketDTO;
import com.airftn.AirFTN.model.Ticket;

public interface ITicketService {

	List<Ticket> findAll();
	
	List<Ticket> findAllByCompanyId(Long id);
	
	List<Ticket> findAllByFlightId(Long id);
	
	Ticket getOne(Long id);

	Ticket findBySeatId(Long id);
	
	Ticket create(TicketDTO ticket);
	
	Ticket update(Ticket ticket);
	
//	boolean delete();
	
}
