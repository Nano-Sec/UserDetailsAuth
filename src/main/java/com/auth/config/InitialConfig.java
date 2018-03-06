package com.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.auth.entities.User;
import com.auth.entities.UserRole;
import com.auth.repositories.UserRepository;
import com.auth.utils.Enums.RoleType;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

@Configuration
public class InitialConfig {
	@Autowired
	private UserRepository userRepository;

	private void addUserIfAbsent(BCryptPasswordEncoder passwordEncoder, String username, String firstName, String lastName, RoleType ...roleTypes) {
		User user = userRepository.findByUsername(username);
		if(user == null) {
			user = new User(username, passwordEncoder.encode("Pass2416"), firstName, lastName);
			Builder<UserRole> builder = new ImmutableList.Builder<UserRole>();
			for (RoleType roleType : roleTypes) {
				builder = builder.add(new UserRole(user, roleType));
			}
			user.setUserRoles(builder.build());
			userRepository.save(user);
		}
	}
	
	//Encoder can be passed into the configuration autowire since it's a bean
	@Autowired
	protected void setupDefaultUsers(BCryptPasswordEncoder passwordEncoder) {
		addUserIfAbsent(passwordEncoder, "admin", "Admin", "User", RoleType.ADMIN, RoleType.EMPLOYEE);
	}	


}
