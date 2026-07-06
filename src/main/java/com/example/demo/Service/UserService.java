package com.example.demo.Service;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Otp;
import com.example.demo.Entity.User;
import com.example.demo.Repo.OtpRepo;
import com.example.demo.Repo.UserRepo;

@Service
public class UserService {
	@Autowired
	UserRepo ur;
	@Autowired
	OtpRepo or;
	@Autowired
	JavaMailSender sender;

	public boolean login(String email, String password) {
		User tempUser = ur.findByEmail(email);

		if (tempUser == null)
			return false;

		if (!tempUser.getPassword().equals(password)) {
			return false;
		}
		int otp = new Random().nextInt(100000, 1000000);

		Otp otpUser = new Otp();
		otpUser.setUserId(tempUser.getId());
		otpUser.setOtp(String.valueOf(otp));
		otpUser.setCurrentTime(LocalDateTime.now());
		or.save(otpUser);

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(tempUser.getEmail());
		message.setSubject("OTP verification");
		message.setText("Your email " + tempUser.getEmail() + " of otp verification code is" + otp);
		sender.send(message);
		return true;
	}

	public void register(User user) {
		ur.save(user);
	}

	public boolean verification(String otp) {
		// TODO Auto-generated method stub
		Otp s = or.findByOtp(otp);
		if (otp.equals(s.getOtp())) {
			LocalDateTime expiryTime = s.getCurrentTime().plusMinutes(2);
			if (LocalDateTime.now().isBefore(expiryTime)) {
				return true;
			} else
				return false;
		}
		return false;
	}
}