package com.hcl.bookmyflight.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
@Table(name = "passenger_details")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "passengerId")
public class PassengerDetails implements Serializable {

	private static final long serialVersionUID = 4088343444884333897L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "passenger_id")
	private Long passengerId;

	@Column(name = "passenger_name")
	private String passengerName;

	@Column(name = "passenger_age")
	private int passengerAge;

	@Column(name = "passenger_gender")
	private String passengerGender;

	@ManyToOne
	@JoinColumn(name = "booking_id")
	private BookingDetails bookingDetails;

}
