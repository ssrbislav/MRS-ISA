package com.airftn.AirFTN.model;

import java.util.Date;

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
	private Date departureDate;

	@Column(nullable = false)
	private Date arrivalDate;

	@Column(nullable = false)
	private int durationOfFlight;

	@Column(nullable = false)
	private int numberOfTransferPoints;

	@Column(nullable = false)
	private String transferCity;
	
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinColumn(name = "destination_id", nullable = false)
	private Destination destination;

	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinColumn(nullable = false, name = "airplane_id")
	private Airplane plane;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinColumn(nullable = false, name = "company_id")
	private AirlineCompany company;

	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Flight(Long id, String flightNumber, double price, double mileage, Date departureDate, Date arrivalDate,
			int durationOfFlight, int numberOfTransferPoints, String transferCity,
			Destination destination, Airplane plane, AirlineCompany company) {
		super();
		this.id = id;
		this.flightNumber = flightNumber;
		this.price = price;
		this.mileage = mileage;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.durationOfFlight = durationOfFlight;
		this.numberOfTransferPoints = numberOfTransferPoints;
		this.transferCity = transferCity;
		this.destination = destination;
		this.plane = plane;
		this.company = company;
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

	public int getDurationOfFlight() {
		return durationOfFlight;
	}

	public void setDurationOfFlight(int durationOfFlight) {
		this.durationOfFlight = durationOfFlight;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public int getNumberOfTransferPoints() {
		return numberOfTransferPoints;
	}

	public void setNumberOfTransferPoints(int numberOfTransferPoints) {
		this.numberOfTransferPoints = numberOfTransferPoints;
	}

	public String getTransferCitie() {
		return transferCity;
	}

	public void setTransferCities(String transferCitie) {
		this.transferCity = transferCitie;
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

}
