package com.hcl.bookmyflight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bookmyflight.dto.FlightDetailsDTO;
import com.hcl.bookmyflight.entity.FlightDetails;
import com.hcl.bookmyflight.repository.FlightDetailsRepository;

@Service
public class SearchFlightService {

	@Autowired
	private FlightDetailsRepository searchFlightRepository;
	 	
	public List<FlightDetails> searchFlight(FlightDetailsDTO searchFlightDTO) {
	
		FlightDetails searchFlightEntity = new FlightDetails();
		
		searchFlightEntity.setDate(searchFlightDTO.getDate());
		searchFlightEntity.setDestination(searchFlightDTO.getDestination());
		searchFlightEntity.setFlightId(searchFlightDTO.getFlight_id());
		searchFlightEntity.setSource(searchFlightDTO.getSource());
		searchFlightEntity.setPrice(searchFlightDTO.getPrice());
		searchFlightEntity.setArrivalTime(searchFlightDTO.getArrivalTime());
		searchFlightEntity.setDepartureTime(searchFlightDTO.getDepartureTime());
		searchFlightEntity.setTimeDuration(searchFlightDTO.getTimeDuration());
		
		List<FlightDetails> listOfFlights = searchFlightRepository.findBySourceAndDestinationAndDate(searchFlightEntity.getSource(), searchFlightEntity.getDestination(), searchFlightEntity.getDate());
		
		//searchFlightRepository.findallby(listOfFlights);
		
//		if(searchFlightDTO.getSortParam().equalsIgnoreCase("source")) {
//			searchFlightRepository.sortBySource(listOfFlights);
//		}	
//		else if(searchFlightDTO.getSortParam().equalsIgnoreCase("destination")) {
//			searchFlightRepository.sortByDestination(listOfFlights);
//		}
//		else {
//			searchFlightRepository.sortByDate(listOfFlights);
//		}
//		
		return listOfFlights;
		
		
	}

}
