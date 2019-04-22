package com.airftn.AirFTN.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airftn.AirFTN.dto.JwtResponse;
import com.airftn.AirFTN.dto.LoginDTO;
import com.airftn.AirFTN.dto.RegisterDTO;
import com.airftn.AirFTN.enumeration.RoleType;
import com.airftn.AirFTN.model.Passenger;
import com.airftn.AirFTN.model.Role;
import com.airftn.AirFTN.model.User;
import com.airftn.AirFTN.repository.PassengerRepository;
import com.airftn.AirFTN.repository.RoleRepository;
import com.airftn.AirFTN.repository.UserRepository;
import com.airftn.AirFTN.security.JwtProvider;
import com.airftn.AirFTN.service.EmailService;
import com.airftn.AirFTN.service.IPassengerService;

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
	IPassengerService passengerService;

	@Autowired
	PassengerRepository passengerRepository;

	@Autowired
	JwtProvider jwtProvider;

	@Autowired
	private ThreadPoolTaskExecutor taskExecutor;

	@Autowired
	private EmailService emailThread;

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterDTO registerRequest) {

		if (userRepository.existsByUsername(registerRequest.getUsername())) {
			return new ResponseEntity<>("Username is already taken", HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByEmail(registerRequest.getEmail())) {
			return new ResponseEntity<>("Email is already in use", HttpStatus.BAD_REQUEST);
		}

		User user = new Passenger(registerRequest.getEmail(), registerRequest.getUsername(),
				encoder.encode(registerRequest.getPassword()), registerRequest.getFirst_name(),
				registerRequest.getLast_name(), registerRequest.getAddress(), registerRequest.getPhone_number(),
				registerRequest.getDate_of_birth());

		Role role = new Role();
		role.setName(RoleType.ROLE_PASSENGER);

		Set<Role> roles = new HashSet<>();
		roles.add(role);

		user.setRoles(roles);

		userRepository.save(user);

		mailSend(user.getEmail(), passengerService.getRegistrationLink(user.getId()));

		return new ResponseEntity<>("User registered successfully!", HttpStatus.OK);

	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginDTO loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);

		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

//		Passenger passenger = passengerRepository.findByUsername(loginRequest.getUsername());
//		if (!passenger.isActive()) 

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));

	}

	@RequestMapping("/registrationConfirm/{registrationLink}")
	public ResponseEntity<?> confirmRegistration(@PathVariable("registrationLink") String registrationLink) {

		Passenger passenger = passengerRepository.findByRegistrationLink(registrationLink);

		if (passenger != null) {
			passenger.setActive(true);
			passengerService.update(passenger);
		}

		return new ResponseEntity<>("User activated successfully!", HttpStatus.OK);

	}

	@GetMapping("/getPassengerActive/{username}")
	private boolean getPassengerActive(@PathVariable String username) {

		Passenger passenger = passengerRepository.findByUsername(username);

		if (!passenger.isActive())
			return false;

		return true;

	}

	private void mailSend(String mailTo, String registrationLink) {
		String title = "Registration confirmation";
		String content = "Please activate your account via next link:\nhttp://localhost:8080/api/user/registrationConfirm/"
				+ registrationLink;
		emailThread.setup(mailTo, title, content);
		taskExecutor.execute(emailThread);
	}

}
