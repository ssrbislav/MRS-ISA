package com.airftn.AirFTN.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airftn.AirFTN.model.Destination;

public interface DestinationRepository extends JpaRepository<Destination, Long> {

	List<Destination> findAllByCity(String city);

	List<Destination> findAllByCountry(String country);

}
