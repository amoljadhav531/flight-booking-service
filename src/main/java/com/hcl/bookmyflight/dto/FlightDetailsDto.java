package com.hcl.bookmyflight.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class FlightDetailsDto {

	@NotBlank
	@NotNull
	private String source;

	@NotBlank
	@NotNull
	private String destination;

	@NotNull
	private LocalDate date;

	@NotBlank
	@NotNull
	private String departureTime;

	@NotBlank
	@NotNull
	private String arrivalTime;

	@NotBlank
	@NotNull
	private String timeDuration;

	@NotNull
	private double price;

	@NotNull
	private int avalaibleSeats;

}
