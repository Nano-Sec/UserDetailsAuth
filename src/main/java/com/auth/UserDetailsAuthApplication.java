package com.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.auth.*"})
@ComponentScan("com.auth.*")
@EntityScan("com.auth.entities")
@EnableJpaRepositories("com.auth.repositories")
public class UserDetailsAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserDetailsAuthApplication.class, args);
	}
}
