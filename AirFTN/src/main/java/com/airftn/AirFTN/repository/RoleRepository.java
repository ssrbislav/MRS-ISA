package com.airftn.AirFTN.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airftn.AirFTN.enumeration.RoleType;
import com.airftn.AirFTN.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(RoleType roleName);

	List<Role> findAll();
}
