package com.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.repositories.UserRepository;
import com.auth.services.AuthService;

@RestController
public class AuthController {
	@Autowired
	private AuthService authService;
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/user")
	public Object getLoggedInUser() {
		return authService.getLoggedInUser();
	}
	@RequestMapping("/admin/sample")
	public String getAdminData() {
		return "Admin Data";
	}

}
