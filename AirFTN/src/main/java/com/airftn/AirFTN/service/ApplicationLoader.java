package com.airftn.AirFTN.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.airftn.AirFTN.enumeration.RoleType;
import com.airftn.AirFTN.model.Role;
import com.airftn.AirFTN.model.SysAdmin;
import com.airftn.AirFTN.model.User;
import com.airftn.AirFTN.repository.UserRepository;

@Component
public class ApplicationLoader implements ApplicationRunner {

	private UserRepository userRepository;

	public ApplicationLoader(UserRepository adminRepository) {
		super();
		this.userRepository = adminRepository;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {


		//Create System Admin if no admin is present
		if (userRepository.findAll().size() == 0) {
			
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

			Role admin_role = new Role();
			admin_role.setName(RoleType.ROLE_SYSADMIN);
			Set<Role> roles = new HashSet<>();
			roles.add(admin_role);

			User admin = new SysAdmin();

			admin.setEmail("sys_admin@email.com");
			admin.setUsername("admin");
			admin.setPassword(encoder.encode("admin"));
			admin.setRoles(roles);

			userRepository.save(admin);
			System.out.println("Admin created!");	
		}

	}

}

