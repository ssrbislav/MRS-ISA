package com.airftn.AirFTN.dto;

import java.util.List;

import com.airftn.AirFTN.model.Ticket;

public class ReservationDTO {

	private Long passengerId;

	List<Ticket> tickets;

	private boolean fastReservation;

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

	public boolean isFastReservation() {
		return fastReservation;
	}

	public void setFastReservation(boolean fastReservation) {
		this.fastReservation = fastReservation;
	}

}
