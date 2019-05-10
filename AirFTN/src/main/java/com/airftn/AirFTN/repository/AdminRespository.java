package com.airftn.AirFTN.repository;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRespository extends JpaRepository<Admin, Long> {

	Admin findByUsername(String username);

	Admin save(Admin admin);

}
