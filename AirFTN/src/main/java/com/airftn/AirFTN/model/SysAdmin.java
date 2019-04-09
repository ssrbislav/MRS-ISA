package com.airftn.AirFTN.model;

import javax.persistence.Entity;

@Entity
public class SysAdmin extends Admin {

	public SysAdmin() {
		super();
	}

	public SysAdmin(Long id, String email2, String username2, String password2) {
		super(id, email2, username2, password2);
	}

	public SysAdmin(String email2, String username2, String password2) {
		super(email2, username2, password2);

	}

}
