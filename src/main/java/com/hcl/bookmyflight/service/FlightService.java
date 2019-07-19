package com.hcl.bookmyflight.service;

import com.hcl.bookmyflight.dto.FlightPermission;
import com.hcl.bookmyflight.dto.ResponseData;
import com.hcl.bookmyflight.entity.User;

public interface FlightService {
	
	public ResponseData grantFlightPermissions(FlightPermission permission) ;
	
	public User getAllPassengerDetails(int userId);

}
