package com.example.demo.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.auth.UserAuthEntity;
import com.example.demo.service.UserAuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/auth")
public class UserAuthController {
	
	@Autowired
	UserAuthService userAuthService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody UserAuthEntity userAuthDetails) {
		// encode password
		userAuthDetails.setPassword(passwordEncoder.encode(userAuthDetails.getPassword()));
		// save user
		userAuthService.save(userAuthDetails);
		 
		 return  ResponseEntity.ok("User registered successfully!");
	}
	


}
