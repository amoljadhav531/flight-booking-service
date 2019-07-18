package com.hcl.bookmyflight.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bookmyflight.dto.FlightDetailsDTO;
import com.hcl.bookmyflight.entity.FlightDetails;
import com.hcl.bookmyflight.exception.ResourceNotFoundException;
import com.hcl.bookmyflight.repository.FlightDetailsRepository;

@Service
public class SearchFlightService {

	@Autowired
	private FlightDetailsRepository searchFlightRepository;
	 	
	public List<FlightDetails> searchFlight(FlightDetailsDTO searchFlightDTO) {
		
		FlightDetails searchFlightEntity = new FlightDetails();
		searchFlightEntity.setDate(searchFlightDTO.getDate());
		searchFlightEntity.setDestination(searchFlightDTO.getDestination());
		searchFlightEntity.setSource(searchFlightDTO.getSource());
		
		if(searchFlightDTO.getSortParam().equalsIgnoreCase("price")) {
			return searchFlightRepository.findBySourceAndDestinationAndDateOrderByPriceAsc(searchFlightEntity.getSource(), searchFlightEntity.getDestination(), searchFlightEntity.getDate());
		}	
		else if(searchFlightDTO.getSortParam().equalsIgnoreCase("timeDuration")) {
			return searchFlightRepository.findBySourceAndDestinationAndDateOrderByTimeDurationAsc(searchFlightEntity.getSource(), searchFlightEntity.getDestination(), searchFlightEntity.getDate());
		}
		else if(searchFlightDTO.getSortParam().equalsIgnoreCase("arrivalTime")) {
			return searchFlightRepository.findBySourceAndDestinationAndDateOrderByArrivalTimeAsc(searchFlightEntity.getSource(), searchFlightEntity.getDestination(), searchFlightEntity.getDate());
		}
		else {
			throw new ResourceNotFoundException("Sort Parameter is not specified properly. Please specify out of these <price, timeDuration, arrivalTime>", "", searchFlightDTO.getSortParam());
		}
		
	}

}
