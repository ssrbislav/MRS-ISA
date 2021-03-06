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
import com.airftn.AirFTN.model.ResponseMessage;
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

	ResponseMessage message = new ResponseMessage();

	/*
	 ** METHODS IMPLEMENTATIONS SHOULD BE MOVED TO APPROPRIATE SERVICE CLASSES
	 */

	@PostMapping("/register")
	public ResponseEntity<ResponseMessage> registerUser(@Valid @RequestBody RegisterDTO registerRequest) {

		if (userRepository.existsByUsername(registerRequest.getUsername())) {
			message.setMessage("Username is already taken");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByEmail(registerRequest.getEmail())) {
			message.setMessage("Email is already in use");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}

		User user = new Passenger(registerRequest.getEmail(), registerRequest.getUsername(),
				encoder.encode(registerRequest.getPassword()), registerRequest.getFirstName(),
				registerRequest.getLastName(), registerRequest.getPassportNumber(), registerRequest.getAddress(),
				registerRequest.getPhoneNumber(), registerRequest.getDateOfBirth());

		Role role = new Role();
		role.setName(RoleType.ROLE_PASSENGER);

		Set<Role> roles = new HashSet<>();
		roles.add(role);

		user.setRoles(roles);

		userRepository.save(user);

		mailSend(user.getEmail(), passengerService.getRegistrationLink(user.getId()));
		message.setMessage("User successfully registered!");

		return new ResponseEntity<>(message, HttpStatus.OK);

	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginDTO loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);

		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		// Check if uesr is active
		/*
		 * if (!passenger.isActive()) {
		 * message.setMessage("Please activate your account!");
		 * 
		 * return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST); }
		 */

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
