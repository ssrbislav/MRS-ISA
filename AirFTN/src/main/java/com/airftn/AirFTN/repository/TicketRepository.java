package com.airftn.AirFTN.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airftn.AirFTN.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
	
	List<Ticket> findAllByCompanyId(Long id);
	
	List<Ticket> findAllByFlightId(Long id);
	
	List<Ticket> findAllBySeatOccupiedIsFalse();
	
	Optional<Ticket> findById(Long id);
	
	Ticket findBySeatId(Long id);
	
	List<Ticket> findAllByFastTicketIsTrueAndReservationIsNotNull();

	List<Ticket> findAllByFastTicketIsTrueAndReservationIsNull();

}
