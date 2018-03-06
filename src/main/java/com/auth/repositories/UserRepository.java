package com.auth.repositories;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.entities.User;

public class UserRepository implements JpaRepository<User, Long> {
	public User findByUsername(String username);
}
