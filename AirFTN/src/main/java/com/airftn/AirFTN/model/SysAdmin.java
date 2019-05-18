package com.airftn.AirFTN.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class SysAdmin extends User {

	@Column(nullable = false)
	private boolean active;

	public SysAdmin() {
		super();
	}

	public SysAdmin(String email, String username, String password, String first_name, String last_name, String address,
			String phone_number, Date date_of_birth) {
		super(email, username, password, first_name, last_name, address, phone_number, date_of_birth);
	}

	public SysAdmin(String email, String username, String password, String first_name, String last_name, String address,
			String phone_number, Date date_of_birth, boolean active) {
		super(email, username, password, first_name, last_name, address, phone_number, date_of_birth);
		this.active = true;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
