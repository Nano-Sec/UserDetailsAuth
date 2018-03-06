package com.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUsername(String username);
}
