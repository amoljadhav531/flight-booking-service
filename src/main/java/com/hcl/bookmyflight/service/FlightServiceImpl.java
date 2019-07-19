package com.hcl.bookmyflight.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.hcl.bookmyflight.dto.FlightDetailsDTO;
import com.hcl.bookmyflight.dto.FlightPermission;
import com.hcl.bookmyflight.dto.ResponseData;
import com.hcl.bookmyflight.entity.FlightDetails;
import com.hcl.bookmyflight.repository.FlightDetailsRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightDetailsRepository flightDetailsRepository;

	public FlightDetails addFlight(FlightDetailsDTO flightDetailsDTO) {

		FlightDetails flightDetails = new FlightDetails();
		BeanUtils.copyProperties(flightDetailsDTO, flightDetails);
		flightDetails.setPermission("PERMISSION_REQUIRED");

		return flightDetailsRepository.save(flightDetails);
	}

	public ResponseData grantFlightPermissions(FlightPermission permission) {
		ResponseData response = new ResponseData();
		FlightDetails flightDetails = flightDetailsRepository.getOne(permission.getFlightId());
		if(ObjectUtils.isEmpty(flightDetails)) {
			response.setMessage("Flight Id is incorrect");
			response.setHttpStatus(HttpStatus.BAD_REQUEST);
			return response;
		}
		if (permission.getPermission().equalsIgnoreCase("APPROVED")) {
			flightDetails.setPermission("APPROVED");
			response.setMessage("Permission Aproved Successfully");
			response.setHttpStatus(HttpStatus.OK);
			response.setData(flightDetails);
		} else {
			flightDetails.setPermission("REJECTED");
			flightDetailsRepository.deleteById(permission.getFlightId());
			response.setMessage("Permission Rejected Successfully");
			response.setHttpStatus(HttpStatus.OK);
			response.setData(flightDetails);
		}

		return response;
	}

}
