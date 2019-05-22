package com.airftn.AirFTN.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reservation {

	// rezervacija ima listu karata(samo ako imaju tipovi), imace korisnika, let, kolicina, koji let
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true)
	private Long id;
	
	@Column(nullable = true)
	private boolean deleted;

	public Reservation() {
		super();
	}
	
	
	
}
