package com.hcl.bookmyflight.service;

import java.util.Optional;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.hcl.bookmyflight.dto.FlightDetailsDto;
import com.hcl.bookmyflight.dto.FlightPermissionDto;
import com.hcl.bookmyflight.dto.ResponseData;
import com.hcl.bookmyflight.entity.FlightDetails;
import com.hcl.bookmyflight.entity.User;
import com.hcl.bookmyflight.repository.FlightDetailsRepository;
import com.hcl.bookmyflight.repository.UserRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightDetailsRepository flightDetailsRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JavaMailSender sender;

	private final static String ACCOUNT_SID = "ACf73ecdd409fb";
	private final static String AUTH_ID = "d099b8077232a1";

	static {
		Twilio.init(ACCOUNT_SID, AUTH_ID);
	}

	public FlightDetails addFlight(FlightDetailsDto flightDetailsDTO) {

		FlightDetails flightDetails = new FlightDetails();
		BeanUtils.copyProperties(flightDetailsDTO, flightDetails);
		flightDetails.setPermission("PERMISSION_REQUIRED");
		flightDetails = flightDetailsRepository.save(flightDetails);
		sendMailAndSMS(flightDetails.getFlightId());
		return flightDetails;
	}

	@Override
	public ResponseData grantFlightPermissions(FlightPermissionDto permission) {
		ResponseData response = new ResponseData();
		response.setHttpStatus(HttpStatus.BAD_REQUEST);
		response.setMessage("Please use proper spelling for Approve and Reject");
		Optional<FlightDetails> flightDetail = flightDetailsRepository.findById(permission.getFlightId());
		if (flightDetail.isPresent()) {
			FlightDetails flightDetails = flightDetail.get();
			if (flightDetails.getPermission().equals("APPROVED")) {
				response.setMessage("Request is already approved");
				response.setHttpStatus(HttpStatus.BAD_REQUEST);
				response.setData(flightDetails);
				return response;
			}
			if (permission.getPermission().equalsIgnoreCase("APPROVE")) {
				flightDetails.setPermission("APPROVED");
				flightDetailsRepository.save(flightDetails);
				response.setMessage("Permission Aproved Successfully");
				response.setHttpStatus(HttpStatus.OK);
				response.setData(flightDetails);

			} else if (permission.getPermission().equalsIgnoreCase("REJECT")) {
				flightDetails.setPermission("REJECTED");
				flightDetailsRepository.deleteById(permission.getFlightId());
				response.setMessage("Permission Rejected Successfully");
				response.setHttpStatus(HttpStatus.OK);
				response.setData(flightDetails);
			}
		} else {
			response.setMessage("Flight Id is incorrect");
			response.setHttpStatus(HttpStatus.BAD_REQUEST);
		}

		return response;
	}

	@Override
	public User getAllPassengerDetails(int userId) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			return user.get();
		}
		return null;
	}

	private boolean sendMailAndSMS(long flightId) {
		try {

			String msg = "Hi Approver, Approval is pending for flight Id " + flightId;
			User user = userRepository.findById(101).get();

			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);

			helper.setTo(user.getEmailId());
			helper.setText(msg);
			helper.setSubject("Invitation for Flight Approval");
			sender.send(message);

			Message.creator(new PhoneNumber("+91" + user.getMobileNo()), new PhoneNumber("FROM Number"), msg).create();
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

		return true;
	}
}
