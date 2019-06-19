package com.airftn.AirFTN.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class BusinessReportDTO {

	@NotNull
	private Long airline;

	@NotNull
	private Date from;

	@NotNull
	private Date to;

	public Long getAirline() {
		return airline;
	}

	public void setAirline(Long airline) {
		this.airline = airline;
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

}
