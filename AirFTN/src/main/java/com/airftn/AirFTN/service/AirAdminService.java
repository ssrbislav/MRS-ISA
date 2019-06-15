package com.airftn.AirFTN.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.airftn.AirFTN.model.AirlineAdmin;
import com.airftn.AirFTN.repository.AirAdminRepository;

@Service
public class AirAdminService implements IAirAdminService {

	@Autowired
	AirAdminRepository adminRepository;

	@Override
	public AirlineAdmin update(AirlineAdmin admin, Long id) {

		AirlineAdmin administrator = adminRepository.getOne(id);
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		administrator.setEmail(admin.getEmail());
		administrator.setPassword(encoder.encode(admin.getPassword()));
		administrator.setFirstName(admin.getFirstName());
		administrator.setLastName(admin.getLastName());
		administrator.setAddress(admin.getAddress());
		administrator.setDateOfBirth(admin.getDateOfBirth());
		administrator.setPhoneNumber(admin.getPhoneNumber());

		return adminRepository.save(administrator);
		
		//encoder.matches(rawPassword, encodedPassword)

	}
	
	public List<AirlineAdmin> findAllByAirlineCompanyNotExist() {
		
		List<AirlineAdmin> admins = adminRepository.findAllByHasCompanyFalse();
		
		return admins;
		
	}

}
