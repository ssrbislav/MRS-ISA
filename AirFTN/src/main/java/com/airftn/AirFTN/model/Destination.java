package com.airftn.AirFTN.model;

import javax.persistence.Entity;

@Entity
public class Destination {

	private String city;

	private String country;

	private String description;

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
