package com.airftn.AirFTN.service;

import java.util.List;

import com.airftn.AirFTN.model.Admin;

public interface IAdminService {

	List<Admin> findAll();

	Admin create(Admin administrator);

	Admin update(Admin administrator);

	boolean delete(Long id);

}
