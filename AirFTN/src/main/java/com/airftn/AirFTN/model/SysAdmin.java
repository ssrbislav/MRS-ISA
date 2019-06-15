package com.airftn.AirFTN.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
public class SysAdmin extends User {

	@Column(nullable = false)
	private boolean active;

	@Column(nullable = true)
	private boolean deleted;

	public SysAdmin() {
		super();
	}

	public SysAdmin(String email, String username, String password, String firstName, String lastName,
			String address, String phoneNumber, Date dateOfBirth) {
		super(email, username, password, firstName, lastName, address, phoneNumber, dateOfBirth);
		this.active = true;
		this.deleted = false;
	}

	public SysAdmin(String email, String username, String password, String firstName, String lastName,
			String address, String phoneNumber, Date dateOfBirth, boolean active, boolean deleted) {
		super(email, username, password, firstName, lastName, address, phoneNumber, dateOfBirth);
		this.active = true;
		this.deleted = false;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}
