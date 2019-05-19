package com.airftn.AirFTN.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

	@ManyToOne(optional = false)
	@JoinColumn(name = "airline_company", referencedColumnName = "id")
	private AirlineCompany company;
}
