package com.hcl.bookmyflight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bookmyflight.dto.BookingDetailsDto;
import com.hcl.bookmyflight.service.FlightBookingService;

/**
 * @author Administrator
 *
 */
@RestController
public class FlightBookingController {

	@Autowired
	private FlightBookingService flightBookingService;

	@PostMapping("/book")
	public ResponseEntity<?> bookFlight(@RequestBody BookingDetailsDto bookingDetailsDto) {

		return new ResponseEntity<String>(flightBookingService.bookFlight(bookingDetailsDto), HttpStatus.ACCEPTED);
	}
}
