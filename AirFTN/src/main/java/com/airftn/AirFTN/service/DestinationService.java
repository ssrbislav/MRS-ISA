package com.airftn.AirFTN.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.airftn.AirFTN.dto.DestinationDTO;
import com.airftn.AirFTN.model.AirlineCompany;
import com.airftn.AirFTN.model.Destination;
import com.airftn.AirFTN.model.ResponseMessage;
import com.airftn.AirFTN.repository.DestinationRepository;

@Service
@Transactional
public class DestinationService implements IDestinationService {

	@Autowired
	DestinationRepository destinationRepository;
	
	@Autowired
	IAirlinecompanyService companyService;
	
	@Override
	public Destination create(DestinationDTO dest) {
		
		for(Destination d : destinationRepository.findAll()) {
			if((dest.getCity().equals(d.getCity()) ) && (dest.getCountry().equals(d.getCountry()))) {
				return null;
			}
		}
		
		Destination destination = new Destination();
		
		destination.setCity(dest.getCity());
		destination.setCountry(dest.getCountry());
		destination.setDescription(dest.getDescription());
		destination.setDeleted(false);
		
		return destinationRepository.save(destination);
	}

	@Override
	public List<Destination> findAll() {
		
		return destinationRepository.findAll();
	}

	// For now, update method has no purpose, if one is found the method will be implemented
	@Override
	public Destination update(Destination destination) {

		Destination dest = destinationRepository.getOne(destination.getId());
		
		return dest;
		
	}

	@Override
	public List<AirlineCompany> findAllCompanies(Long id) {
		
		List<AirlineCompany> companies = new ArrayList<>();

		Destination destination = destinationRepository.getOne(id);
		
		companies = destination.getCompanies();
		
		return companies;
		
	}

	@Override
	public Destination findById(Long id) {
		
		return destinationRepository.getOne(id);
	}

}
