package com.hcl.bookmyflight.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.bookmyflight.entity.FlightDetails;

public interface FlightDetailsRepository extends JpaRepository<FlightDetails, Long> {

	public List<FlightDetails> findBySourceAndDestinationAndDate(String source, String destination, LocalDate date);
	
	public List<FlightDetails> findBySourceAndDestinationAndDateOrderByPriceAsc(String source, String destination, LocalDate date);
	public List<FlightDetails> findBySourceAndDestinationAndDateOrderByTimeDurationAsc(String source, String destination, LocalDate date);
	public List<FlightDetails> findBySourceAndDestinationAndDateOrderByArrivalTimeAsc(String source, String destination, LocalDate date);
	
}
