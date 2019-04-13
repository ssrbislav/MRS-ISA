package com.airftn.AirFTN.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Passenger extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(nullable = false)
	private boolean active;

	public Passenger(String email, String username, String password, String first_name, String last_name, String address,
			String phone_number, Date date_of_birth) {
		super(email, username, password, first_name, last_name, address, phone_number, date_of_birth);
		this.active = false;
	}
	
	public Passenger() {
		super();
		this.active = false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
