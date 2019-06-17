package com.airftn.AirFTN.dto;

public class TicketDTO {

	private double price;

	private Long seatId;

	private Long flightId;

	private Long airlineId;

	private boolean fastTicket;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getSeatId() {
		return seatId;
	}

	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public Long getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(Long airlineId) {
		this.airlineId = airlineId;
	}

	public boolean isFastTicket() {
		return fastTicket;
	}

	public void setFastTicket(boolean fastTicket) {
		this.fastTicket = fastTicket;
	}

}
