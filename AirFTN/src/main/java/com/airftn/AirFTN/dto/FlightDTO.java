package com.airftn.AirFTN.dto;

import java.util.Date;
import java.util.List;

import com.airftn.AirFTN.model.Destination;
import com.airftn.AirFTN.model.TransferPoint;

public class FlightDTO {

	private Long companyId;
	private Long airplaneId;
	private Date departure;
	private Date arrival;
	private Destination destination;
	private double millage;
	private List<TransferPoint> transfers;

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

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
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

}
