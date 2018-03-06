package com.auth.services;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
	public Object getLoggedInUser() {
		/**
		 * The SecurityContextHolder is used for accessing the details of the logged in user. The Principal object stores the details required.
		 */
		return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

}
