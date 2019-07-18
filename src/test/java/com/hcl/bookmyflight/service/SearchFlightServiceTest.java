package com.hcl.bookmyflight.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
		
		searchFlight1 = new FlightDetails();
		searchFlight1.setDate((new Date(2019-18-07)).toLocalDate());
		searchFlight1.setDestination("Delhi");
		searchFlight1.setSource("Pune");
		
		searchFlight2 = new FlightDetails();
		searchFlight2.setDate((new Date(2019-18-07)).toLocalDate());
		searchFlight2.setDestination("Delhi");
		searchFlight2.setSource("Pune");
		
		actualList = new ArrayList<FlightDetails>();
		actualList.add(searchFlight1);
		actualList.add(searchFlight2);
		
	}
	
	@Test
	public void testSearchFlightSortByPrice() {
		Mockito.when(flightDetailsRepository.findBySourceAndDestinationAndDateOrderByPriceAsc("Pune", "Delhi", new Date(2019-18-07).toLocalDate())).thenReturn(actualList);
		List<FlightDetails> actualList  = searchFlightService.searchFlight(searchFlightDTO);
		assertEquals(actualList, actualList);
	}
	

}
