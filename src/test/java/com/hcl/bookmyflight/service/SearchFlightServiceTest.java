package com.hcl.bookmyflight.service;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.bookmyflight.dto.FlightDetailsDTO;
import com.hcl.bookmyflight.entity.FlightDetails;
import com.hcl.bookmyflight.exception.ResourceNotFoundException;
import com.hcl.bookmyflight.repository.FlightDetailsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchFlightServiceTest {

	FlightDetailsDTO searchFlightDTO;
	FlightDetailsDTO searchFlightDTOForExcpetion;
	FlightDetailsDTO searchFlightWrongSortByException;
	FlightDetails searchFlight1;
	FlightDetails searchFlight2;
	List<FlightDetails> actualList;
	
	@Mock
	FlightDetailsRepository flightDetailsRepository;
	
	@InjectMocks
	SearchFlightService searchFlightService;
	
	@Before
	public void setUp() throws Exception {
		searchFlightDTO = new FlightDetailsDTO();
		searchFlightDTO.setDate((new Date(2019-18-07)).toLocalDate());
		searchFlightDTO.setDestination("Delhi");
		searchFlightDTO.setSortParam("price");
		searchFlightDTO.setSource("Pune");
		
		searchFlightDTOForExcpetion = new FlightDetailsDTO();
		searchFlightDTOForExcpetion.setDate((new Date(2019-18-07)).toLocalDate());
		searchFlightDTOForExcpetion.setDestination("");
		searchFlightDTOForExcpetion.setSortParam("price");
		searchFlightDTOForExcpetion.setSource("");
		
		searchFlightWrongSortByException = new FlightDetailsDTO();
		searchFlightWrongSortByException.setDate((new Date(2019-18-07)).toLocalDate());
		searchFlightWrongSortByException.setDestination("Delhi");
		searchFlightWrongSortByException.setSortParam("date");
		searchFlightWrongSortByException.setSource("Pune");
		
		searchFlight1 = new FlightDetails();
		searchFlight1.setDate((new Date(2019-18-07)).toLocalDate());
		searchFlight1.setDestination("Delhi");
		searchFlight1.setSource("Pune");
		searchFlight1.setAvalaibleSeats(16);
		searchFlight1.setArrivalTime("09:00");
		searchFlight1.setDepartureTime("07:00");
		searchFlight1.setFlightId(1L);
		searchFlight1.setPrice(7200.00);
		searchFlight1.setTimeDuration("2");
		
		searchFlight2 = new FlightDetails();
		searchFlight2.setDate((new Date(2019-18-07)).toLocalDate());
		searchFlight2.setDestination("Delhi");
		searchFlight2.setSource("Pune");
		searchFlight2.setAvalaibleSeats(6);
		searchFlight2.setArrivalTime("23:00");
		searchFlight2.setDepartureTime("21:00");
		searchFlight2.setFlightId(2L);
		searchFlight2.setPrice(8900.00);
		searchFlight2.setTimeDuration("2");
		
		
		actualList = new ArrayList<FlightDetails>();
		
		
		
		
	}

	@Test
	public void testSearchFlightSortByPrice() {
		actualList.add(searchFlight1);
		actualList.add(searchFlight2);
		Mockito.when(flightDetailsRepository.findBySourceAndDestinationAndDateOrderByPriceAsc("Pune", "Delhi", new Date(2019-18-07).toLocalDate())).thenReturn(actualList);
		List<FlightDetails> actualList  = searchFlightService.searchFlight(searchFlightDTO);
		assertEquals(actualList, actualList);
	}
	
	@Test
	public void testSearchFlightSortByTimeDuration() {
		searchFlightDTO.setSortParam("timeDuration");
		actualList.add(searchFlight1);
		actualList.add(searchFlight2);
		Mockito.when(flightDetailsRepository.findBySourceAndDestinationAndDateOrderByTimeDurationAsc("Pune", "Delhi", new Date(2019-18-07).toLocalDate())).thenReturn(actualList);
		List<FlightDetails> actualList  = searchFlightService.searchFlight(searchFlightDTO);
		assertEquals(actualList, actualList);
	}
	
	@Test
	public void testSearchFlightSortByArrivalTime() {
		searchFlightDTO.setSortParam("arrivalTime");
		actualList.add(searchFlight1);
		actualList.add(searchFlight2);
		Mockito.when(flightDetailsRepository.findBySourceAndDestinationAndDateOrderByArrivalTimeAsc("Pune", "Delhi", new Date(2019-18-07).toLocalDate())).thenReturn(actualList);
		List<FlightDetails> actualList  = searchFlightService.searchFlight(searchFlightDTO);
		assertEquals(actualList, actualList);
	}
	
	@Test(expected = ResourceNotFoundException.class)
	public void testSearchFlightWrongSortByParam() {
		searchFlightService.searchFlight(searchFlightWrongSortByException);
	}
}