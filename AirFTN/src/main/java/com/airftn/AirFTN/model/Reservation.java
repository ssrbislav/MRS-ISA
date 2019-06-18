package com.airftn.AirFTN.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "passenger_id")
	Passenger passenger;

	@OneToOne(mappedBy = "reservation")
	Ticket ticket;

	@Column(nullable = false)
	private boolean fastReservation;

	@Column(nullable = true)
	private boolean deleted;

	public Reservation() {
		super();
	}

	public Reservation(Long id, Passenger passenger, Ticket ticket, boolean fastReservation, boolean deleted) {
		super();
		this.id = id;
		this.passenger = passenger;
		this.ticket = ticket;
		this.fastReservation = fastReservation;
		this.deleted = deleted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public boolean isFastReservation() {
		return fastReservation;
	}

	public void setFastReservation(boolean fastReservation) {
		this.fastReservation = fastReservation;
	}

}
