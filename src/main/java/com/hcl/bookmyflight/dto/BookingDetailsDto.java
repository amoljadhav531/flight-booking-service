package com.hcl.bookmyflight.dto;

import java.util.List;

import com.hcl.bookmyflight.entity.PassengerDetails;

public class BookingDetailsDto {

	private String userName;

	private String flightId;

	private List<PassengerDetails> passengerDetails;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public List<PassengerDetails> getPassengerDetails() {
		return passengerDetails;
	}

	public void setPassengerDetails(List<PassengerDetails> passengerDetails) {
		this.passengerDetails = passengerDetails;
	}

	@Override
	public String toString() {
		return "BookingDetailsDto [userName=" + userName + ", flightId=" + flightId + ", passengerDetails="
				+ passengerDetails + "]";
	}

}
