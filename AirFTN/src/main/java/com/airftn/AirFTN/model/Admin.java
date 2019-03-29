package com.airftn.AirFTN.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.airftn.AirFTN.enumeration.AdminType;

@Entity
public class Admin extends User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(unique = true, nullable = false)
	private String username;

	@Column(unique = true, nullable = false)
	private String password;

	@Column(nullable = false)
	private AdminType type;

	public Admin(Long id, String username2, String password2, AdminType type) {
		super();
		this.id = id;
		username = username2;
		password = password2;
		this.type = type;
	}

	public Admin(String username, String password, AdminType type) {
		super();
		this.username = username;
		this.password = password;
		this.type = type;
	}

	public Admin() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AdminType getType() {
		return type;
	}

	public void setType(AdminType type) {
		this.type = type;
	}

}
