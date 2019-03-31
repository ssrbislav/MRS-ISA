package com.airftn.AirFTN.model;

import javax.persistence.Entity;

@Entity
public class SysAdmin extends Admin {

	public SysAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SysAdmin(Long id, String username2, String password2) {
		super(id, username2, password2);
		// TODO Auto-generated constructor stub
	}

	public SysAdmin(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}

	
	
}
