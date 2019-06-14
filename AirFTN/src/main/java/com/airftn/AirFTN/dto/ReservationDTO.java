package com.airftn.AirFTN.dto;

import java.util.List;

import com.airftn.AirFTN.model.Passenger;
import com.airftn.AirFTN.model.Ticket;

public class ReservationDTO {

	Passenger passenger;

	List<Ticket> tickets;

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

}
