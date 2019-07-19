package com.hcl.bookmyflight.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.bookmyflight.entity.FlightDetails;

public interface FlightDetailsRepository extends JpaRepository<FlightDetails, Long> {

	public List<FlightDetails> findBySourceAndDestinationAndDate(String source, String destination, LocalDate date);
	
	public List<FlightDetails> findBySourceAndDestinationAndDateAndPermissionOrderByPriceAsc(String source, String destination, LocalDate date, String permission);
	public List<FlightDetails> findBySourceAndDestinationAndDateAndPermissionOrderByTimeDurationAsc(String source, String destination, LocalDate date, String permission);
	public List<FlightDetails> findBySourceAndDestinationAndDateAndPermissionOrderByArrivalTimeAsc(String source, String destination, LocalDate date, String permission);
	
	public List<FlightDetails> findByPermission(String permission);
}
