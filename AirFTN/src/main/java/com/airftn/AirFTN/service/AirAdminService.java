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

		administrator.setId(id);
		administrator.setEmail(admin.getEmail());
		administrator.setPassword(encoder.encode(admin.getPassword()));
		administrator.setFirst_name(admin.getFirst_name());
		administrator.setLast_name(admin.getLast_name());
		administrator.setAddress(admin.getAddress());
		administrator.setDate_of_birth(admin.getDate_of_birth());
		administrator.setPhone_number(admin.getPhone_number());

		return adminRepository.save(administrator);
		
		//encoder.matches(rawPassword, encodedPassword)

	}
	
	public List<AirlineAdmin> findAllByAirlineCompanyNotExist() {
		
		List<AirlineAdmin> admins = adminRepository.findAllByHasCompanyFalse();
		
		return admins;
		
	}

}
