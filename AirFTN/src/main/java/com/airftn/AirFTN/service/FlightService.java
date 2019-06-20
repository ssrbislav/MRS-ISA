package com.airftn.AirFTN.service;

import java.util.ArrayList;
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
import com.airftn.AirFTN.model.Pricelist;
import com.airftn.AirFTN.model.Seat;
import com.airftn.AirFTN.model.Ticket;
import com.airftn.AirFTN.model.TransferPoint;
import com.airftn.AirFTN.repository.AirplaneRepository;
import com.airftn.AirFTN.repository.FlightRepository;
import com.airftn.AirFTN.repository.TicketRepository;

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

	@Autowired
	ITransferPointService transferPointService;
	
	@Autowired
	IPricelistService pricelistService;
	
	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	AirplaneRepository airplaneRepository;

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
		
		
		// airplaneRepository.save(airplane);
		
		Pricelist pricelist = pricelistService.getByAirlineId(company.getId());

		for (Flight f : flightRepository.findAll()) {
			if (f.getPlane().getId() == flight.getAirplaneId())
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


		for (Flight f : flightRepository.findAll()) {
			if (f.getFlightNumber().equals(flight.getFlightNumber()))
				return null;
		}

//		Calendar today = Calendar.getInstance();

//		if (departureTime.getTime().before(today.getTime()))
//			return null;

		if (arrivalTime.before(departureTime))
			return null;

		Flight f = new Flight();

		f.setFlightNumber(flight.getFlightNumber());
		f.setCompany(company);
		f.setPlane(airplane);
		f.setDepartureDate(flight.getDeparture());
		f.setArrivalDate(flight.getArrival());
		f.setDestination(destination);
		f.setMileage(flight.getMileage());
		f.setDurationOfFlight(durationOfFlight);
		f.setPrice(flight.getPrice());
		f.setDeleted(false);

		for (Seat seat : airplane.getSeats()) {
			Ticket ticket = new Ticket();
			ticket.setCompany(company);
			ticket.setDeleted(false);
			ticket.setFlight(f);
			ticket.setSeat(seat);
			ticket.setFastTicket(false);
			
			double price = flight.getPrice();
			
			price = price + (price * (pricelist.getEconomyPricePrecentage() / 100));
			
			ticket.setPrice(price);
			
//			double price;
//			
//			if(seat.getSeatType() == SeatType.BUSINESS_CLASS) {
//				price = flight.getPrice() * (pricelist.getBussinessPricePrecentage() / 100);
//				price -= price;
//				ticket.setPrice(price);
//			}
//			else if(seat.getSeatType() == SeatType.ECONOMY_CLASS) {
//				price = flight.getPrice() * (pricelist.getEconomyPricePrecentage() / 100);
//				price -= price;
//				ticket.setPrice(price);
//			}
//			else if(seat.getSeatType() == SeatType.FIRST_CLASS) {
//				price = flight.getPrice() * (pricelist.getFirstPricePrecentage() / 100);
//				price -= price;
//				ticket.setPrice(price);
//			}
			
			ticketRepository.save(ticket);
				
		}
		
		airplane.setTaken(true);
		//airplaneRepository.save(airplane);
		
		return flightRepository.save(f);

	}

	@Override
	public Flight update(Flight flight) {

		Flight f = flightRepository.getOne(flight.getId());
		
		Calendar departureTime = Calendar.getInstance();
		departureTime.setTime(flight.getDepartureDate());

		Calendar arrivalTime = Calendar.getInstance();
		arrivalTime.setTime(flight.getArrivalDate());

		long start = departureTime.getTimeInMillis();
		long end = arrivalTime.getTimeInMillis();
		double durationOfFlight = TimeUnit.MILLISECONDS.toMinutes(Math.abs(end - start));

		Calendar today = Calendar.getInstance();

		if (departureTime.getTime().before(today.getTime()))
			return null;

		if (arrivalTime.before(departureTime))
			return null;

		f.setCompany(flight.getCompany());
		f.setDepartureDate(flight.getDepartureDate());
		f.setArrivalDate(flight.getArrivalDate());
		f.setDestination(flight.getDestination());
		f.setDurationOfFlight(durationOfFlight);
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

	@Override
	public List<TransferPoint> getAllTransferPoints(Long id) {

		List<TransferPoint> transferPoints = new ArrayList<>();

		Flight f = flightRepository.getOne(id);

		for (TransferPoint tp : f.getTransferPoints()) {
			if (!tp.isDeleted())
				transferPoints.add(tp);
		}

		return transferPoints;
	}

	@Override
	public List<Flight> findByCompanyAndDestination(Long airlineId, Long destinationId) {
		
		List<Flight> airlineFlights = flightRepository.findAllByCompanyId(airlineId);
		
		Destination destination = destinationService.getOne(destinationId);
		
		List<Flight> flights = new ArrayList<>();
		
		for(Flight flight: airlineFlights) {
			if(flight.getDestination().getCity().equals(destination.getCity()))
				flights.add(flight);
		}
		
		return flights;
	}

}
