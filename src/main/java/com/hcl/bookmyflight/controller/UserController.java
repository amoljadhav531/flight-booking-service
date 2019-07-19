package com.hcl.bookmyflight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bookmyflight.dto.LoginDto;
import com.hcl.bookmyflight.entity.User;
import com.hcl.bookmyflight.service.FlightServiceImpl;
import com.hcl.bookmyflight.service.LoginServiceImpl;

@RestController
public class UserController {

	@Autowired
	private LoginServiceImpl loginserviceimpl;
	
	@Autowired
	private FlightServiceImpl flightServiceImpl;

	@PostMapping("/login")
	public ResponseEntity<?> LoginUser(@RequestBody LoginDto logindto) {
		return new ResponseEntity<List<String>>(loginserviceimpl.loginUser(logindto), HttpStatus.OK);
	}

	@GetMapping("/pasttravels")
	public ResponseEntity<?> getAllPassengerDetails(@RequestParam(value = "userId") Integer userId) {

		User user = flightServiceImpl.getAllPassengerDetails(userId);
		if (user != null) {
			return new ResponseEntity<>(user.getBookingDetails(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No past travels for this User", HttpStatus.NOT_FOUND);
		}
	}
}
