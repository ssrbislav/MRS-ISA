package com.airftn.AirFTN.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Email;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	@Email
	@NaturalId
	@Column(unique = true, nullable = false)
	public String email;

	@Column(unique = true, nullable = false)
	public String username;

	@Column(unique = true, nullable = false)
	public String password;

	public String address;

	public String phone_number;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "mm-dd-yyyy")
	public Date date_of_birth;

	public User(String email, String username, String password, String address, String phone_number,
			Date date_of_birth) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.address = address;
		this.phone_number = phone_number;
		this.date_of_birth = date_of_birth;
	}
	
	public User() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

}
