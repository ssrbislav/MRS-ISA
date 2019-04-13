package com.airftn.AirFTN.model;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class VerificationToken {

	private static final int EXPIRATION = 60 * 24;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	private String token;

	@OneToOne(targetEntity = Passenger.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "user_id")
	private Passenger passenger;

	private Date expiryDate;

	public VerificationToken(Long id, String token, Passenger passenger, Date expiryDate) {
		super();
		this.id = id;
		this.token = token;
		this.passenger = passenger;
		this.expiryDate = expiryDate;
	}

	public VerificationToken(String token2, Passenger passenger) {
		super();
		this.token = token2;
		this.passenger = passenger;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	private Date calculateExpiryDate(int expiryTimeInMinutes) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Timestamp(cal.getTime().getTime()));
		cal.add(Calendar.MINUTE, expiryTimeInMinutes);
		return new Date(cal.getTime().getTime());
	}
	
}