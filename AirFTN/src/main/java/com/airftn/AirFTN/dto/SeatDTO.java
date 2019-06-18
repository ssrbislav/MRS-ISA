package com.airftn.AirFTN.dto;

import javax.validation.constraints.NotNull;

import com.airftn.AirFTN.enumeration.SeatType;

public class SeatDTO {

	@NotNull
	private long id;
	
	@NotNull
	private int row;

	@NotNull
	private int column;

	@NotNull
	private SeatType seatType;

	private Long airplaneId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public SeatType getSeatType() {
		return seatType;
	}

	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}

	public Long getAirplaneId() {
		return airplaneId;
	}

	public void setAirplaneId(Long airplaneId) {
		this.airplaneId = airplaneId;
	}

}
