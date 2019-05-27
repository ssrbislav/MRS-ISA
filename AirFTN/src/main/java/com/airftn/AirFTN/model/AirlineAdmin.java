package com.airftn.AirFTN.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class AirlineAdmin extends User {

	@Column(nullable = false)
	private boolean active;

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH, mappedBy = "admin")
	AirlineCompany airlineCompany;

	@Column(nullable = true)
	private boolean deleted;

	public AirlineAdmin() {
		super();
	}

	public AirlineAdmin(String email, String username, String password, String first_name, String last_name,
			String address, String phone_number, Date date_of_birth) {
		super(email, username, password, first_name, last_name, address, phone_number, date_of_birth);
		this.active = true;
		this.deleted = false;
	}

	public AirlineAdmin(String email, String username, String password, String first_name, String last_name,
			String address, String phone_number, Date date_of_birth, boolean active, AirlineCompany airlineCompany,
			boolean deleted) {
		super(email, username, password, first_name, last_name, address, phone_number, date_of_birth);
		this.airlineCompany = airlineCompany;
		this.active = true;
		this.deleted = false;
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

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}
