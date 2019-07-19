package com.hcl.bookmyflight.service;

import java.sql.Date;
import java.time.LocalDate;
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
	 	
//	public List<FlightDetails> searchFlight(FlightDetailsDTO searchFlightDTO) {
//		
//		if(searchFlightDTO.getSortParam().equalsIgnoreCase("price")) {
//			return searchFlightRepository.findBySourceAndDestinationAndDateOrderByPriceAsc(searchFlightDTO.getSource(), searchFlightDTO.getDestination(), searchFlightDTO.getDate());
//		}	
//		else if(searchFlightDTO.getSortParam().equalsIgnoreCase("timeDuration")) {
//			return searchFlightRepository.findBySourceAndDestinationAndDateOrderByTimeDurationAsc(searchFlightDTO.getSource(), searchFlightDTO.getDestination(), searchFlightDTO.getDate());
//		}
//		else if(searchFlightDTO.getSortParam().equalsIgnoreCase("arrivalTime")) {
//			return searchFlightRepository.findBySourceAndDestinationAndDateOrderByArrivalTimeAsc(searchFlightDTO.getSource(), searchFlightDTO.getDestination(), searchFlightDTO.getDate());
//		}
//		else {
//			throw new ResourceNotFoundException("Sort Parameter is not specified properly. Please specify out of these <price, timeDuration, arrivalTime>", "", searchFlightDTO.getSortParam());
//		}
//		
//	}

	public List<FlightDetails> searchFlight(String source, String destination, String sortparam, LocalDate date) {
		if(sortparam.equalsIgnoreCase("price")) {
			return searchFlightRepository.findBySourceAndDestinationAndDateOrderByPriceAsc(source, destination, date);
		}
		else if(sortparam.equalsIgnoreCase("timeDuration")) {
			return searchFlightRepository.findBySourceAndDestinationAndDateOrderByTimeDurationAsc(source, destination, date);
		}
		else if(sortparam.equalsIgnoreCase("arrivalTime")) {
			return searchFlightRepository.findBySourceAndDestinationAndDateOrderByArrivalTimeAsc(source, destination, date);
		}
		else {
			throw new ResourceNotFoundException("Sort Parameter is not specified properly. Please specify out of these <price, timeDuration, arrivalTime>", "", sortparam);
		}
	}

}
