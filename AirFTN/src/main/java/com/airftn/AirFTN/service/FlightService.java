package com.airftn.AirFTN.service;

import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airftn.AirFTN.dto.FlightDTO;
import com.airftn.AirFTN.model.AirlineCompany;
import com.airftn.AirFTN.model.Airplane;
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

	@Override
	public List<Flight> findAll() {

		return flightRepository.findAll();
	}

	@Override
	public List<Flight> findAllNotDeleted() {

		return findAllNotDeleted();
	}

	@Override
	public Optional<Flight> getOne(Long id) {

		return flightRepository.findById(id);
	}

	@Override
	public Flight create(FlightDTO flight) {

		AirlineCompany company = companyService.getOne(flight.getCompanyId());

		Airplane airplane = airplaneService.getOne(flight.getAirplaneId());

		Calendar departureTime = Calendar.getInstance();
		departureTime.setTime(flight.getDeparture());

		Calendar arrivalTime = Calendar.getInstance();
		arrivalTime.setTime(flight.getArrival());

		double durationOfFlight = ChronoUnit.HOURS.between(arrivalTime.toInstant(), departureTime.toInstant());

		Flight f = new Flight();
		
		f.setFlightNumber(flight.getFlightNumber());
		f.setCompany(company);
		f.setPlane(airplane);
		f.setDepartureDate(flight.getDeparture());
		f.setArrivalDate(flight.getArrival());
		f.setDestination(flight.getDestination());
		f.setMileage(flight.getMillage());
		f.setTransferPoints(flight.getTransfers());
		f.setDurationOfFlight(durationOfFlight);
		f.setPrice(flight.getPrice());
		f.setDeleted(false);
		

		return flightRepository.save(f);

	}

	@Override
	public Flight update(Flight flight) {

		Optional<Flight> f = flightRepository.findById(flight.getId());

		f.get().setCompany(flight.getCompany());
		f.get().setDepartureDate(flight.getDepartureDate());
		f.get().setArrivalDate(flight.getArrivalDate());
		f.get().setDestination(flight.getDestination());
		f.get().setDurationOfFlight(flight.getDurationOfFlight());
		f.get().setFlightNumber(flight.getFlightNumber());
		f.get().setMileage(flight.getMileage());
		f.get().setPlane(flight.getPlane());
		f.get().setPrice(flight.getPrice());
		f.get().setTransferPoints(flight.getTransferPoints());
		f.get().setTickets(flight.getTickets());
		f.get().setDeleted(flight.isDeleted());

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
