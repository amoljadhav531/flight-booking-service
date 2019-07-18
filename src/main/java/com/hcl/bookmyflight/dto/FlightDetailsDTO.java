package com.hcl.bookmyflight.dto;

import java.time.LocalDate;

public class FlightDetailsDTO {

	Long flight_id;
	String source;
	String destination;
	LocalDate date;
	String departureTime;
	String arrivalTime;
	String timeDuration;
	Double price;
	String sortParam;
	
	public Long getFlight_id() {
		return flight_id;
	}
	public void setFlight_id(Long flight_id) {
		this.flight_id = flight_id;
	}
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getSortParam() {
		return sortParam;
	}
	public void setSortParam(String sortParam) {
		this.sortParam = sortParam;
	}
			
}
