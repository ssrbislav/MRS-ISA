package com.airftn.AirFTN.dto;

import javax.validation.constraints.NotNull;

public class AirplaneDTO {

	@NotNull
	private String model;

	@NotNull
	private int numberOfSeats;

	@NotNull
	private Long airlineId;

	public AirplaneDTO() {
		super();
	}

	public AirplaneDTO(String model, int numOfSeats) {
		super();
		this.model = model;
		this.numberOfSeats = numOfSeats;
	}

	public AirplaneDTO(String model, int numOfSeats, Long airlineId) {
		super();
		this.model = model;
		this.numberOfSeats = numOfSeats;
		this.airlineId = airlineId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numOfSeats) {
		this.numberOfSeats = numOfSeats;
	}

	public Long getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(Long airlineId) {
		this.airlineId = airlineId;
	}

}
