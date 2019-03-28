package com.airftn.AirFTN.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.airftn.AirFTN.model.Admin;
import com.airftn.AirFTN.service.IAdminService;

@RestClientTest
@RequestMapping(value = "api/admin")
public class AdminController {

	@Autowired
	IAdminService adminService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Admin>> findAll() {

		List<Admin> administrators = adminService.findAll();

		return new ResponseEntity<>(administrators, HttpStatus.OK);
	}

	@RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
	public ResponseEntity<Admin> create(@RequestBody Admin admin) {

		Admin administrator = adminService.create(admin);
		
		if(administrator == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(administrator, HttpStatus.OK);
	}

	@RequestMapping(value = "updateAdmin", method = RequestMethod.POST)
	public ResponseEntity<Admin> update(@RequestBody Admin admin) {

		Admin administrator = adminService.update(admin);
		
		if(administrator == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(administrator, HttpStatus.OK);
	}

	//For now, only one administrator is allowed to exist in the system, so no delete method is needed
	/*
	@RequestMapping(value = "deleteAdmin/{id}", method = RequestMethod.GET)
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {

		boolean delete = adminService.delete(id);
		
		return new ResponseEntity<>(delete, HttpStatus.OK);
	}
	*/

}
