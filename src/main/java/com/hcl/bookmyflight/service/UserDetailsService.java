package com.hcl.bookmyflight.service;


import com.hcl.bookmyflight.entity.User;

public interface UserDetailsService {

	User getAllPassengerDetails(int userId);

}