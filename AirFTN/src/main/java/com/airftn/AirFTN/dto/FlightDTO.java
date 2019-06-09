package com.airftn.AirFTN.dto;

import java.util.Date;
import java.util.List;

import com.airftn.AirFTN.model.TransferPoint;
import com.fasterxml.jackson.annotation.JsonFormat;

public class FlightDTO {

	private String flightNumber;
	private Long companyId;
	private Long airplaneId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm")
	private Date departure;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm")
	private Date arrival;
	private Long destinationId;
	private double millage;
	private List<TransferPoint> transfers;
	private double price;

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getAirplaneId() {
		return airplaneId;
	}

	public void setAirplaneId(Long airplaneId) {
		this.airplaneId = airplaneId;
	}

	public Date getDeparture() {
		return departure;
	}

	public void setDeparture(Date departure) {
		this.departure = departure;
	}

	public Date getArrival() {
		return arrival;
	}

	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}

	public Long getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(Long destinationId) {
		this.destinationId = destinationId;
	}

	public double getMillage() {
		return millage;
	}

	public void setMillage(double millage) {
		this.millage = millage;
	}

	public List<TransferPoint> getTransfers() {
		return transfers;
	}

	public void setTransfers(List<TransferPoint> transfers) {
		this.transfers = transfers;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
