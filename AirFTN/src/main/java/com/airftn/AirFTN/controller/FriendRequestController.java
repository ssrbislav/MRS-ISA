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

import com.airftn.AirFTN.dto.FriendRequestDTO;
import com.airftn.AirFTN.model.FriendRequest;
import com.airftn.AirFTN.model.ResponseMessage;
import com.airftn.AirFTN.repository.FriendRequestRepository;
import com.airftn.AirFTN.service.IFriendRequestService;

@CrossOrigin
@RestController
@RequestMapping("api/friendRequest")
public class FriendRequestController {

	@Autowired
	IFriendRequestService frService;

	FriendRequestRepository frRepository;

	ResponseMessage message = new ResponseMessage();

	@GetMapping("")
	public ResponseEntity<List<FriendRequest>> requests() {

		List<FriendRequest> friendRequests = frService.findAll();

		return new ResponseEntity<List<FriendRequest>>(friendRequests ,HttpStatus.OK);

	}

	@PostMapping("/create")
	public ResponseEntity<ResponseMessage> create(@RequestBody FriendRequestDTO request) {

		FriendRequest friendRequest = frService.create(request);

		if (friendRequest == null) {

			message.setMessage("There has been a mistake processing the request!");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
		message.setMessage("Request successfully created!");
		
		return new ResponseEntity<>(message, HttpStatus.OK);


	}

	@PostMapping("/confirmFriendRequest")
	public ResponseEntity<ResponseMessage> create(@RequestBody FriendRequest request) {

		boolean delete = frService.confirmFriendRequest(request);

		if (!delete) {

			message.setMessage("There has been a mistake processing the request!");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
		message.setMessage("Friend Request Confirmed!");
		return new ResponseEntity<>(message, HttpStatus.OK);

	}

	@PostMapping("/delete")
	public ResponseEntity<ResponseMessage> delete(@RequestBody FriendRequest request) {

		boolean deleted = frService.delete(request);

		if (!deleted) {

			message.setMessage("There has been a mistake processing the request!");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}

		message.setMessage("Friend Request rejeceted!");
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@GetMapping("findByReceiverId/id")
	public ResponseEntity<FriendRequest> findByReceiverId(@PathVariable Long id) {

		FriendRequest friendRequest = frService.findByReceiverId(id);

		if (friendRequest == null) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(HttpStatus.OK);

	}

}
