package com.airftn.AirFTN.service;

import java.util.ArrayList;
import java.util.Calendar;
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
	public TransferPoint create(TransferPointDTO transferPoint) {

		// Returns null, but saves it in database
		// Flight info not visible, don't know why

		Flight flight = flightService.getOne(transferPoint.getFlightId());

		Calendar flightDepTime = Calendar.getInstance();
		flightDepTime.setTime(flight.getDepartureDate());

		Calendar flightArrTime = Calendar.getInstance();
		flightArrTime.setTime(flight.getArrivalDate());

		if (!transferPoint.getArrivalTime().after(flightDepTime.getTime())
				&& !transferPoint.getArrivalTime().before(flightArrTime.getTime()))
			return null;

		if (!transferPoint.getDepartureTime().after(transferPoint.getArrivalTime())
				&& !transferPoint.getDepartureTime().before(flightArrTime.getTime()))
			return null;

		if (transferPoint.getDepartureTime().before(transferPoint.getArrivalTime()))
			return null;

		TransferPoint tp = new TransferPoint();
		tp.setArivalTime(transferPoint.getArrivalTime());
		tp.setDepartureTime(transferPoint.getDepartureTime());
		tp.setCountryAndCity(transferPoint.getCoutryAndCity());
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
