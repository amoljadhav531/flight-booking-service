package com.hcl.bookmyflight.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.bookmyflight.dto.BookingDetailsDto;
import com.hcl.bookmyflight.dto.FlightDetailsDto;
import com.hcl.bookmyflight.exception.BookMyFlightException;
import com.hcl.bookmyflight.service.FlightBookingService;

@RunWith(MockitoJUnitRunner.class)
public class FlightControllerTest {

	@Mock
	private FlightBookingService flightBookingService;

	@InjectMocks
	private FlightController fligthBookingController;

	private BookingDetailsDto bookingDto;
	
	private FlightDetailsDto flightDetailsDTO;

	@Before
	public void setUp() {
		flightDetailsDTO = new FlightDetailsDto();
	}

	@Test
	public void testBookFlightSucess() throws BookMyFlightException {
		when(flightBookingService.bookFlight(bookingDto)).thenReturn("BookingId");
		Assert.assertEquals("BookingId", (String) fligthBookingController.bookFlight(bookingDto).getBody());
	}

	@Test
	public void testBookFlightException() throws BookMyFlightException {
		when(flightBookingService.bookFlight(bookingDto)).thenThrow(new BookMyFlightException("Exception"));
		assertNotNull(fligthBookingController.bookFlight(bookingDto));
	}
	
	@Ignore
	public void testAddFlight() {
		fligthBookingController.addFlight(flightDetailsDTO);
	}
}
