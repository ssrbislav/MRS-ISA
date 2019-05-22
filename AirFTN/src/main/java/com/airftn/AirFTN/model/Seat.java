package com.airftn.AirFTN.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Seat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(nullable = false, name = "seat_row")
	private int row;

	@Column(nullable = false, name = "seat_column")
	private int column;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(nullable = false, name = "airplane_id")
	@JsonIgnore
	private Airplane airplane;
	
	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, mappedBy = "seat")
	private Ticket ticket;

	@Column(nullable = true)
	private boolean deleted;

	public Seat() {
		super();
	}

	public Seat(Long id, int row, int column, Airplane airplane, boolean deleted) {
		super();
		this.id = id;
		this.row = row;
		this.column = column;
		this.airplane = airplane;
		this.deleted = deleted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Airplane getAirplane() {
		return airplane;
	}

	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}
