package com.hcl.bookmyflight.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FlightPermission {

	@NotNull
	private long flightId;
	
	@NotNull
	@NotBlank
	private String permission;

	public long getFlightId() {
		return flightId;
	}

	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	
}
