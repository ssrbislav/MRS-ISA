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
	private Long admin_id;

	public AirlineCompanyDTO(@NotBlank String name, @NotBlank String city, @NotBlank String address,
			@NotBlank String description, @NotBlank Long admin_id) {
		super();
		this.name = name;
		this.city = city;
		this.address = address;
		this.description = description;
		this.admin_id = admin_id;
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

	public Long getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Long admin_id) {
		this.admin_id = admin_id;
	}

}
