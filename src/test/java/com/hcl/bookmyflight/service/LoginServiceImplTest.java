package com.hcl.bookmyflight.LoginServiceTest;

import static org.junit.Assert.assertEquals;

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

import com.hcl.bookmyflight.dto.LoginDto;
import com.hcl.bookmyflight.entity.BookingDetails;
import com.hcl.bookmyflight.entity.User;
import com.hcl.bookmyflight.repository.UserRepository;
import com.hcl.bookmyflight.service.LoginServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest

public class LoginServiceImplTest {

	User user;
	LoginDto dto;
	
	@Mock
	UserRepository userrepository;
	
	@InjectMocks
	LoginServiceImpl loginserviceimpl;
	
	@Before
	public void setUp()throws Exception
	{
		user = new User();
		user.setEmailId("email@gmail.com");
		user.setPassword("pass");
		user.setUserId(1);
		user.setUserName("username");
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
	public void test()
	{
		
		Mockito.when(userrepository.findByUserNameAndPassword("username", "pass")).thenReturn(user);
		User actualUser = loginserviceimpl.loginUser(dto);
		assertEquals(user, actualUser);
	}
	
}
