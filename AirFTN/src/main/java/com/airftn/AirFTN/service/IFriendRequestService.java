package com.airftn.AirFTN.service;

import java.util.List;

import com.airftn.AirFTN.dto.FriendRequestDTO;
import com.airftn.AirFTN.model.FriendRequest;

public interface IFriendRequestService {
	
	List<FriendRequest> findAllByReceiverIdAndDeletedIsFalse(Long id);

	FriendRequest create(FriendRequestDTO friendRequest);
	
	boolean delete(FriendRequest fr);
	
	boolean deleteFriend(Long receiverId, Long senderId);
	
	FriendRequest findByReceiverId(Long id);
	
	FriendRequest findBySenderId(Long id);

	boolean confirmFriendRequest(FriendRequest request);

	List<FriendRequest> findAll();
	
}
