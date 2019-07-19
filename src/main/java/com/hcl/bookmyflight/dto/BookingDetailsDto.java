package com.hcl.bookmyflight.dto;

import java.util.List;

import lombok.Data;

@Data
public class BookingDetailsDto {

	private int bookedBy;

	private Long flightId;

	private List<PassengerDetailsDto> passengerDetails;

}
