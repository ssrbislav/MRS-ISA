package com.airftn.AirFTN.dto;

import com.airftn.AirFTN.model.Ticket;

public class ReservationDTO {

	private String username;

	Ticket ticket;

	private boolean fastReservation;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public boolean isFastReservation() {
		return fastReservation;
	}

	public void setFastReservation(boolean fastReservation) {
		this.fastReservation = fastReservation;
	}

}
