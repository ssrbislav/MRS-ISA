package com.airftn.AirFTN.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airftn.AirFTN.dto.LoginDTO;
import com.airftn.AirFTN.dto.RegisterDTO;
import com.airftn.AirFTN.enumeration.RoleType;
import com.airftn.AirFTN.model.Passenger;
import com.airftn.AirFTN.model.Role;
import com.airftn.AirFTN.model.User;
import com.airftn.AirFTN.repository.RoleRepository;
import com.airftn.AirFTN.repository.UserRepository;
import com.airftn.AirFTN.security.JwtProvider;

@CrossOrigin
@RestController
@RequestMapping(value = "api/user")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterDTO registerRequest) {

		if (userRepository.existsByUsername(registerRequest.getUsername())) {
			return new ResponseEntity<>("Username is already taken", HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByEmail(registerRequest.getEmail())) {
			return new ResponseEntity<>("Email is already in use", HttpStatus.BAD_REQUEST);
		}

		User user = new Passenger(true, 
				registerRequest.getEmail(), 
				registerRequest.getUsername(),
				encoder.encode(registerRequest.getPassword()), 
				registerRequest.getFirst_name(),
				registerRequest.getLast_name(), 
				registerRequest.getAddress(), 
				registerRequest.getPhone_number(),
				registerRequest.getDate_of_birth());

		Role role = new Role();
		role.setName(RoleType.ROLE_PASSENGER);

		Set<Role> roles = new HashSet<>();
		roles.add(role);

		user.setRoles(roles);

		userRepository.save(user);

		return new ResponseEntity<>("User registered successfully!", HttpStatus.OK);

	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginDTO loginRequest) {
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), 
						loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = jwtProvider.generateJwtToken(authentication);
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
	
		return new ResponseEntity<>(HttpStatus.OK);
		
		
	}
	
}

