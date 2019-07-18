package com.hcl.bookmyflight.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.bookmyflight.dto.LoginDto;
import com.hcl.bookmyflight.entity.User;

@RestController
public class UserController {

	@PostMapping("/login")
	public ResponseEntity<User> LoginUser(@RequestBody LoginDto logindto)
	{
		
		return ResponseEntity.ok(null);
	}
}
