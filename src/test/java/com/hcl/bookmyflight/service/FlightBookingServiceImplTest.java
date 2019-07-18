package com.hcl.bookmyflight.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.bookmyflight.dto.BookingDetailsDto;
import com.hcl.bookmyflight.dto.PassengerDetailsDto;
import com.hcl.bookmyflight.entity.BookingDetails;
import com.hcl.bookmyflight.entity.FlightDetails;
import com.hcl.bookmyflight.entity.User;
import com.hcl.bookmyflight.exception.BookMyFlightException;
import com.hcl.bookmyflight.repository.BookingDetailsRepository;
import com.hcl.bookmyflight.repository.FlightDetailsRepository;
import com.hcl.bookmyflight.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class FlightBookingServiceImplTest {

	@InjectMocks
	private FlightBookingServiceImpl flightBookingServiceImpl;

	@Mock
	private BookingDetailsRepository bookingDetailsRepository;

	@Mock
	private FlightDetailsRepository flightDetailsRepository;

	@Mock
	private UserRepository userRepository;

	private BookingDetailsDto bookingDetailsDto;

	private Optional<FlightDetails> flightDetailsOptional;

	private Optional<User> userOptional;

	private FlightDetails flightdetails;

	private User user;

	private BookingDetails bookingDetails;

	@Before
	public void setUp() {
		bookingDetailsDto = prepareBookingDetailsDto();
		flightdetails = prepareFlightDetails();
		flightDetailsOptional = Optional.of(flightdetails);
		user = prepareUser();
		userOptional = Optional.of(user);
		bookingDetails = prepareBookingDetails(bookingDetailsDto);

	}

	@Ignore
	public void testBookFlightSuccess() throws BookMyFlightException {
		when(flightDetailsRepository.findById(bookingDetailsDto.getFlightId())).thenReturn(flightDetailsOptional);
		when(userRepository.findById(bookingDetailsDto.getBookedBy())).thenReturn(userOptional);
		when(flightDetailsRepository.save(flightdetails)).thenReturn(flightdetails);
		when(bookingDetailsRepository.save(bookingDetails)).thenReturn(bookingDetails);
		assertEquals("", flightBookingServiceImpl.bookFlight(bookingDetailsDto));
	}

	private FlightDetails prepareFlightDetails() {
		FlightDetails flightDetails = new FlightDetails();
		flightDetails.setAvalaibleSeats(10);
		return flightDetails;
	}

	private BookingDetailsDto prepareBookingDetailsDto() {
		BookingDetailsDto dto = new BookingDetailsDto();
		dto.setBookedBy(1);
		dto.setFlightId(Long.valueOf(1));

		List<PassengerDetailsDto> detailsDtos = new ArrayList<>();
		detailsDtos.add(new PassengerDetailsDto());

		dto.setPassengerDetails(detailsDtos);
		return dto;
	}

	private User prepareUser() {
		User user = new User();
		return user;
	}

	private BookingDetails prepareBookingDetails(BookingDetailsDto bookingDetailsDto) {
		BookingDetails bookingDetails = new BookingDetails();
		bookingDetails.setBookedBy(user);
		bookingDetails.setBookingDateTime(LocalDateTime.now());
		bookingDetails.setFlightDetails(flightdetails);
		bookingDetails.setTotalAmount(0.0);
		
		return bookingDetails;
	}

}
