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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Long id;

	@Column(nullable = false, unique = false)
	private double price;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "seat_id", nullable = false)
	private Seat seat;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "flight_id", nullable = false)
	private Flight flight;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(nullable = false, name = "company_id")
	private AirlineCompany company;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "reservation_id")
	private Reservation reservation;

	@Column(nullable = false)
	private boolean fastTicket;

	@Column(nullable = true)
	private boolean deleted;

	public Ticket() {
		super();
	}

	public Ticket(Long id, double price, Seat seat, Flight flight, AirlineCompany company, Reservation reservation,
			boolean fastTicket, boolean deleted) {
		super();
		this.id = id;
		this.price = price;
		this.seat = seat;
		this.flight = flight;
		this.company = company;
		this.reservation = reservation;
		this.fastTicket = fastTicket;
		this.deleted = deleted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public AirlineCompany getCompany() {
		return company;
	}

	public void setCompany(AirlineCompany company) {
		this.company = company;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@JsonIgnore
	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@JsonIgnore
	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public boolean isFastTicket() {
		return fastTicket;
	}

	public void setFastTicket(boolean fastTicket) {
		this.fastTicket = fastTicket;
	}

}
