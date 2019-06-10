package com.airftn.AirFTN.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airftn.AirFTN.dto.TransferPointDTO;
import com.airftn.AirFTN.model.ResponseMessage;
import com.airftn.AirFTN.model.TransferPoint;
import com.airftn.AirFTN.service.ITransferPointService;

@CrossOrigin
@RestController
@RequestMapping("api/transferPoint")
public class TransferPointController {
	
	@Autowired
	ITransferPointService transferPointService;
	
	ResponseMessage message;
	
	@GetMapping("")
	public ResponseEntity<List<TransferPoint>> findAll() {
		
		List<TransferPoint> transferPoints = transferPointService.findAll();
		
		return new ResponseEntity<List<TransferPoint>>(transferPoints, HttpStatus.OK);
		
	}

	@GetMapping("/getTP/{id}")
	public ResponseEntity<TransferPoint> getOne(@PathVariable Long id) {
	
		TransferPoint tp = transferPointService.getOne(id);
		
		if(tp == null)
			return new ResponseEntity<TransferPoint>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<TransferPoint>(tp, HttpStatus.OK);
		
	}
	
	@PostMapping("/createTP")
	public ResponseEntity<ResponseMessage> create(@RequestBody TransferPointDTO transferPoint) {
		
		TransferPoint tp = transferPointService.create(transferPoint);
		
		if(tp == null) {
			
			message.setMessage("Not able to create new Trnasfer Point");
			return new ResponseEntity<ResponseMessage>(message, HttpStatus.BAD_REQUEST);
		}
		
		message.setMessage("Transfer Point successfully created!");
		
		return new ResponseEntity<ResponseMessage>(message, HttpStatus.OK);
		
	}
	
	@PostMapping("/updateTP")
	public ResponseEntity<ResponseMessage> update(@RequestBody TransferPoint transferPoint) {
		
		TransferPoint tp = transferPointService.update(transferPoint);
		
		if(tp == null) {
			
			message.setMessage("Not able update new Trnasfer Point");
			return new ResponseEntity<ResponseMessage>(message, HttpStatus.BAD_REQUEST);
		}
		
		message.setMessage("Transfer Point successfully updated!");
		
		return new ResponseEntity<ResponseMessage>(message, HttpStatus.OK);
	}
	
	@PostMapping("/deleteTP")
	public ResponseEntity<ResponseMessage> delete(@PathVariable Long id) {
		
		boolean deleted = transferPointService.delete(id);
		
		if(!deleted) {
			message.setMessage("Not able to delete transfer point!");
			
			return new ResponseEntity<ResponseMessage>(message, HttpStatus.NOT_FOUND);
		}
		
		message.setMessage("Transfer point successfully deleted!");
		
		return new ResponseEntity<ResponseMessage>(message, HttpStatus.OK);
	}
	
	

}
