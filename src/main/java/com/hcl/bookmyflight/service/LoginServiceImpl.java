package com.hcl.bookmyflight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bookmyflight.dto.LoginDto;
import com.hcl.bookmyflight.entity.User;
import com.hcl.bookmyflight.repository.UserRepository;


@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User loginUser(LoginDto loginDto) {
		return userRepository.findByUserNameAndPassword(loginDto.getUserName(), loginDto.getPassword());
	}

}
