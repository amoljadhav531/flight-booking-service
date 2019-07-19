
package com.hcl.bookmyflight.service;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.bookmyflight.dto.LoginDto;
import com.hcl.bookmyflight.entity.BookingDetails;
import com.hcl.bookmyflight.entity.FlightDetails;
import com.hcl.bookmyflight.entity.User;
import com.hcl.bookmyflight.repository.FlightDetailsRepository;
import com.hcl.bookmyflight.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceImplTest {

	User user;
	LoginDto dto;

	@Mock
	UserRepository userrepository;

	@Mock
	private FlightDetailsRepository flightDetailsRepository;

	@InjectMocks
	LoginServiceImpl loginserviceimpl;
	
	private FlightDetails flightDetails;
	
	private List<FlightDetails> flightDetailsList;

	@Before
	public void setUp() throws Exception {
		user = new User();
		user.setEmailId("email@gmail.com");
		user.setPassword("pass");
		user.setUserId(1);
		user.setUserName("username");
		user.setRole("");
		List<BookingDetails> list = new ArrayList<>();
		BookingDetails detail = new BookingDetails();
		detail.setBookingId(1L);
		detail.setBookedBy(user);
		list.add(detail);
		user.setBookingDetails(list);

		dto = new LoginDto();
		dto.setPassword("pass");
		dto.setUserName("username");

	}

	@Test
	public void testLoginUserFaildSenario() {
		Mockito.when(userrepository.findByUserNameAndPassword("username", "pass")).thenReturn(user);
		assertTrue(loginserviceimpl.loginUser(dto).size() > 0);
	}

	@Test
	public void testLoginUserWhenRoleIsFlightUser() {
		user.setRole("flightuser");
		Mockito.when(userrepository.findByUserNameAndPassword("username", "pass")).thenReturn(user);
		assertTrue(loginserviceimpl.loginUser(dto).size() > 0);
	}

	@Test
	public void testLoginUserWhenRoleIsFlightAdmin() {
		user.setRole("flightadmin");
		Mockito.when(userrepository.findByUserNameAndPassword("username", "pass")).thenReturn(user);
		assertTrue(loginserviceimpl.loginUser(dto).size() > 0);
	}

	@Test
	public void testLoginUserWhenRoleIsSuperAdmin() {
		user.setRole("superadmin");
		Mockito.when(userrepository.findByUserNameAndPassword("username", "pass")).thenReturn(user);
		//Mockito.when(flightDetailsRepository.findByPermission("PERMISSION_REQUIRED")).thenReturn(value);
		
		assertTrue(loginserviceimpl.loginUser(dto).size() > 0);
	}

}
