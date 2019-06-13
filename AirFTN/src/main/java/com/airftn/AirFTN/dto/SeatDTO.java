package com.airftn.AirFTN.dto;

import javax.validation.constraints.NotNull;

import com.airftn.AirFTN.enumeration.SeatType;
import com.fasterxml.jackson.annotation.JsonFormat;

public class SeatDTO {

	@NotNull
	private int row;

	@NotNull
	private int column;

	@NotNull
	private SeatType seatType;

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

}
