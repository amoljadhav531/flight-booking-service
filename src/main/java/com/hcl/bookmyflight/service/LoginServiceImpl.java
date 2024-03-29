package com.hcl.bookmyflight.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bookmyflight.dto.LoginDto;
import com.hcl.bookmyflight.entity.FlightDetails;
import com.hcl.bookmyflight.entity.User;
import com.hcl.bookmyflight.repository.FlightDetailsRepository;
import com.hcl.bookmyflight.repository.UserRepository;

@Service
public class LoginServiceImpl implements LoginService {

	private static final String BOOK_FLIGHT = "2. Book flight";

	private static final String CONSTANT = "Hi ";

	private static final String APPROVE_REJECT_FLIGHT = "4. Approve/Reject Flight";

	private static final String ADD_NEW_FLIGHT = "3. Add new Flight";

	private static final String BOOK_A_FLIGHT = "2. Book a flight";

	private static final String SEARCH_FLIGHT = "1. Search Flight";

	private static final String ACCESS_FEATURES = "You can Access following features";

	public static final String ACCESS_LEVEL_CONSTANT = "Your Access Level is :";
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FlightDetailsRepository flightDetailsRepository; 

	@Override
	public List<String> loginUser(LoginDto loginDto) {

		User user = userRepository.findByUserNameAndPassword(loginDto.getUserName(), loginDto.getPassword());
		if(null == user) {
			return unauthorizedUser();
		}
		if (null != user.getRole() && user.getRole().equalsIgnoreCase("flightuser")) {
			return responseForFlightUser(user);
		} else if (null != user.getRole()  && user.getRole().equalsIgnoreCase("flightadmin")) {
			return responseForFlightAdmin(user);
		} else if (null != user.getRole() && user.getRole().equalsIgnoreCase("superadmin")) {
			List<FlightDetails> flightDetails = flightDetailsRepository.findByPermission("PERMISSION_REQUIRED");
			if(!flightDetails.isEmpty()) {
				List<String> list  = responseForSuperAdmin(user);
				flightDetails.stream().forEach(i -> list.add(i.getFlightId().toString()));
				return list;
			}
			return responseForSuperAdmin(user);
		}	
		return unauthorizedUser();
	}

	private List<String> responseForFlightUser(User user) {
		List<String> list = new ArrayList<>();
		list.add(CONSTANT + user.getUserName());
		list.add(ACCESS_LEVEL_CONSTANT + user.getRole());
		list.add(ACCESS_FEATURES);
		list.add(SEARCH_FLIGHT);
		list.add(BOOK_FLIGHT);

		return list;
	}

	private List<String> responseForFlightAdmin(User user) {
		List<String> list = new ArrayList<>();
		list.add(CONSTANT + user.getUserName());
		list.add(ACCESS_LEVEL_CONSTANT + user.getRole());
		list.add(ACCESS_FEATURES);
		list.add(SEARCH_FLIGHT);
		list.add(BOOK_A_FLIGHT);
		list.add(ADD_NEW_FLIGHT);

		return list;
	}

	private List<String> responseForSuperAdmin(User user) {
		List<String> list = new ArrayList<>();
		list.add(CONSTANT + user.getUserName());
		list.add(ACCESS_LEVEL_CONSTANT + user.getRole());
		list.add(ACCESS_FEATURES);
		list.add(SEARCH_FLIGHT);
		list.add(BOOK_A_FLIGHT);
		list.add(ADD_NEW_FLIGHT);
		list.add(APPROVE_REJECT_FLIGHT);
		list.add("Following flights are waiting for your approval. Please approve");

		return list;
	}

	private List<String> unauthorizedUser() {
		List<String> list = new ArrayList<>();
		list.add("Sorry You are not an authorized user for BookMyFlights");
		return list;
	}

}
