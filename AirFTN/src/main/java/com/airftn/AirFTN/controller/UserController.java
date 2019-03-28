package com.airftn.AirFTN.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airftn.AirFTN.service.UserService;

@RestController
@RequestMapping(value="api/user")
public class UserController {

	@Autowired
	UserService userService;
	
	//Not sure if I need this methods. Must check how to implement security
	
}
