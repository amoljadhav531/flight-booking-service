package com.hcl.bookmyflight.dto;

import java.util.List;

public class BookingDetailsDto {

	private int bookedBy;

	private Long flightId;

	private List<PassengerDetailsDto> passengerDetails;

	public int getBookedBy() {
		return bookedBy;
	}

	public void setBookedBy(int bookedBy) {
		this.bookedBy = bookedBy;
	}

	public List<PassengerDetailsDto> getPassengerDetails() {
		return passengerDetails;
	}

	public void setPassengerDetails(List<PassengerDetailsDto> passengerDetails) {
		this.passengerDetails = passengerDetails;
	}

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	@Override
	public String toString() {
		return "BookingDetailsDto [bookedBy=" + bookedBy + ", flightId=" + flightId + ", passengerDetails="
				+ passengerDetails + "]";
	}
}
