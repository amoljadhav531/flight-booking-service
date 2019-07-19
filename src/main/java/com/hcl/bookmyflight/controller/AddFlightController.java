package com.hcl.bookmyflight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bookmyflight.dto.FlightDetailsDTO;
import com.hcl.bookmyflight.entity.FlightDetails;
import com.hcl.bookmyflight.service.FlightServiceImpl;

@RestController
@RequestMapping("/flight")
public class AddFlightController {

	@Autowired
	FlightServiceImpl flightServiceImpl;

	@PostMapping("/add")
	public ResponseEntity<?> addFlight(@RequestBody FlightDetailsDTO flightDetailsDTO) {

		FlightDetails flightDetails = flightServiceImpl.addFlight(flightDetailsDTO);

		return new ResponseEntity<>(flightDetails, HttpStatus.OK);

	}

}
