package com.hcl.bookmyflight.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingId;

	private Long flightId;

	private Long bookedBy;

	private Date bookingDateTime;

	private Double totalAmount;
	
	// private List<E> passengerDetails;

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public Long getBookedBy() {
		return bookedBy;
	}

	public void setBookedBy(Long bookedBy) {
		this.bookedBy = bookedBy;
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

	@Override
	public String toString() {
		return "BookingDetails [bookingId=" + bookingId + ", flightId=" + flightId + ", bookedBy=" + bookedBy
				+ ", bookingDateTime=" + bookingDateTime + ", totalAmount=" + totalAmount + "]";
	}

}
