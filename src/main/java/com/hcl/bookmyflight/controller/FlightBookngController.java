package com.hcl.bookmyflight.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bookmyflight.dto.BookingDetailsDto;

/**
 * @author Administrator
 *
 */
@RestController
public class FlightBookngController {

	@PostMapping("/book")
	public ResponseEntity<?> bookFlight(@RequestBody BookingDetailsDto bookingDetailsDto) {
		return null;
	}
}
