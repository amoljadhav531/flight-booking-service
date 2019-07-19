package com.hcl.bookmyflight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bookmyflight.dto.LoginDto;
import com.hcl.bookmyflight.service.LoginServiceImpl;

@RestController
public class UserController {

	@Autowired
	LoginServiceImpl loginserviceimpl;

	@PostMapping("/login")
	public ResponseEntity<?> LoginUser(@RequestBody LoginDto logindto) {
		return new ResponseEntity<List<String>>(loginserviceimpl.loginUser(logindto), HttpStatus.OK);
	}

}
