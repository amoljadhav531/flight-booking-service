package com.hcl.bookmyflight.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "flight_details")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "flightId")
public class FlightDetails implements Serializable {

	private static final long serialVersionUID = -3577487639395886681L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "flight_id")
	private Long flightId;

	private String source;

	private String destination;

	private LocalDate date;

	@Column(name = "departure_time")
	private String departureTime;

	@Column(name = "arrival_time")
	private String arrivalTime;

	@Column(name = "time_duration")
	private String timeDuration;

	private double price;

	@Column(name = "avalaible_seats")
	private int avalaibleSeats;

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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

	public int getAvalaibleSeats() {
		return avalaibleSeats;
	}

	public void setAvalaibleSeats(int avalaibleSeats) {
		this.avalaibleSeats = avalaibleSeats;
	}

	@Override
	public String toString() {
		return "FlightDetails [flightId=" + flightId + ", source=" + source + ", destination=" + destination + ", date="
				+ date + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", timeDuration="
				+ timeDuration + ", price=" + price + ", avalaibleSeats=" + avalaibleSeats + "]";
	}
	
	

}
