package com.airftn.AirFTN.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.airftn.AirFTN.dto.TransferPointDTO;

@Service
public class TransferPoint implements ITransferPoint{

	@Override
	public List<com.airftn.AirFTN.model.TransferPoint> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<com.airftn.AirFTN.model.TransferPoint> findAllByFlightId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.airftn.AirFTN.model.TransferPoint create(TransferPointDTO tp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.airftn.AirFTN.model.TransferPoint update(com.airftn.AirFTN.model.TransferPoint tp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
