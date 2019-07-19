package com.hcl.bookmyflight.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bookmyflight.dto.BookingDetailsDto;
import com.hcl.bookmyflight.dto.FlightDetailsDTO;
import com.hcl.bookmyflight.dto.FlightPermission;
import com.hcl.bookmyflight.dto.ResponseData;
import com.hcl.bookmyflight.entity.FlightDetails;
import com.hcl.bookmyflight.exception.BookMyFlightException;
import com.hcl.bookmyflight.service.FlightBookingService;
import com.hcl.bookmyflight.service.FlightServiceImpl;
import com.hcl.bookmyflight.service.SearchFlightService;

@RestController
@RequestMapping("/flight")
public class FlightController {

	@Autowired
	private FlightServiceImpl flightServiceImpl;
	@Autowired
	private SearchFlightService searchFlightService;
	
	@Autowired
	private FlightBookingService flightBookingService;


	@PostMapping("/add")
	public ResponseEntity<Object> addFlight(@RequestBody FlightDetailsDTO flightDetailsDTO) {

		FlightDetails flightDetails = flightServiceImpl.addFlight(flightDetailsDTO);

		return new ResponseEntity<>(flightDetails, HttpStatus.OK);

	}

	@GetMapping("/search")
	public ResponseEntity<List<FlightDetails>> searchFlight(@RequestParam String source,
			@RequestParam String destination, @RequestParam String sortparam, @RequestParam String date) {
		LocalDate localDate = LocalDate.parse(date);
		@DateTimeFormat(pattern = "yyyy-dd-MM") LocalDate localDate1;
		return new ResponseEntity<>(searchFlightService.searchFlight(source, destination, sortparam, localDate),
				HttpStatus.OK);
	}
	
	@PutMapping("/grant/permission")
	public ResponseEntity<Object> grantFlightPermissions(FlightPermission permission) {
		ResponseData response = flightServiceImpl.grantFlightPermissions(permission);
		return new ResponseEntity<>(response, response.getHttpStatus());
	}
	
	@PostMapping("/book")
	public ResponseEntity<Object> bookFlight(@RequestBody BookingDetailsDto bookingDetailsDto) {

		try {
			return new ResponseEntity<>(flightBookingService.bookFlight(bookingDetailsDto), HttpStatus.ACCEPTED);
		} catch (BookMyFlightException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
