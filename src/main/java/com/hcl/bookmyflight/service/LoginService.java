package com.hcl.bookmyflight.service;

import java.util.List;

import com.hcl.bookmyflight.dto.LoginDto;

public interface LoginService {

	public List<String> loginUser(LoginDto loginDto);

}
