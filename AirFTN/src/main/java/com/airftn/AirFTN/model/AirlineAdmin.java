package com.airftn.AirFTN.model;

import javax.persistence.Entity;

@Entity
public class AirlineAdmin extends Admin {

	public AirlineAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AirlineAdmin(Long id, String email2, String username2, String password2) {
		super(id, email2, username2, password2);
		// TODO Auto-generated constructor stub
	}

	public AirlineAdmin(String email, String username, String password) {
		super(email, username, password);
	}
	
}
