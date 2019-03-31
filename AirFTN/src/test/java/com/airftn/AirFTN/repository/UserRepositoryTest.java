package com.airftn.AirFTN.repository;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.airftn.AirFTN.model.Passenger;
import com.airftn.AirFTN.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	User user;

	@Before
	public void initialize() {
		user = new Passenger(true, "passenger@email.com", "passenger", "password", "", "", "", "", new Date());
		userRepository.save(user);
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testFindByUsername() {
		
		User findPassenger = userRepository.getOne(user.getId());
		assertEquals(user.getUsername(), findPassenger.getUsername());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testFindById() {
		
		User findPassenger = userRepository.getOne(user.getId());
		assertEquals(user.getId(), findPassenger.getId());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testExistByUsername() {
		
		User findPassenger = userRepository.getOne(user.getId());
		assertEquals(user.getUsername(), findPassenger.getUsername());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testExistByEmail() {
		
		User findPassenger = userRepository.getOne(user.getId());
		assertEquals(user.getEmail(), findPassenger.getEmail());
	}
	
}
