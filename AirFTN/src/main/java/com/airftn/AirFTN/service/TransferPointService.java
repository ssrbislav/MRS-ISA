package com.airftn.AirFTN.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airftn.AirFTN.dto.TransferPointDTO;
import com.airftn.AirFTN.model.Flight;
import com.airftn.AirFTN.model.TransferPoint;
import com.airftn.AirFTN.repository.TransferPointRepository;

@Service
public class TransferPointService implements ITransferPointService {

	@Autowired
	TransferPointRepository transferPointRepository;

	@Autowired
	IFlightService flightService;

	@Override
	public List<TransferPoint> findAll() {

		return transferPointRepository.findAll();
	}

	@Override
	public List<TransferPoint> findAllByFlightId(Long id) {

		Flight flight = flightService.getOne(id);

		List<TransferPoint> transferPoints = new ArrayList<TransferPoint>();

		for (TransferPoint tp : transferPointRepository.findAll()) {
			if (tp.getFlight().getId() == flight.getId())
				transferPoints.add(tp);
		}

		return transferPoints;

	}

	@Override
	public TransferPoint getOne(Long id) {

		return transferPointRepository.getOne(id);

	}

	@Override
	public TransferPoint create(TransferPointDTO tranferPoint) {
		
		Flight flight = flightService.getOne(tranferPoint.getFlightId());

		TransferPoint tp = new TransferPoint();
		tp.setArivalTime(tranferPoint.getArrivalTime());
		tp.setDepartureTime(tranferPoint.getDepartureTime());
		tp.setCountryAndCity(tranferPoint.getCoutryAndCity());
		tp.setFlight(flight);
		tp.setDeleted(false);
		
		return transferPointRepository.save(tp);
		
	}

	@Override
	public TransferPoint update(TransferPoint tranferPoint) {

		TransferPoint tp = new TransferPoint();
		tp.setArivalTime(tranferPoint.getArivalTime());
		tp.setDepartureTime(tranferPoint.getDepartureTime());
		tp.setCountryAndCity(tranferPoint.getCountryAndCity());
		tp.setFlight(tranferPoint.getFlight());
		tp.setDeleted(false);
		
		return transferPointRepository.save(tp);
		
	}

	@Override
	public boolean delete(Long id) {

		TransferPoint tp = transferPointRepository.getOne(id);

		if (tp == null)
			return false;

		tp.setDeleted(true);
		transferPointRepository.save(tp);

		return true;

	}

}
