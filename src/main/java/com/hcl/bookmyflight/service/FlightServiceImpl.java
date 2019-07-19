package com.hcl.bookmyflight.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bookmyflight.dto.FlightDetailsDTO;
import com.hcl.bookmyflight.entity.FlightDetails;
import com.hcl.bookmyflight.repository.FlightDetailsRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightDetailsRepository flightDetailsRepository;

	public FlightDetails addFlight(FlightDetailsDTO flightDetailsDTO) {

		FlightDetails flightDetails = new FlightDetails();
		BeanUtils.copyProperties(flightDetailsDTO, flightDetails);
		flightDetails.setPermission("PERMISSION_REQUIRED");

		return flightDetailsRepository.save(flightDetails);
	}

}
