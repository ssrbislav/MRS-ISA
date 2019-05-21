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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class AirlineCompany {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(unique = true, nullable = false)
	private String name;

	@Column(unique = true, nullable = false)
	private String city;

	@Column(nullable = false, unique = false)
	private String address;

	@Column(nullable = false, unique = false)
	private String description;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")
	private List<Airplane> planes = new ArrayList<Airplane>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")
	private List<Flight> flights = new ArrayList<Flight>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "companies")
	private List<Destination> destinations = new ArrayList<Destination>();

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "company")
	private List<Ticket> fastReservationTickets = new ArrayList<Ticket>();

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "admin_id", nullable = false)
	private AirlineAdmin admin;

	public AirlineCompany() {
		super();
	}

	public AirlineCompany(Long id, String name, String city, String address, String description, List<Airplane> planes,
			List<Flight> flights, List<Destination> destinations, List<Ticket> fastReservationTickets,
			AirlineAdmin admin) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.address = address;
		this.description = description;
		this.planes = planes;
		this.flights = flights;
		this.destinations = destinations;
		this.fastReservationTickets = fastReservationTickets;
		this.admin = admin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AirlineAdmin getAdmin() {
		return admin;
	}

	public void setAdmin(AirlineAdmin admin) {
		this.admin = admin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Airplane> getPlanes() {
		return planes;
	}

	public void setPlanes(List<Airplane> planes) {
		this.planes = planes;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public List<Destination> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<Destination> destinations) {
		this.destinations = destinations;
	}

	public List<Ticket> getFastReservationTickets() {
		return fastReservationTickets;
	}

	public void setFastReservationTickets(List<Ticket> fastReservationTickets) {
		this.fastReservationTickets = fastReservationTickets;
	}

}
