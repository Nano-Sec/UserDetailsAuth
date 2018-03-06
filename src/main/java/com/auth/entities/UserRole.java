package com.auth.entities;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;

import com.auth.utils.Enums.RoleType;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserRole implements GrantedAuthority {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "role_type")
	@Enumerated(EnumType.STRING)
	private RoleType roleType;
	
	@JsonIgnore
	@JoinColumn(name = "user_id")
	@ManyToOne
	private User user;
	
	public UserRole() {}
	
	public UserRole(User user, RoleType roleType) {
		this.roleType = roleType;
		this.user = user;
	}

	public Long getId() {
		return id;
	}
	
	public RoleType getRoleType() {
		return roleType;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String getAuthority() {
		return roleType.name();
	}


}
