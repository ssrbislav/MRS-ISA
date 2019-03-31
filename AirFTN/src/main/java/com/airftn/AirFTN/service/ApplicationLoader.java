package com.airftn.AirFTN.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.airftn.AirFTN.enumeration.RoleType;
import com.airftn.AirFTN.model.Admin;
import com.airftn.AirFTN.model.Role;
import com.airftn.AirFTN.model.SysAdmin;
import com.airftn.AirFTN.repository.AdminRepository;

@Component
public class ApplicationLoader implements ApplicationRunner {

	private AdminRepository adminRepository;

	public ApplicationLoader(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
		//Create System Admin if no admin is present
		if (adminRepository.findAll().size() == 0) {

					Role admin_role = new Role();
					admin_role.setName(RoleType.ROLE_SYSADMIN);
					Set<Role> roles = new HashSet<>();
					roles.add(admin_role);
					
					Admin admin = new SysAdmin();
					
					admin.setUsername("sysadmin");
					admin.setPassword("lozinka");
					admin.setEmail("");
					admin.setFirst_name("");
					admin.setLast_name("");
					admin.setAddress("");
					admin.setDate_of_birth(new Date());
					admin.setPhone_number("");
					admin.setRoles(roles);
	
					adminRepository.save(admin);
					System.out.println("Admin created!");	
		}
	
	}

}

