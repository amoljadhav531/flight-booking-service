package com.hcl.bookmyflight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bookmyflight.dto.LoginDto;
import com.hcl.bookmyflight.entity.User;
import com.hcl.bookmyflight.service.LoginServiceImpl;

@RestController
public class UserController {

	@Autowired
	LoginServiceImpl loginserviceimpl;

	@PostMapping("/login")
	public ResponseEntity<?> LoginUser(@RequestBody LoginDto logindto) {
		User user = loginserviceimpl.loginUser(logindto);

		if (user != null) {
			return new ResponseEntity<String>("Login Successful", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Invalid UserName and Password", HttpStatus.NOT_FOUND);
	}

}
