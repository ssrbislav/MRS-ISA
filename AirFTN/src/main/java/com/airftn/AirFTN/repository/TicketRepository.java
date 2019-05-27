package com.airftn.AirFTN.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airftn.AirFTN.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
