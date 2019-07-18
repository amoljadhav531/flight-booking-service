package com.hcl.bookmyflight.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 *
 */
@RestController
public class FlightBooingController {

	@PostMapping("/book")
	public ResponseEntity<?> bookFlight() {
		return null;
	}
}
