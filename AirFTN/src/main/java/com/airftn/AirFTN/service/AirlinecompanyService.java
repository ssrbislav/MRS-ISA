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
	public AirlineCompany create(AirlineCompanyDTO company) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AirlineCompany updateAdmin(AirlineCompany company, AirlineAdmin admin) {

		AirlineCompany airlineCompany = airlineRepository.getOne(company.getId());
		airlineCompany.setAdmin(admin);

		return airlineCompany;
	};

	@Override
	public boolean delete(Long id) {

		for (AirlineCompany company : airlineRepository.findAll())
			if (company.getId() == id) {
				return airlineRepository.delete(id);
			}

		return false;
	}

	@Override
	public String update(AirlineCompany company) {
		
		return null;
	}

}
