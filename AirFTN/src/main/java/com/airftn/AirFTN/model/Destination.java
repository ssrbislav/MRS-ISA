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
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinTable(name = "destinations",
    joinColumns = { @JoinColumn(name = "destination_id") },
    inverseJoinColumns = { @JoinColumn(name = "airline_company_id") })
	private List<AirlineCompany> companies = new ArrayList<AirlineCompany>();

	public Destination() {
	}

	public Destination(String city, String country, String description) {
		super();
		this.city = city;
		this.country = country;
		this.description = description;
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

}
