package com.airftn.AirFTN.dto;

import javax.validation.constraints.NotBlank;

public class AirlineCompanyDTO {

	@NotBlank
	private String name;

	@NotBlank
	private String city;

	@NotBlank
	private String address;

	@NotBlank
	private String description;

	@NotBlank
	private Long adminId;
	
	

	public AirlineCompanyDTO() {
	}

	public AirlineCompanyDTO(String name, String city, String address, String description, Long adminId) {
		super();
		this.name = name;
		this.city = city;
		this.address = address;
		this.description = description;
		this.adminId = adminId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

}
