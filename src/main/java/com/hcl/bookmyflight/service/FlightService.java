package com.hcl.bookmyflight.service;

import com.hcl.bookmyflight.dto.FlightPermissionDto;
import com.hcl.bookmyflight.dto.ResponseData;
import com.hcl.bookmyflight.entity.User;

public interface FlightService {
	
	public ResponseData grantFlightPermissions(FlightPermissionDto permission) ;
	
	public User getAllPassengerDetails(int userId);

}
