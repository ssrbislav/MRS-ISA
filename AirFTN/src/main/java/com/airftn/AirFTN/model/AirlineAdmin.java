package com.airftn.AirFTN.model;

import javax.persistence.Entity;

@Entity
public class AirlineAdmin extends Admin {

	public AirlineAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AirlineAdmin(Long id, String username2, String password2) {
		super(id, username2, password2);
		// TODO Auto-generated constructor stub
	}

	public AirlineAdmin(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}
	
}
