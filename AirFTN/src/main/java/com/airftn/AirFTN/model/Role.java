package com.airftn.AirFTN.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.NaturalId;

import com.airftn.AirFTN.enumeration.RoleType;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@NaturalId
	private RoleType role_name;

	public Role(RoleType role_name) {
		this.role_name = role_name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RoleType getRole_name() {
		return role_name;
	}

	public void setRole_name(RoleType role_name) {
		this.role_name = role_name;
	}

}
