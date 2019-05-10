package com.airftn.AirFTN.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.airftn.AirFTN.model.User;
import com.airftn.AirFTN.repository.UserRepository;

@Service
public class AdminService implements IAdminService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User findByUsername(String username) {

		return userRepository.findByUsername(username);
	}

	@Override
	public User getOne(Long id) {

		return userRepository.getOne(id);
	}

	@Override
	public User update(User admin) {

		User administrator = userRepository.getOne(admin.getId());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		administrator.setId(admin.getId());
		administrator.setEmail(admin.getEmail());
		administrator.setPassword(encoder.encode(admin.getPassword()));
		administrator.setFirst_name(admin.getFirst_name());
		administrator.setLast_name(admin.getLast_name());
		administrator.setAddress(admin.getAddress());
		administrator.setDate_of_birth(admin.getDate_of_birth());
		administrator.setPhone_number(admin.getPhone_number());

		return userRepository.save(administrator);
		
		//encoder.matches(rawPassword, encodedPassword)

	}

}
