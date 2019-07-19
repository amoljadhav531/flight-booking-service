package com.hcl.bookmyflight.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
@Table(name = "booking_details")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "bookingId")
public class BookingDetails implements Serializable {

	private static final long serialVersionUID = 3869291038356535511L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private Long bookingId;

	@Column(name = "booking_date_time")
	private LocalDateTime bookingDateTime;

	@Column(name = "total_amount")
	private Double totalAmount;

	@OneToOne
	@JoinColumn(name = "flight_id")
	private FlightDetails flightDetails;

	@ManyToOne
	@JoinColumn(name = "bookedBy")
	private User bookedBy;

	@OneToMany(mappedBy = "bookingDetails", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PassengerDetails> passengerDetails = new ArrayList<>();
}
