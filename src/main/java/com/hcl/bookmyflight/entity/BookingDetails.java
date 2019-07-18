package com.hcl.bookmyflight.entity;

import java.util.Date;
import java.util.List;

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

@Entity
@Table(name = "booking_details")
public class BookingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private Long bookingId;

	@Column(name = "booking_date_time")
	private Date bookingDateTime;

	@Column(name = "total_amount")
	private Double totalAmount;

	@OneToOne
	@JoinColumn(name = "flight_id")
	private FlightDetails flightDetails;

	@ManyToOne
	@JoinColumn(name = "bookedBy")
	private User bookedBy;

	@OneToMany(mappedBy = "bookingDetails")
	private List<PassengerDetails> passengerDetails;

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Date getBookingDateTime() {
		return bookingDateTime;
	}

	public void setBookingDateTime(Date bookingDateTime) {
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

}
