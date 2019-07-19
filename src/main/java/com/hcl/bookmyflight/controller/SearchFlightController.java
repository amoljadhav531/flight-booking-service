package com.hcl.bookmyflight.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bookmyflight.dto.FlightDetailsDTO;
import com.hcl.bookmyflight.entity.FlightDetails;
import com.hcl.bookmyflight.service.SearchFlightService;

@RestController
@RequestMapping("/search")
public class SearchFlightController {

	
	@Autowired
	private SearchFlightService searchFlightService;
	
	@PostMapping("")
	public ResponseEntity<List<FlightDetails>> searchFlight(@RequestBody FlightDetailsDTO searchFlightDTO) {
		return new ResponseEntity<>(searchFlightService.searchFlight(searchFlightDTO) ,HttpStatus.OK);
	}
	
}
