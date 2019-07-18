package com.hcl.bookmyflight.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.bookmyflight.repository.UserRepository;

public class FlightDetailsServiceImpl implements FlightDetailsServiceInterface{
	
	@Autowired
	UserRepository userrepository;

}
