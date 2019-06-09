package com.airftn.AirFTN.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airftn.AirFTN.dto.FlightDTO;
import com.airftn.AirFTN.model.Flight;
import com.airftn.AirFTN.repository.FlightRepository;

@Service
public class FlightService implements IFlightService {
	
	@Autowired
	FlightRepository flightRepository;

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

		Flight f= new Flight();
		
		
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
