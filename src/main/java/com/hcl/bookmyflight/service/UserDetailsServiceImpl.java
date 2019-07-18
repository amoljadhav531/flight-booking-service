package com.hcl.bookmyflight.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bookmyflight.entity.User;

import com.hcl.bookmyflight.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepositoryForPassenger;
	
	@Override
	public User getAllPassengerDetails(int userId) {
		Optional<User> user = userRepositoryForPassenger.findById(userId);
		if (user.isPresent()) {
			return user.get();
		}

		return null;
	}

}
