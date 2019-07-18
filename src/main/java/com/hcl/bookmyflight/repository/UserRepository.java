package com.hcl.bookmyflight.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.bookmyflight.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	//@Query("select u from User u where u.name = :username and u.password =:password")
	public User findByUserNameAndPassword(String username, String password);

}
