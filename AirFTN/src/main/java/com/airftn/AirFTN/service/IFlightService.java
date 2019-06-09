package com.airftn.AirFTN.service;

import java.util.List;
import java.util.Optional;

import com.airftn.AirFTN.model.Flight;

public interface IFlightService {

	List<Flight> findAll();

	List<Flight> findAllNotDeleted();

	List<Flight> findByCompanyId(Long id);

	Optional<Flight> getOne(Long id);

	Flight create();

	Flight update(Flight flight);

	Flight delete(Long id);

}
