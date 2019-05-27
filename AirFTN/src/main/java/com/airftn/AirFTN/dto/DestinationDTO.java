package com.airftn.AirFTN.dto;

import javax.validation.constraints.NotBlank;

public class DestinationDTO {

	@NotBlank
	private String city;

	@NotBlank
	private String country;

	@NotBlank
	private String description;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
