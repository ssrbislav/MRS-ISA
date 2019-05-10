package com.airftn.AirFTN.service;

import com.airftn.AirFTN.model.User;

public interface IAdminService {

	User findByUsername (String username);
	
	User getOne(Long id);

	User update(User admin, Long id);
	
}
