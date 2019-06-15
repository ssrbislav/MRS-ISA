package com.airftn.AirFTN.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Passenger extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(nullable = false)
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "passenger")
	List<Reservation> reservations;

	private String registrationLink;

	

	public Passenger(String email, String username, String password, String firstName, String lastName,
			String address, String phoneNumber, Date dateOfBirth) {
		super(email, username, password, firstName, lastName, address, phoneNumber, dateOfBirth);
		this.active = false;
		this.registrationLink = username + "_token";
	}

	public Passenger() {
		super();
		this.active = false;
		this.registrationLink = this.username + "_token";
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

	public String getRegistrationLink() {
		return registrationLink;
	}

	public void setRegistrationLink(String registrationLink) {
		this.registrationLink = registrationLink;
	}

}
