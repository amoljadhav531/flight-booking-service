package com.hcl.bookmyflight.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bookmyflight.dto.BookingDetailsDto;
import com.hcl.bookmyflight.entity.BookingDetails;
import com.hcl.bookmyflight.entity.FlightDetails;
import com.hcl.bookmyflight.entity.User;
import com.hcl.bookmyflight.repository.FlightDetailsRepository;
import com.hcl.bookmyflight.repository.UserRepository;

@Service
public class FlightBookingServiceImpl implements FlightBookingService {
	
	@Autowired
	private FlightDetailsRepository flightDetailsRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public String bookFlight(BookingDetailsDto bookingDetailsDto) {
		Optional<FlightDetails> flightDetails = flightDetailsRepository.findById(bookingDetailsDto.getFlightId());
		Optional<User> userDetails = userRepository.findById(bookingDetailsDto.getBookedBy());
		if(userDetails.isPresent() && flightDetails.isPresent()) {
			BookingDetails bookingDetails = new BookingDetails();
			bookingDetails.setFlightDetails(flightDetails.get());
			bookingDetails.setBookedBy(userDetails.get());
			//bookingDetails.getBookingDateTime()
			
			
		}
		return null;
	}

}
