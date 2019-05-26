package com.airftn.AirFTN.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airftn.AirFTN.dto.AirlineCompanyDTO;
import com.airftn.AirFTN.model.AirlineAdmin;
import com.airftn.AirFTN.model.AirlineCompany;
import com.airftn.AirFTN.repository.AirAdminRepository;
import com.airftn.AirFTN.repository.AirlinecompanyRepository;

@Service
@Transactional
public class AirlinecompanyService implements IAirlinecompanyService {

	@Autowired
	AirlinecompanyRepository airlineRepository;

	@Autowired
	AirAdminRepository adminRepository;

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

		System.out.println(company.getAddress());
		System.out.println(company.getDescription());
		System.out.println(company.getName());
		System.out.println(company.getCity());
		System.out.println(admin);

		airCompany.setName(company.getName());
		airCompany.setCity(company.getCity());
		airCompany.setAddress(company.getAddress());
		airCompany.setDescription(company.getDescription());
		airCompany.setAdmin(admin);

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

}
