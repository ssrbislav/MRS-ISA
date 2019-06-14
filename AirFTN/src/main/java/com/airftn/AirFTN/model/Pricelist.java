package com.airftn.AirFTN.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pricelist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Long id;

	@Column(nullable = false)
	private Double priceByKm;

	@Column(nullable = false)
	private Double economyPricePrecentage;

	@Column(nullable = false)
	private Double bussinessPricePrecentage;

	@Column(nullable = false)
	private Double firstPricePrecentage;

	@Column(nullable = false)
	private Double discountedPrecentage;

	@Column(nullable = false)
	private boolean deleted;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "airline_company_id", referencedColumnName = "id", unique = true)
	AirlineCompany airline;

	public Pricelist() {
		super();
		this.deleted = false;
	}

	public Pricelist(Double priceByKm, Double economyPricePrecentage, Double bussinessPricePrecentage,
			Double firstPricePrecentage, Double discountedPrecentage, boolean deleted, AirlineCompany airline) {
		super();
		this.priceByKm = priceByKm;
		this.economyPricePrecentage = economyPricePrecentage;
		this.bussinessPricePrecentage = bussinessPricePrecentage;
		this.firstPricePrecentage = firstPricePrecentage;
		this.discountedPrecentage = discountedPrecentage;
		this.deleted = false;
		this.airline = airline;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPriceByKm() {
		return priceByKm;
	}

	public void setPriceByKm(Double priceByKm) {
		this.priceByKm = priceByKm;
	}

	public Double getEconomyPricePrecentage() {
		return economyPricePrecentage;
	}

	public void setEconomyPricePrecentage(Double economyPricePrecentage) {
		this.economyPricePrecentage = economyPricePrecentage;
	}

	public Double getBussinessPricePrecentage() {
		return bussinessPricePrecentage;
	}

	public void setBussinessPricePrecentage(Double bussinessPricePrecentage) {
		this.bussinessPricePrecentage = bussinessPricePrecentage;
	}

	public Double getFirstPricePrecentage() {
		return firstPricePrecentage;
	}

	public void setFirstPricePrecentage(Double firstPricePrecentage) {
		this.firstPricePrecentage = firstPricePrecentage;
	}

	public Double getDiscountedPrecentage() {
		return discountedPrecentage;
	}

	public void setDiscountedPrecentage(Double discountedPrecentage) {
		this.discountedPrecentage = discountedPrecentage;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public AirlineCompany getAirline() {
		return airline;
	}

	public void setAirline(AirlineCompany airline) {
		this.airline = airline;
	}

}
