package com.hcl.bookmyflight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.bookmyflight.entity.BookingDetails;

public interface BookingDetailsRepository extends JpaRepository<BookingDetails, Long>{

}
