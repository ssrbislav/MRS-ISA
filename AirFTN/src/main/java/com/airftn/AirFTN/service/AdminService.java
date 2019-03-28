package com.airftn.AirFTN.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airftn.AirFTN.model.Admin;
import com.airftn.AirFTN.repository.AdminRepository;

@Service
public class AdminService implements IAdminService {

	@Autowired
	AdminRepository adminRepository;
	
	@Override
	public List<Admin> findAll() {
		return adminRepository.findAll(); 
	}

	@Override
	public Admin create(Admin administrator) {
		
		//Only one administrator, so no need to cheek if one already exists
		return adminRepository.save(administrator);
	}

	@Override
	public Admin update(Admin administrator) {
		
		Admin admin = adminRepository.getOne(administrator.getId());
		admin.setUsername(administrator.getUsername());
		admin.setPassword(administrator.getPassword());
		
		return adminRepository.save(admin);
	}

	@Override
	public boolean delete(Long id) {
		
		for(Admin admin: findAll()) {
			if(admin.getId() == id) {
				adminRepository.delete(admin);
				return true;
			}
		}
		return false;
	}

}
