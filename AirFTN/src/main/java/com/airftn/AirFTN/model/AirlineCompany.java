package com.airftn.AirFTN.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class AirlineCompany {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String name;
	
	@Column(unique = true, nullable = false)
	private String city;
	
	@Column(nullable = false, unique = false)
	private String address;
	
	@Column(nullable = false, unique = false)
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "")
	private List<Airplane> planes = new ArrayList<Airplane>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "")
	private List<Flight> flights = new ArrayList<Flight>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH, mappedBy = "companies")
	private List<Destination> destinations = new ArrayList<Destination>();
	
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
