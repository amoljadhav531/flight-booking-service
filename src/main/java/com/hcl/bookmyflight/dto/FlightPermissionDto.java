package com.hcl.bookmyflight.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class FlightPermissionDto {

	@NotNull
	private long flightId;
	
	@NotNull
	@NotBlank
	private String permission;
	
}
