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

@Entity
@Table(name = "booking_details")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "bookingId")
public class BookingDetails implements Serializable{

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

	@OneToMany(mappedBy = "bookingDetails", cascade = CascadeType.ALL, orphanRemoval =true)
	private List<PassengerDetails> passengerDetails = new ArrayList<>();

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public LocalDateTime getBookingDateTime() {
		return bookingDateTime;
	}

	public void setBookingDateTime(LocalDateTime bookingDateTime) {
		this.bookingDateTime = bookingDateTime;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public FlightDetails getFlightDetails() {
		return flightDetails;
	}

	public void setFlightDetails(FlightDetails flightDetails) {
		this.flightDetails = flightDetails;
	}

	public User getBookedBy() {
		return bookedBy;
	}

	public void setBookedBy(User bookedBy) {
		this.bookedBy = bookedBy;
	}

	public List<PassengerDetails> getPassengerDetails() {
		return passengerDetails;
	}

	public void setPassengerDetails(List<PassengerDetails> passengerDetails) {
		this.passengerDetails = passengerDetails;
	}

	@Override
	public String toString() {
		return "BookingDetails [bookingId=" + bookingId + ", bookingDateTime=" + bookingDateTime + ", totalAmount="
				+ totalAmount + ", flightDetails=" + flightDetails + ", bookedBy=" + bookedBy + ", passengerDetails="
				+ passengerDetails + "]";
	}

}
