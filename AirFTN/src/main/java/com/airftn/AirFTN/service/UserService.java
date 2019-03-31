package com.airftn.AirFTN.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airftn.AirFTN.model.User;
import com.airftn.AirFTN.repository.UserRepository;

@Service
public class UserService implements IUserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User create(User user) {

		for(User u: findAll()) {
			if(u.getUsername().equals(user.getUsername()) ||
					u.getEmail().equals(user.getEmail()))
				return null;
		}

		return userRepository.save(user);
	}

	@Override
	public User update(User user) {

		return userRepository.save(user);
	}

	@Override
	public boolean delete(Long id) {
		for (User user : findAll()) {
			if (user.getId() != id) {
				userRepository.delete(user);
				return true;
			}
		}
		return false;
	}

}
