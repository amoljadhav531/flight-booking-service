package com.hcl.bookmyflight.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bookmyflight.entity.FlightDetails;
import com.hcl.bookmyflight.exception.ResourceNotFoundException;
import com.hcl.bookmyflight.repository.FlightDetailsRepository;

@Service
public class SearchFlightService {

	@Autowired
	private FlightDetailsRepository searchFlightRepository;
	

	public List<FlightDetails> searchFlight(String source, String destination, String sortparam, LocalDate date) {
		String permission = "APPROVED";
		if(sortparam.equalsIgnoreCase("price")) {
			return searchFlightRepository.findBySourceAndDestinationAndDateAndPermissionOrderByPriceAsc(source, destination, date, permission);
		}
		else if(sortparam.equalsIgnoreCase("timeDuration")) {
			return searchFlightRepository.findBySourceAndDestinationAndDateAndPermissionOrderByTimeDurationAsc(source, destination, date, permission);
		}
		else if(sortparam.equalsIgnoreCase("arrivalTime")) {
			return searchFlightRepository.findBySourceAndDestinationAndDateAndPermissionOrderByArrivalTimeAsc(source, destination, date, permission);
		}
		else {
			throw new ResourceNotFoundException("Sort Parameter is not specified properly. Please specify out of these <price, timeDuration, arrivalTime>"+sortparam);
		}
	}

}
