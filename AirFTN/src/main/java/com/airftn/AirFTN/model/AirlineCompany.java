package com.airftn.AirFTN.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class AirlineCompany {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="admin_id", nullable = false)
	private AirlineAdmin admin;

	public AirlineCompany() {
		super();
	}

	public AirlineCompany(Long id, AirlineAdmin admin) {
		super();
		this.id = id;
		this.admin = admin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AirlineAdmin getAdmin() {
		return admin;
	}

	public void setAdmin(AirlineAdmin admin) {
		this.admin = admin;
	}
	
	

}
