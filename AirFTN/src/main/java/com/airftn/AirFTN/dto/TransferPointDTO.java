package com.airftn.AirFTN.dto;

import java.util.Date;

public class TransferPointDTO {

	private Date arrivalTime;

	private Date departureTime;

	private String coutryAndCity;

	private Long flightId;

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public String getCoutryAndCity() {
		return coutryAndCity;
	}

	public void setCoutryAndCity(String coutryAndCity) {
		this.coutryAndCity = coutryAndCity;
	}

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

}
