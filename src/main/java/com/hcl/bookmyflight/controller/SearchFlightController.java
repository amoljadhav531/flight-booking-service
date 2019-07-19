package com.hcl.bookmyflight.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bookmyflight.entity.FlightDetails;
import com.hcl.bookmyflight.service.SearchFlightService;

@RestController
@RequestMapping("/search")
public class SearchFlightController {

	
	@Autowired
	private SearchFlightService searchFlightService;
	
	@GetMapping()
	public ResponseEntity<List<FlightDetails>> searchFlight(@RequestParam String source, @RequestParam String destination, @RequestParam String sortparam, @RequestParam String date) {
		LocalDate localDate = LocalDate.parse(date);
		return new ResponseEntity<>(searchFlightService.searchFlight(source,destination, sortparam, localDate) ,HttpStatus.OK);
	}
	
}
