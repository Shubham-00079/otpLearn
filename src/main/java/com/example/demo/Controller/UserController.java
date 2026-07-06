package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;

@Controller
public class UserController {
	
	UserService us;
	public UserController(UserService us) {
		// TODO Auto-generated constructor stub
		this.us = us;
	}
	
	@GetMapping("/register")
	String homepage() {
		return "index";
	}
	
	@PostMapping("/register")
	@ResponseBody
	String register(@ModelAttribute User user) {
		us.register(user);
		
		return "Register Sucessully";
	}
	
	@GetMapping("/login")
	String login() {
		return "login";
	}
	
	
	@PostMapping("/login")
	public String loginUser(@RequestParam String email,@RequestParam String password) {
	    if(us.login(email,password)==true) {
	    	return "otp";
	    } else {
	        return "Login Fail";
	    }
	    
	}
	
	@PostMapping("/verifyOTP")
	public String verification(@RequestParam String otp)
	{
		if(us.verification(otp))
		return "Home";
		else 
			return "Enter Wrong Otp";
	}
	
	
}
