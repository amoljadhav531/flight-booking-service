package com.hcl.bookmyflight.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FlightDetailsDTO {

	@NotNull
	@NotBlank
	private String source;
	
	@NotNull
	@NotBlank
	private String destination;
	
	@NotNull
	private LocalDate date;
	
	@NotNull
	@NotBlank
	private String sortParam;

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
