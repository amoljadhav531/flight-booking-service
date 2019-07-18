package com.hcl.bookmyflight.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bookmyflight.entity.BookingDetails;
import com.hcl.bookmyflight.entity.PassengerDetails;
import com.hcl.bookmyflight.entity.User;
import com.hcl.bookmyflight.service.UserDetailsService;

@RestController
@RequestMapping("/pasttravels")
public class UserHistoryController {

	@Autowired
	private UserDetailsService userDetailsService;

	@GetMapping()
	public ResponseEntity<?> getAllPassengerDetails(@RequestParam(value = "userId") Integer userId) {

		User user = userDetailsService.getAllPassengerDetails(userId);
		if (user != null) {
			return new ResponseEntity<>(user.getBookingDetails(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No past travels for this User", HttpStatus.NOT_FOUND);
		}
	}

}
