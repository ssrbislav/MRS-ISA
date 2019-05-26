package com.airftn.AirFTN.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airftn.AirFTN.dto.AirlineCompanyDTO;
import com.airftn.AirFTN.model.AirlineAdmin;
import com.airftn.AirFTN.model.AirlineCompany;
import com.airftn.AirFTN.model.User;
import com.airftn.AirFTN.repository.AirlinecompanyRepository;
import com.airftn.AirFTN.repository.UserRepository;

@Service
@Transactional
public class AirlinecompanyService implements IAirlinecompanyService {

	@Autowired
	AirlinecompanyRepository airlineRepository;

	@Autowired
	UserRepository adminRepository;

	@Override
	public List<AirlineCompany> findAll() {

		return airlineRepository.findAll();
	}

	@Override
	public AirlineCompany getOne(Long id) {

		return airlineRepository.getOne(id);
	}

	@Override
	public User findByAdminId(Long id) {

		User admin = adminRepository.getOne(id);
		return admin;

	}

	@Override
	public AirlineCompany create(AirlineCompanyDTO company, Long admin_id) {

		AirlineCompany airCompany = new AirlineCompany();

		AirlineAdmin admin = (AirlineAdmin) adminRepository.getOne(admin_id);

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

		AirlineAdmin admin = (AirlineAdmin) adminRepository.getOne(admin_id);

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
	public String update(AirlineCompany company) {

		AirlineCompany airCompany = airlineRepository.GetOne(company.getId());

		if (airCompany == null)
			return "Company does not exist!";

		airCompany.setName(company.getName());
		airCompany.setCity(company.getCity());
		airCompany.setAddress(company.getAddress());
		airCompany.setDescription(company.getDescription());

		airlineRepository.save(airCompany);
		return "Success";

	}

}
