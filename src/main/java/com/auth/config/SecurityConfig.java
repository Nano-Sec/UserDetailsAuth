package com.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	/**
	 * Configuration for setting up authorization. The mapping of request mappings to authorities is done here
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.httpBasic()
		.and()
		.authorizeRequests()
		// Any request starting with '/admin' can only be accessed by users with authority of ADMIN 
		.antMatchers("/admin/**")
		.hasAnyAuthority("ADMIN")
		// Any request starting with '/employee' can only be accessed by users with authority of ADMIN/EMPLOYEE
		.antMatchers("/employee/**")
		.hasAnyAuthority("ADMIN", "EMPLOYEE")
		// Any request starting with '/contractor' can only be accessed by users with authority of ADMIN/CONTRACTOR
		.antMatchers("/contractor/**")
		.hasAnyAuthority("ADMIN", "CONTRACTOR")
		// Any request starting with '/public' can be accessed publicly
		.antMatchers("/public/**")
		.permitAll()
		//Any request pattern which is not specifically configured here will only be accessible by an authenticated user (Any role)
		.anyRequest()
		.authenticated()
		.and()
		.csrf()
		.disable();
	}

	/**
	 * Configuration for setting up authentication. In this case {@link UserDetailsService} is being used.
	 * Along with this, the {@link BCryptPasswordEncoder} is being used to encrypt passwords.
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

}
