package com.airftn.AirFTN.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.airftn.AirFTN.model.AirlineCompany;

@Service
@Transactional
public class AirlinecompanyService implements IAirlinecompanyService {

	@Override
	public List<AirlineCompany> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AirlineCompany getOne() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AirlineCompany create() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AirlineCompany update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

}
