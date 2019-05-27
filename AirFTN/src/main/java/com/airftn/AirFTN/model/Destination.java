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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Destination {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(unique = false, nullable = false)
	private String city;

	@Column(unique = false, nullable = false)
	private String country;

	@Column(unique = false, nullable = false)
	private String description;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "destination")
	private List<Flight> flights;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinTable(name = "destinations", joinColumns = { @JoinColumn(name = "destination_id") }, inverseJoinColumns = {
			@JoinColumn(name = "airline_company_id") })
	private List<AirlineCompany> companies = new ArrayList<AirlineCompany>();

	@Column(nullable = false)
	private boolean deleted;

	public Destination() {
	}

	public Destination(Long id, String city, String country, String description, List<Flight> flights,
			List<AirlineCompany> companies, boolean deleted) {
		super();
		this.id = id;
		this.city = city;
		this.country = country;
		this.description = description;
		this.flights = flights;
		this.companies = companies;
		this.deleted = deleted;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public List<AirlineCompany> getCompanies() {
		return companies;
	}

	public void setCompanies(List<AirlineCompany> companies) {
		this.companies = companies;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}
