package com.hcl.bookmyflight.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.bookmyflight.dto.FlightDetailsDTO;
import com.hcl.bookmyflight.dto.FlightPermission;
import com.hcl.bookmyflight.dto.ResponseData;
import com.hcl.bookmyflight.entity.FlightDetails;
import com.hcl.bookmyflight.entity.User;
import com.hcl.bookmyflight.repository.FlightDetailsRepository;
import com.hcl.bookmyflight.repository.UserRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightDetailsRepository flightDetailsRepository;

	@Autowired
	private UserRepository userRepository;

	public FlightDetails addFlight(FlightDetailsDTO flightDetailsDTO) {

		FlightDetails flightDetails = new FlightDetails();
		BeanUtils.copyProperties(flightDetailsDTO, flightDetails);
		flightDetails.setPermission("PERMISSION_REQUIRED");

		return flightDetailsRepository.save(flightDetails);
	}

	public ResponseData grantFlightPermissions(FlightPermission permission) {
		ResponseData response = new ResponseData();
		response.setHttpStatus(HttpStatus.BAD_REQUEST);
		response.setMessage("Please use proper spelling for Approve and Reject");
		Optional<FlightDetails> flightDetail = flightDetailsRepository.findById(permission.getFlightId());
		if (flightDetail.isPresent()) {
			FlightDetails flightDetails = flightDetail.get();
			if (flightDetails.getPermission().equals("APPROVED")) {
				response.setMessage("Request is already approved");
				response.setHttpStatus(HttpStatus.BAD_REQUEST);
				response.setData(flightDetails);
				return response;
			}
			if (permission.getPermission().equalsIgnoreCase("APPROVE")) {
				flightDetails.setPermission("APPROVED");
				flightDetailsRepository.save(flightDetails);
				response.setMessage("Permission Aproved Successfully");
				response.setHttpStatus(HttpStatus.OK);
				response.setData(flightDetails);

			} else if (permission.getPermission().equalsIgnoreCase("REJECT")) {
				flightDetails.setPermission("REJECTED");
				flightDetailsRepository.deleteById(permission.getFlightId());
				response.setMessage("Permission Rejected Successfully");
				response.setHttpStatus(HttpStatus.OK);
				response.setData(flightDetails);
			}
		} else {
			response.setMessage("Flight Id is incorrect");
			response.setHttpStatus(HttpStatus.BAD_REQUEST);
		}

		return response;
	}

	@Override
	public User getAllPassengerDetails(int userId) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			return user.get();
		}
		return null;
	}

}
