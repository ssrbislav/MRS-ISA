package com.airftn.AirFTN.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airftn.AirFTN.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
	
	List<Ticket> findAllByCompanyId();
	
	List<Ticket> findAllByFlightId();
	
	Optional<Ticket> findById(Long id);
	
	Ticket findBySeatId();

}
