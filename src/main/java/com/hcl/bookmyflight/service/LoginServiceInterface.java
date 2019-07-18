package com.hcl.bookmyflight.service;

import com.hcl.bookmyflight.dto.LoginDto;
import com.hcl.bookmyflight.entity.User;

public interface LoginServiceInterface {

	public User loginUser(LoginDto loginDto);

}
