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

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FlightDetailsRepository flightDetailsRepository; 

	@Override
	public List<String> loginUser(LoginDto loginDto) {

		User user = userRepository.findByUserNameAndPassword(loginDto.getUserName(), loginDto.getPassword());
		if (user != null && user.getRole().equalsIgnoreCase("flightuser")) {
			return responseForFlightUser(user);
		} else if (user.getRole().equalsIgnoreCase("flightadmin")) {
			return responseForFlightAdmin(user);
		} else if (user.getRole().equalsIgnoreCase("superadmin")) {
			List<FlightDetails> flightDetails = flightDetailsRepository.findByPermission("PERMISSION_REQUIRED");
			if(!flightDetails.isEmpty()) {
				List<String> list  = responseForSuperAdmin(user);
				flightDetails.stream().forEach(i -> {
					list.add(i.getFlightId().toString());
				});
				return list;
			}
			return responseForSuperAdmin(user);
		}	
		return unauthorizedUser();
		// return ;
	}

	private List<String> responseForFlightUser(User user) {
		List<String> list = new ArrayList<String>();
		list.add("Hi " + user.getUserName());
		list.add("Your Access Level is :" + user.getRole());
		list.add("You can Access following features");
		list.add("1. Search Flight");
		list.add("2. Book flight");

		return list;
	}

	private List<String> responseForFlightAdmin(User user) {
		List<String> list = new ArrayList<String>();
		list.add("Hi " + user.getUserName());
		list.add("Your Access Level is :" + user.getRole());
		list.add("You can Access following features");
		list.add("1. Search Flight");
		list.add("2. Book a flight");
		list.add("3. Add new Flight");

		return list;
	}

	private List<String> responseForSuperAdmin(User user) {
		List<String> list = new ArrayList<String>();
		list.add("Hi " + user.getUserName());
		list.add("Your Access Level is :" + user.getRole());
		list.add("You can Access following features");
		list.add("1. Search Flight");
		list.add("2. Book a flight");
		list.add("3. Add new Flight");
		list.add("4. Approve/Reject Flight");
		list.add("Following flights are waiting for your approval. Please approve");

		return list;
	}

	private List<String> unauthorizedUser() {
		List<String> list = new ArrayList<String>();
		list.add("Sorry You are not an authorized user for BookMyFlights");
		return list;
	}

}
