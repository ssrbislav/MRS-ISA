package com.airftn.AirFTN.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.airftn.AirFTN.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserPrinciple implements UserDetails {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String username;

	@JsonIgnore
	private String password;

	private String email;

	private String first_name;

	private String last_name;

	private String address;

	private String phone_number;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy.")
	private Date date_birth;

	private Collection<? extends GrantedAuthority> authorities;

	public UserPrinciple(Long id, String username, String password, String email, String first_name, String last_name,
			String address, String phone_number, Date date_birth, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.phone_number = phone_number;
		this.date_birth = date_birth;
		this.authorities = authorities;
	}

	public static UserPrinciple build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());

		return new UserPrinciple(user.getId(), user.getUsername(), user.getPassword(), user.getEmail(),
				user.getFirst_name(), user.getLast_name(), user.getAddress(), user.getPhone_number(),
				user.getDate_of_birth(), authorities);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public Date getDate_birth() {
		return date_birth;
	}

	public void setDate_birth(Date date_birth) {
		this.date_birth = date_birth;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
