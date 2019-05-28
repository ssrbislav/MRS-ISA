package com.airftn.AirFTN.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airftn.AirFTN.dto.AirlineCompanyDTO;
import com.airftn.AirFTN.model.AirlineAdmin;
import com.airftn.AirFTN.model.AirlineCompany;
import com.airftn.AirFTN.model.Destination;
import com.airftn.AirFTN.repository.AirAdminRepository;
import com.airftn.AirFTN.repository.AirlinecompanyRepository;
import com.airftn.AirFTN.repository.DestinationRepository;

@Service
@Transactional
public class AirlinecompanyService implements IAirlinecompanyService {

	@Autowired
	AirlinecompanyRepository airlineRepository;

	@Autowired
	AirAdminRepository adminRepository;

	@Autowired
	IDestinationService destinationService;

	@Autowired
	DestinationRepository destinationRepository;

	@Override
	public List<AirlineCompany> findAll() {

		return airlineRepository.findAll();
	}

	@Override
	public AirlineCompany getOne(Long id) {

		return airlineRepository.getOne(id);
	}

	@Override
	public AirlineCompany findByAdminId(Long id) {

		AirlineCompany company = airlineRepository.findByAdminId(id);

		return company;

	}

	@Override
	public AirlineCompany create(AirlineCompanyDTO company) {

		AirlineCompany airCompany = new AirlineCompany();

		AirlineAdmin admin = adminRepository.getOne(company.getAdmin_id());

		airCompany.setName(company.getName());
		airCompany.setCity(company.getCity());
		airCompany.setAddress(company.getAddress());
		airCompany.setDescription(company.getDescription());
		airCompany.setAdmin(admin);
		
		admin.setHasCompany(true);
		adminRepository.save(admin);

		return airlineRepository.save(airCompany);
	}

	@Override
	public String updateAdmin(AirlineCompany company, Long admin_id) {

		AirlineCompany airlineCompany = airlineRepository.getOne(company.getId());

		AirlineAdmin admin = adminRepository.getOne(admin_id);

		if (admin == null) {
			return "Admin does not exist!";
		}

		if (airlineCompany == null)
			return "That company does not exist!";

		airlineCompany.setAdmin(admin);
		airlineRepository.save(airlineCompany);

		return "Success";

	};

	@Override
	public AirlineCompany update(AirlineCompany company) {

		AirlineCompany airCompany = airlineRepository.getOne(company.getId());

		airCompany.setName(company.getName());
		airCompany.setCity(company.getCity());
		airCompany.setAddress(company.getAddress());
		airCompany.setDescription(company.getDescription());

		airlineRepository.save(airCompany);
		return airCompany;

	}

	public List<Destination> findAllDestinations(Long id) {

		List<Destination> destinations = new ArrayList<Destination>();

		AirlineCompany company = airlineRepository.getOne(id);

		destinations = company.getDestinations();

		return destinations;

	}

	public List<Destination> addDestinationToCompany(Long company_id, Long destination_id) {

		Destination destination = destinationService.findById(destination_id);

		List<Destination> destinations = new ArrayList<Destination>();
		destinations.add(destination);

		AirlineCompany company = airlineRepository.getOne(company_id);
		if(company.getDestinations().contains(destination))
			return null;
		
		company.getDestinations().add(destination);
		destination.getCompanies().add(company);

		destinationRepository.save(destination);
		return destinations;

	}

}
