package com.hcl.bookmyflight.service;

import com.hcl.bookmyflight.dto.FlightPermission;
import com.hcl.bookmyflight.dto.ResponseData;

public interface FlightService {
	
	public ResponseData grantFlightPermissions(FlightPermission permission) ;

}
