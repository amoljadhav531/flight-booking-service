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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
@Table(name = "flight_details")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "flightId")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
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

	private String permission;

}
