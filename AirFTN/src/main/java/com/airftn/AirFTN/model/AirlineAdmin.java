package com.airftn.AirFTN.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
public class AirlineAdmin extends User {

	@Column(nullable = false)
	private boolean active;

	@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.DETACH, mappedBy = "admin")
	AirlineCompany airlineCompany;

	public AirlineAdmin() {
		super();
	}

	public AirlineAdmin(String email, String username, String password, String first_name, String last_name,
			String address, String phone_number, Date date_of_birth) {
		super(email, username, password, first_name, last_name, address, phone_number, date_of_birth);
	}

	public AirlineAdmin(String email, String username, String password, String first_name, String last_name,
			String address, String phone_number, Date date_of_birth, boolean active, AirlineCompany airlineCompany) {
		super(email, username, password, first_name, last_name, address, phone_number, date_of_birth);
		this.active = true;
		this.airlineCompany = airlineCompany;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public AirlineCompany getAirlineCompany() {
		return airlineCompany;
	}

	public void setAirlineCompany(AirlineCompany airlineCompany) {
		this.airlineCompany = airlineCompany;
	}

}
