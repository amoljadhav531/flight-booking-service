package com.hcl.bookmyflight.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FlightDetailsDTO {

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

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getTimeDuration() {
		return timeDuration;
	}

	public void setTimeDuration(String timeDuration) {
		this.timeDuration = timeDuration;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvalaibleSeats() {
		return avalaibleSeats;
	}

	public void setAvalaibleSeats(int avalaibleSeats) {
		this.avalaibleSeats = avalaibleSeats;
	}

}
