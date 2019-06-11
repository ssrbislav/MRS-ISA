package com.airftn.AirFTN.service;

import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airftn.AirFTN.dto.FlightDTO;
import com.airftn.AirFTN.model.AirlineCompany;
import com.airftn.AirFTN.model.Airplane;
import com.airftn.AirFTN.model.Destination;
import com.airftn.AirFTN.model.Flight;
import com.airftn.AirFTN.repository.FlightRepository;

@Service
public class FlightService implements IFlightService {

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	IAirlinecompanyService companyService;

	@Autowired
	IAirplaneService airplaneService;

	@Autowired
	IDestinationService destinationService;

	@Override
	public List<Flight> findAll() {

		return flightRepository.findAll();
	}

	@Override
	public List<Flight> findAllNotDeleted() {

		return flightRepository.findAllByDeletedIsFalse();
	}

	@Override
	public Flight getOne(Long id) {

		return flightRepository.getOne(id);
	}

	@Override
	public Flight create(FlightDTO flight) {

		AirlineCompany company = companyService.getOne(flight.getCompanyId());

		Airplane airplane = airplaneService.getOne(flight.getAirplaneId());
		
		for(Flight f: flightRepository.findAll()) {
			if(f.getPlane().getId() == flight.getAirplaneId())
				return null;
		}

		Destination destination = destinationService.findById(flight.getDestinationId());

		Calendar departureTime = Calendar.getInstance();
		departureTime.setTime(flight.getDeparture());

		Calendar arrivalTime = Calendar.getInstance();
		arrivalTime.setTime(flight.getArrival());
		
		long start = departureTime.getTimeInMillis();
	    long end = arrivalTime.getTimeInMillis();
	    double durationOfFlight = TimeUnit.MILLISECONDS.toMinutes(Math.abs(end - start));
		
		System.out.println(durationOfFlight);

		for (Flight f : flightRepository.findAll()) {
			if (f.getFlightNumber().equals(flight.getFlightNumber()))
				return null;
		}

		Calendar today = Calendar.getInstance();

		if (departureTime.getTime().before(today.getTime()))
			return null;

		if (arrivalTime.before(departureTime))
			return null;

		Flight f = new Flight();

		f.setFlightNumber(flight.getFlightNumber());
		f.setCompany(company);
		f.setPlane(airplane);
		f.setDepartureDate(flight.getDeparture());
		f.setArrivalDate(flight.getArrival());
		f.setDestination(destination);
		f.setMileage(flight.getMillage());
		f.setTransferPoints(flight.getTransfers());
		f.setDurationOfFlight(durationOfFlight);
		f.setPrice(flight.getPrice());
		f.setDeleted(false);

		return flightRepository.save(f);

	}

	@Override
	public Flight update(Flight flight) {

		Flight f = flightRepository.getOne(flight.getId());

		f.setCompany(flight.getCompany());
		f.setDepartureDate(flight.getDepartureDate());
		f.setArrivalDate(flight.getArrivalDate());
		f.setDestination(flight.getDestination());
		f.setDurationOfFlight(flight.getDurationOfFlight());
		f.setFlightNumber(flight.getFlightNumber());
		f.setMileage(flight.getMileage());
		f.setPlane(flight.getPlane());
		f.setPrice(flight.getPrice());
		f.setTransferPoints(flight.getTransferPoints());
		f.setTickets(flight.getTickets());
		f.setDeleted(flight.isDeleted());

		return flightRepository.save(f);
	}

	@Override
	public List<Flight> findByCompanyId(Long id) {

		return flightRepository.findAllByCompanyId(id);
	}

	@Override
	public Flight delete(Long id) {

		Optional<Flight> flight = flightRepository.findById(id);
		flight.get().setDeleted(false);

		return flightRepository.save(flight);
	}

}
