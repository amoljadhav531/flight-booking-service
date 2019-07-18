package com.hcl.bookmyflight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bookmyflight.dto.BookingDetailsDto;
import com.hcl.bookmyflight.exception.BookMyFlightException;
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

		try {
			return new ResponseEntity<String>(flightBookingService.bookFlight(bookingDetailsDto), HttpStatus.ACCEPTED);
		} catch (BookMyFlightException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
