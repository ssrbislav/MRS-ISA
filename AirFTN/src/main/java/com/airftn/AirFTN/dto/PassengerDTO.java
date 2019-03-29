package com.airftn.AirFTN.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PassengerDTO {

	@NotBlank
	private String email;

	@NotBlank
	private String username;

	@NotBlank
	private String password;

	@NotBlank
	private String first_name;

	@NotBlank
	private String last_name;

	@NotBlank
	private String address;

	@NotBlank
	private String phone_number;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
	private Date date_of_birth;

	public PassengerDTO(String email, String username, String password,
			String first_name, String last_name, String address,
			String phone_number, Date date_of_birth) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.phone_number = phone_number;
		this.date_of_birth = date_of_birth;
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

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
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
