package com.airftn.AirFTN.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
public class AirlineAdmin extends User {

	@Column(nullable = false)
	private boolean active;

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH, mappedBy = "admin")
	AirlineCompany airlineCompany;

	@Column(nullable = false)
	boolean hasCompany;

	@Column(nullable = true)
	private boolean deleted;

	public AirlineAdmin() {
		super();
	}

	public AirlineAdmin(@Email String email, String username, String password, String firstName, String lastName,
			String address, String phoneNumber, Date dateOfBirth, boolean active, AirlineCompany airlineCompany,
			boolean hasCompany, boolean deleted) {
		super(email, username, password, firstName, lastName, phoneNumber, address, phoneNumber, dateOfBirth);
		this.active = true;
		this.airlineCompany = airlineCompany;
		this.hasCompany = false;
		this.deleted = false;
	}

	public AirlineAdmin(@Email String email, String username, String password, String firstName, String lastName,
			String address, String phoneNumber, Date dateOfBirth) {
		super(email, username, password, firstName, lastName, phoneNumber, address, phoneNumber, dateOfBirth);
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

	public boolean isHasCompany() {
		return hasCompany;
	}

	public void setHasCompany(boolean hasCompany) {
		this.hasCompany = hasCompany;
	}

}
