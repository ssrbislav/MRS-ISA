package com.airftn.AirFTN.service;

import java.util.List;

import com.airftn.AirFTN.model.User;
import com.airftn.AirFTN.model.VerificationToken;

public interface IUserService {
	
	List<User> findAll();
	
	User create(User user);

	User update(User user);
	
	boolean delete(Long id);
	
}
