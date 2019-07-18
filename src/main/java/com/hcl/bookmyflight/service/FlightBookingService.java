package com.hcl.bookmyflight.service;

import com.hcl.bookmyflight.dto.BookingDetailsDto;
import com.hcl.bookmyflight.exception.BookMyFlightException;

public interface FlightBookingService {

	public String bookFlight(BookingDetailsDto bookingDetailsDto) throws BookMyFlightException;
}
