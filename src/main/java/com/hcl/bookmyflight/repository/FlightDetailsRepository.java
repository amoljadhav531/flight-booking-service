package com.hcl.bookmyflight.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.bookmyflight.entity.FlightDetails;

public interface FlightDetailsRepository extends JpaRepository<FlightDetails, Long> {

	public List<FlightDetails> findBySourceAndDestinationAndDate(String Source, String Destination, LocalDate date);
	
	public List<FlightDetails> sortBySource(List<FlightDetails> listOfFlights);
	public List<FlightDetails> sortByDestination(List<FlightDetails> listOfFlights);
	public List<FlightDetails> sortByDate(List<FlightDetails> listOfFlights);
	
}
