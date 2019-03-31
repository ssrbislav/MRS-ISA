package com.airftn.AirFTN.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.airftn.AirFTN.model.User;
import com.airftn.AirFTN.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
		
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found -> username : " + username));
		
		return UserPrinciple.build(user);
		
	}

}
