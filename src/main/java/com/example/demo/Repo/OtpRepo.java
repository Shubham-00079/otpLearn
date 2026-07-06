package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Otp;



public interface OtpRepo extends JpaRepository<Otp, Long>{
Otp findByOtp(String otp);
}
