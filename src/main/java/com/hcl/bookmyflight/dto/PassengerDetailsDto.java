package com.hcl.bookmyflight.dto;

public class PassengerDetailsDto {
	
	
	private String passengerName;
	
	private int passengerAge;

	private String passengerGender;

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public int getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}

	public String getPassengerGender() {
		return passengerGender;
	}

	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}

	@Override
	public String toString() {
		return "PassengerDetailsDto [passengerName=" + passengerName + ", passengerAge=" + passengerAge
				+ ", passengerGender=" + passengerGender + "]";
	}
	
	

}
