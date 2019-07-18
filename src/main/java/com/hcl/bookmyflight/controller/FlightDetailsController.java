package com.hcl.bookmyflight.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

import com.hcl.bookmyflight.entity.User;

public class FlightDetailsController {
	
	@PostMapping("/login")
	public ResponseEntity<User> LoginUser(@RequestAttribute String username ,@RequestAttribute String password)
	{
		
		return ResponseEntity.ok(null);
	}
		

}
