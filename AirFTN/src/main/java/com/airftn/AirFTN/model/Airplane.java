package com.airftn.AirFTN.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Airplane {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(unique = false, nullable = false)
	private String model;

	@Column(unique = false, nullable = false)
	private int numberOfSeats;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "airplane")
	private List<Seat> seats = new ArrayList<Seat>();

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "plane")
	private Flight flight;

	@ManyToOne(optional = false)
	@JoinColumn(name = "airline_company_id")
	private AirlineCompany company;

	@Column(nullable = true)
	private boolean deleted;

	public Airplane() {
		super();
	}

	public Airplane(Long id, String model, int numberOfSeats, List<Seat> seats, Flight flight, AirlineCompany company,
			boolean deleted) {
		super();
		this.id = id;
		this.model = model;
		this.numberOfSeats = numberOfSeats;
		this.seats = seats;
		this.flight = flight;
		this.company = company;
		this.deleted = deleted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public AirlineCompany getCompany() {
		return company;
	}

	public void setCompany(AirlineCompany company) {
		this.company = company;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}
