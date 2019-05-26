package com.airftn.AirFTN.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class SysAdmin extends User {

	@Column(nullable = false)
	private boolean active;

	@Column(nullable = true)
	private boolean deleted;

	public SysAdmin() {
		super();
	}

	public SysAdmin(String email, String username, String password, String first_name, String last_name, String address,
			String phone_number, Date date_of_birth) {
		super(email, username, password, first_name, last_name, address, phone_number, date_of_birth);
	}

	public SysAdmin(String email, String username, String password, String first_name, String last_name, String address,
			String phone_number, Date date_of_birth, boolean active, boolean deleted) {
		super(email, username, password, first_name, last_name, address, phone_number, date_of_birth);
		this.active = true;
		this.deleted = deleted;
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
