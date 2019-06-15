package com.airftn.AirFTN.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.airftn.AirFTN.model.SysAdmin;
import com.airftn.AirFTN.repository.SysAdminRepository;

@Service
public class SysAdminService implements ISysAdminService {

	@Autowired
	SysAdminRepository adminRepository;

	@Override
	public SysAdmin update(SysAdmin admin, Long id) {

		SysAdmin administrator = adminRepository.getOne(id);

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		administrator.setId(id);
		administrator.setEmail(admin.getEmail());
		administrator.setPassword(encoder.encode(admin.getPassword()));
		administrator.setFirstName(admin.getFirstName());
		administrator.setLastName(admin.getLastName());
		administrator.setAddress(admin.getAddress());
		administrator.setDateOfBirth(admin.getDateOfBirth());
		administrator.setPhoneNumber(admin.getPhoneNumber());

		return adminRepository.save(administrator);

	}
	
	public List<SysAdmin> findAll() {
		
		List<SysAdmin> admins = new ArrayList<SysAdmin>();
		
		for(SysAdmin admin : adminRepository.findAllByDeletedIsFalse()) {
			if(admin.getId() != 1) {
				admins.add(admin);
			}
		}
		
		return admins;
		
	}

}
