package com.airftn.AirFTN.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airftn.AirFTN.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

	Optional<User> findById(Long id);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

}
