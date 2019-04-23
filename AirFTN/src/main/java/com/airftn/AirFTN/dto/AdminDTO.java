package com.airftn.AirFTN.dto;

import java.util.Set;

import javax.validation.constraints.NotBlank;

public class AdminDTO {

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

	private Set<String> role;

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
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
	
	

}
