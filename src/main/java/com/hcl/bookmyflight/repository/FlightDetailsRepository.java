package com.hcl.bookmyflight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.bookmyflight.entity.FlightDetails;

public interface FlightDetailsRepository extends JpaRepository<FlightDetails, Long> {
}
