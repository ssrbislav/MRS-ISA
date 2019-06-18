package com.airftn.AirFTN.model;

import java.util.ArrayList;
import java.util.Date;
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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Long id;

	@Column(nullable = false)
	private String flightNumber;

	@Column(nullable = false)
	private double price;

	@Column(nullable = false)
	private double mileage;

	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm")
	private Date departureDate;

	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm")
	private Date arrivalDate;

	@Column(nullable = false)
	private double durationOfFlight;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinColumn(name = "destination_id", nullable = false)
	private Destination destination;

	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinColumn(nullable = false, name = "airplane_id")
	private Airplane plane;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinColumn(nullable = false, name = "company_id")
	private AirlineCompany company;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "flight")
	private List<TransferPoint> transferPoints = new ArrayList<TransferPoint>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "flight")
	private List<Ticket> tickets = new ArrayList<Ticket>();

	@Column(nullable = false)
	private boolean deleted;

	public Flight() {
		super();
	}

	public Flight(Long id, String flightNumber, double price, double mileage, Date departureDate, Date arrivalDate,
			double durationOfFlight, Destination destination, Airplane plane, AirlineCompany company,
			List<TransferPoint> transferPoints, List<Ticket> tickets, boolean deleted) {
		super();
		this.id = id;
		this.flightNumber = flightNumber;
		this.price = price;
		this.mileage = mileage;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.durationOfFlight = durationOfFlight;
		this.destination = destination;
		this.plane = plane;
		this.company = company;
		this.transferPoints = transferPoints;
		this.tickets = tickets;
		this.deleted = deleted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public double getDurationOfFlight() {
		return durationOfFlight;
	}

	public void setDurationOfFlight(double durationOfFlight) {
		this.durationOfFlight = durationOfFlight;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public Airplane getPlane() {
		return plane;
	}

	public void setPlane(Airplane plane) {
		this.plane = plane;
	}

	public AirlineCompany getCompany() {
		return company;
	}

	public void setCompany(AirlineCompany company) {
		this.company = company;
	}

	public List<TransferPoint> getTransferPoints() {
		return transferPoints;
	}

	public void setTransferPoints(List<TransferPoint> transferPoints) {
		this.transferPoints = transferPoints;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@JsonIgnore
	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

}
