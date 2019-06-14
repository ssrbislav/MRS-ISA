package com.airftn.AirFTN.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airftn.AirFTN.dto.PricelistDTO;
import com.airftn.AirFTN.model.Pricelist;
import com.airftn.AirFTN.model.ResponseMessage;
import com.airftn.AirFTN.repository.PricelistRepository;
import com.airftn.AirFTN.service.PricelistService;

@RestController
@CrossOrigin
@RequestMapping("api/pricelist")
public class PricelistController {
	
	@Autowired
	PricelistService pricelistService;

	@Autowired
	PricelistRepository pricelistRepository;
	
	ResponseMessage message = new ResponseMessage();
	
	@RequestMapping("")
	public ResponseEntity<List<Pricelist>> findAllPricelists() {
		
		List<Pricelist> pricelists = pricelistService.findAll();
		
		return new ResponseEntity<List<Pricelist>>(pricelists, HttpStatus.OK);
		
	}
	
	@RequestMapping("/createPricelist/{id}")
	public ResponseEntity<ResponseMessage> create(@RequestBody PricelistDTO pricelist, @PathVariable Long id) {
		
		Pricelist priceList = pricelistService.create(pricelist, id);
		
		if (priceList == null) {
			message.setMessage("Error during pricelist creation!");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}

		message.setMessage("Pricelist successfully created!");
		return new ResponseEntity<>(message, HttpStatus.OK);
		
	}
	
	@RequestMapping("/updatePricelist")
	public ResponseEntity<ResponseMessage> updatePricelist(@RequestBody Pricelist pricelist) {
		
		Pricelist priceList = pricelistService.update(pricelist);
		
		if (priceList == null) {
			message.setMessage("Error during pricelist update!");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}

		message.setMessage("Pricelist updated!");
		return new ResponseEntity<>(message, HttpStatus.OK);
		
	}
	
	@RequestMapping("/getByAirlineId/{id}")
	public ResponseEntity<Pricelist> updatePricelist(@PathVariable Long id) {
		
		Pricelist pricelist = pricelistService.getByAirlineId(id);
		
		if (pricelist == null) {
	
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(pricelist, HttpStatus.OK);
		
	}
	
}
