package com.hcl.bookmyflight.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bookmyflight.dto.BookingDetailsDto;
import com.hcl.bookmyflight.dto.PassengerDetailsDto;
import com.hcl.bookmyflight.entity.BookingDetails;
import com.hcl.bookmyflight.entity.FlightDetails;
import com.hcl.bookmyflight.entity.PassengerDetails;
import com.hcl.bookmyflight.entity.User;
import com.hcl.bookmyflight.repository.BookingDetailsRepository;
import com.hcl.bookmyflight.repository.FlightDetailsRepository;
import com.hcl.bookmyflight.repository.UserRepository;

@Service
public class FlightBookingServiceImpl implements FlightBookingService {

	@Autowired
	private FlightDetailsRepository flightDetailsRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookingDetailsRepository bookingDetailsRepository;

	@Override
	public String bookFlight(BookingDetailsDto bookingDetailsDto) {
		Optional<FlightDetails> flightDetails = flightDetailsRepository.findById(bookingDetailsDto.getFlightId());
		Optional<User> userDetails = userRepository.findById(bookingDetailsDto.getBookedBy());
		if (userDetails.isPresent() && flightDetails.isPresent()) {
			if(flightDetails.get().getAvalaibleSeats() < bookingDetailsDto.getPassengerDetails().size()) {
				return "Seats Not Available. Please try another flight";
			}
			FlightDetails details = flightDetails.get();
			details.setAvalaibleSeats(details.getAvalaibleSeats() - bookingDetailsDto.getPassengerDetails().size());
			BookingDetails bookingDetails = new BookingDetails();
			bookingDetails.setFlightDetails(details);
			bookingDetails.setBookedBy(userDetails.get());
			bookingDetails.setBookingDateTime(LocalDateTime.now());

			List<PassengerDetails> passengerDetails = new ArrayList<>();
			for (PassengerDetailsDto dto : bookingDetailsDto.getPassengerDetails()) {
				PassengerDetails passengerDetail = new PassengerDetails();
				passengerDetail.setBookingDetails(bookingDetails);
				BeanUtils.copyProperties(dto, passengerDetail);
				passengerDetails.add(passengerDetail);

			}

			bookingDetails.setPassengerDetails(passengerDetails);
			bookingDetails.setTotalAmount(flightDetails.get().getPrice() * passengerDetails.size());
			flightDetailsRepository.save(details);
			return bookingDetailsRepository.save(bookingDetails).getBookingId().toString();

		}
		return "Invalid UserId or Flight Id ";
	}

}
