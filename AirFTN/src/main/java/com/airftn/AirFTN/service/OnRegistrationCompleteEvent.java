package com.airftn.AirFTN.service;

import java.util.Locale;

import org.springframework.context.ApplicationEvent;

import com.airftn.AirFTN.model.Passenger;
import com.airftn.AirFTN.model.User;

public class OnRegistrationCompleteEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	private String appUrl;
	private Locale locale;
	private Passenger passenger;

	public OnRegistrationCompleteEvent(Passenger passenger, Locale locale, String appUrl) {
		super(passenger);
		this.passenger = passenger;
		this.locale = locale;
		this.appUrl = appUrl;
	}

	public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public User getUser() {
		return passenger;
	}

	public void setUser(Passenger passenger) {
		this.passenger = passenger;
	}

}
