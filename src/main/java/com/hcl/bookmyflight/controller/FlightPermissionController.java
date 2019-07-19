package com.hcl.bookmyflight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bookmyflight.dto.FlightPermission;
import com.hcl.bookmyflight.dto.ResponseData;
import com.hcl.bookmyflight.service.FlightService;

@RestController
@RequestMapping("/grant/permission")
public class FlightPermissionController {

	@Autowired
	private FlightService flightServiceImpl;

	@PutMapping
	public ResponseEntity<?> grantFlightPermissions(FlightPermission permission) {
		ResponseData response = flightServiceImpl.grantFlightPermissions(permission);
		return new ResponseEntity<>(response, response.getHttpStatus());
	}

}
