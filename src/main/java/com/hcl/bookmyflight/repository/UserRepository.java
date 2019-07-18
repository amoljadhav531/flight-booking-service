package com.hcl.bookmyflight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hcl.bookmyflight.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	//@Query("select u from User u where u.name = :username and u.password =:password")
	public User findByUsernameAndPassword(String username, String password);
	
	

}
