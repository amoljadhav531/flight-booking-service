package com.hcl.bookmyflight.dto;

import java.time.LocalDate;

public class FlightDetailsDTO {

	String source;
	String destination;
	LocalDate date;
	String sortParam;
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
	public String getSortParam() {
		return sortParam;
	}
	public void setSortParam(String sortParam) {
		this.sortParam = sortParam;
	}
	
	
	
}
