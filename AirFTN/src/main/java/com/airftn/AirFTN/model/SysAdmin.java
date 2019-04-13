package com.airftn.AirFTN.model;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class SysAdmin extends User {

	public SysAdmin() {
		super();
	}

	public SysAdmin(String email, String username, String password, String first_name, String last_name, String address,
			String phone_number, Date date_of_birth) {
		super(email, username, password, first_name, last_name, address, phone_number, date_of_birth);
	}

}
