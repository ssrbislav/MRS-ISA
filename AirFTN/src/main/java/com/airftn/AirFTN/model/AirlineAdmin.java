package com.airftn.AirFTN.model;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class AirlineAdmin extends User {

	public AirlineAdmin() {
		super();
	}

	public AirlineAdmin(String email, String username, String password, String first_name, String last_name,
			String address, String phone_number, Date date_of_birth) {
		super(email, username, password, first_name, last_name, address, phone_number, date_of_birth);
	}

}
