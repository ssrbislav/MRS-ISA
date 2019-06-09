package com.airftn.AirFTN.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class TransferPoint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Long id;

	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm")
	private Date arivalTime;

	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm")
	private Date departureTime;

	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm")
	private String countryAndCity;

	@Column(nullable = true)
	private boolean deleted;

	public TransferPoint() {
		super();
	}

	public TransferPoint(Long id, Date arivalTime, Date departureTime, String countryAndCity, boolean deleted) {
		super();
		this.id = id;
		this.arivalTime = arivalTime;
		this.departureTime = departureTime;
		this.countryAndCity = countryAndCity;
		this.deleted = deleted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getArivalTime() {
		return arivalTime;
	}

	public void setArivalTime(Date arivalTime) {
		this.arivalTime = arivalTime;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public String getCountryAndCity() {
		return countryAndCity;
	}

	public void setCountryAndCity(String countryAndCity) {
		this.countryAndCity = countryAndCity;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}
