package com.airftn.AirFTN.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airftn.AirFTN.dto.FriendRequestDTO;
import com.airftn.AirFTN.model.FriendRequest;
import com.airftn.AirFTN.model.Passenger;
import com.airftn.AirFTN.repository.FriendRequestRepository;
import com.airftn.AirFTN.repository.PassengerRepository;

@Service
public class FriendRequestService implements IFriendRequestService {

	@Autowired
	FriendRequestRepository frRepository;
	
	@Autowired
	PassengerRepository passengerRepository; 
	
	@Override
	public List<FriendRequest> findAllByReceiverIdAndDeletedIsFalse(Long id) {

		return frRepository.findAllByReceiverIdAndDeletedIsFalse(id);
	}

	@Override
	public FriendRequest create(FriendRequestDTO friendRequest) {
		
		FriendRequest request = new FriendRequest();
		request.setReceiverId(friendRequest.getReceiverId());
		request.setSenderId(friendRequest.getSenderId());
		request.setDeleted(false);		
		
		return frRepository.save(request);
	}
	
	@Override
	public boolean confirmFriendRequest(FriendRequest request) {
		
		Passenger receiver = passengerRepository.getOne(request.getReceiverId());
		
		Passenger sender = passengerRepository.getOne(request.getSenderId());
		
		List<Passenger> senderList = new ArrayList<>();
		senderList.add(receiver);
		
		List<Passenger> receiverList = new ArrayList<>();
		receiverList.add(sender);
		
		receiver.setFriends(receiverList);
		
		sender.setFriends(senderList);
		
		passengerRepository.save(sender);
		passengerRepository.save(receiver);
		
		return true;
		
	}

	@Override
	public boolean delete(FriendRequest fr) {
		
		FriendRequest request = frRepository.getOne(fr.getId());
		
		frRepository.delete(request);
		
		return true;
	}

	@Override
	public boolean deleteFriend(Long receiverId, Long senderId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FriendRequest findByReceiverId(Long id) {

		return frRepository.findByReceiverId(id);		
	}

	@Override
	public FriendRequest findBySenderId(Long id) {

		return frRepository.findBySenderId(id);
	}

	@Override
	public List<FriendRequest> findAll() {
		
		return frRepository.findAll();
	}

}
