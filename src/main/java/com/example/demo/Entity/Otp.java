package com.example.demo.Entity;

import jakarta.persistence.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table
public class Otp {
	@Id
	@GeneratedValue
Long otpId;
	@Column
String otp;
	@Column
Long userId;
	@Column(name = "created_at")
LocalDateTime currentTime;
public LocalDateTime getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(LocalDateTime currentTime) {
		this.currentTime = currentTime;
	}
public Otp(Long otpId, String otp, Long userId, LocalDateTime currentTime) {
		super();
		this.otpId = otpId;
		this.otp = otp;
		this.userId = userId;
		this.currentTime = currentTime;
	}
public Otp() {
	super();
	// TODO Auto-generated constructor stub
}
public Long getOtpId() {
	return otpId;
}
public void setOtpId(Long otpId) {
	this.otpId = otpId;
}
public String getOtp() {
	return otp;
}
public void setOtp(String otp) {
	this.otp = otp;
}
public Long getUserId() {
	return userId;
}
public void setUserId(Long userId) {
	this.userId = userId;
}
}
