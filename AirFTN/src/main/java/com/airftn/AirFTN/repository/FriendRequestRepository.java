package com.airftn.AirFTN.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airftn.AirFTN.model.FriendRequest;

public interface FriendRequestRepository extends JpaRepository<FriendRequest, Long> {

	List<FriendRequest> findAllByReceiverIdAndDeletedIsFalse(Long id);
	
	List<FriendRequest> findAll();
	
	List<FriendRequest> findAllByReceiverId(Long id);
	
	List<FriendRequest> findAllBySenderId(Long id);
	
}
