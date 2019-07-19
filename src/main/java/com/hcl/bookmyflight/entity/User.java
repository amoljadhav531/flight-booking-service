package com.hcl.bookmyflight.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userId")
public class User implements Serializable {

	private static final long serialVersionUID = -1309879943918759004L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "user_name")
	private String userName;

	private String password;

	@Column(name = "mobile_No")
	private String mobileNo;

	@Column(name = "email_id")
	private String emailId;

	@OneToMany(mappedBy = "bookedBy")
	private List<BookingDetails> bookingDetails = new ArrayList<>();

	private String role;

}
