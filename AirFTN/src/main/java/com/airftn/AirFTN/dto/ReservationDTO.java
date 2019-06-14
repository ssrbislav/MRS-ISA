package com.airftn.AirFTN.dto;

import java.util.List;

import com.airftn.AirFTN.model.Ticket;

public class ReservationDTO {

	private Long passengerId;

	List<Ticket> tickets;

	public Long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Long passengerId) {
		this.passengerId = passengerId;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

}
