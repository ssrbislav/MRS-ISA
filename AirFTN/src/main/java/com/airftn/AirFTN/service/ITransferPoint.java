package com.airftn.AirFTN.service;

import java.util.List;

import com.airftn.AirFTN.dto.TransferPointDTO;
import com.airftn.AirFTN.model.TransferPoint;

public interface ITransferPoint {
	
	List<TransferPoint> findAll();
	
	List<TransferPoint> findAllByFlightId(Long id);

	TransferPoint create(TransferPointDTO tp);
	
	TransferPoint update(TransferPoint tp);
	
	boolean delete(Long id);
	
}
