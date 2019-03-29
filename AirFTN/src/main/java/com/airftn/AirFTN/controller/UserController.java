package com.airftn.AirFTN.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airftn.AirFTN.service.UserService;

@CrossOrigin
@RestController
@RequestMapping(value="api/user")
public class UserController {

	@Autowired
	UserService userService;
	
}
