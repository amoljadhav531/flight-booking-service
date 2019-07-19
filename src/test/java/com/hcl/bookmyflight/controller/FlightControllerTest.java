package com.hcl.bookmyflight.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.bookmyflight.dto.BookingDetailsDto;
import com.hcl.bookmyflight.dto.FlightDetailsDto;
import com.hcl.bookmyflight.dto.FlightPermissionDto;
import com.hcl.bookmyflight.dto.ResponseData;
import com.hcl.bookmyflight.entity.FlightDetails;
import com.hcl.bookmyflight.exception.BookMyFlightException;
import com.hcl.bookmyflight.service.FlightBookingService;
import com.hcl.bookmyflight.service.FlightServiceImpl;
import com.hcl.bookmyflight.service.SearchFlightService;

@RunWith(MockitoJUnitRunner.class)
public class FlightControllerTest {

	@Mock
	private FlightBookingService flightBookingService;

	@InjectMocks
	private FlightController fligthBookingController;

	private BookingDetailsDto bookingDto;

	private FlightDetailsDto flightDetailsDTO;

	@Mock
	private FlightServiceImpl flightServiceImpl;

	@Mock
	private SearchFlightService searchFlightService;

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

	@Test
	public void testAddFlight() {
		when(flightServiceImpl.addFlight(flightDetailsDTO)).thenReturn(new FlightDetails());
		assertNotNull(fligthBookingController.addFlight(flightDetailsDTO));
	}

	/*
	 * @Test public void testSearchFlight() {
	 * when(searchFlightService.searchFlight("source", "destination", "sortparam",
	 * LocalDate.now())) .thenReturn(Collections.emptyList());
	 * assertNotNull(fligthBookingController.searchFlight("source", "destination",
	 * "sortparam", "2019-09-09"));
	 * 
	 * }
	 */
	
	/*
	 * @Test public void testResponseData() {
	 * when(flightServiceImpl.grantFlightPermissions(Mockito.any())) .thenReturn(new
	 * ResponseData());
	 * assertNotNull(fligthBookingController.grantFlightPermissions(new
	 * FlightPermissionDto()));
	 * 
	 * }
	 */
}
