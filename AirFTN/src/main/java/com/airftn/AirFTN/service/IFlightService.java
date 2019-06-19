package com.airftn.AirFTN.service;

import java.util.List;

import com.airftn.AirFTN.dto.FlightDTO;
import com.airftn.AirFTN.model.Flight;
import com.airftn.AirFTN.model.TransferPoint;

public interface IFlightService {

	List<Flight> findAll();

	List<Flight> findAllNotDeleted();

	List<Flight> findByCompanyId(Long id);
	
	List<Flight> findByCompanyAndDestination(Long id, Long city);

	Flight getOne(Long id);

	Flight create(FlightDTO flight);

	Flight update(Flight flight);

	Flight delete(Long id);
	
	List<TransferPoint> getAllTransferPoints(Long id);

}
