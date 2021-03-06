package com.airftn.AirFTN.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
public class Passenger extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(nullable = false)
	private boolean active;

	@JsonIgnore
	@Column(nullable = true)
	@ManyToMany(cascade =CascadeType.ALL, fetch =FetchType.EAGER)
	private List<Passenger> friends;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "passenger")
	List<Reservation> reservations;

	private String registrationLink;

	public Passenger(String email, String username, String password, String firstName, String lastName,
			String passportNumber, String address, String phoneNumber, Date dateOfBirth) {
		super(email, username, password, firstName, lastName, passportNumber, address, phoneNumber, dateOfBirth);
		this.active = false;
		this.registrationLink = username + "_token";
		this.friends = new ArrayList<>();
	}

	public Passenger() {
		super();
		this.active = false;
		this.registrationLink = this.username + "_token";
		this.friends = new ArrayList<>();
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

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Passenger> getFriends() {
		return friends;
	}

	public void setFriends(List<Passenger> friends) {
		this.friends = friends;
	}

}
