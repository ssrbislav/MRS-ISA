package com.airftn.AirFTN.dto;

public class AirplaneDTO {

	private String model;

	private int numOfSeats;

	private Long airlineId;

	public AirplaneDTO() {
		super();
	}

	public AirplaneDTO(String model, int numOfSeats) {
		super();
		this.model = model;
		this.numOfSeats = numOfSeats;
	}

	public AirplaneDTO(String model, int numOfSeats, Long airlineId) {
		super();
		this.model = model;
		this.numOfSeats = numOfSeats;
		this.airlineId = airlineId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getNumOfSeats() {
		return numOfSeats;
	}

	public void setNumOfSeats(int numOfSeats) {
		this.numOfSeats = numOfSeats;
	}

	public Long getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(Long airlineId) {
		this.airlineId = airlineId;
	}

}
