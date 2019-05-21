package com.airftn.AirFTN.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Airplane {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(unique = false, nullable = false)
	private String model;

	@Column(unique = false, nullable = false)
	private int numberOfSeats;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "plane")
	private Flight flight;

	@ManyToOne(optional = false)
	@JoinColumn(name = "airline_company_id")
	private AirlineCompany company;

	public Airplane() {
		super();
	}

	public Airplane(Long id, String model, int numberOfSeats, AirlineCompany company) {
		super();
		this.id = id;
		this.model = model;
		this.numberOfSeats = numberOfSeats;
		this.company = company;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public AirlineCompany getCompany() {
		return company;
	}

	public void setCompany(AirlineCompany company) {
		this.company = company;
	}

}
