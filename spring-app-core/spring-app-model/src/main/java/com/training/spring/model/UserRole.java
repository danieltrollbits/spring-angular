package com.training.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;

@Entity
@Table(name = "USER_ROLES")
public class UserRole extends BaseEntity{

	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	private RoleUser role;

	public UserRole() {
	}

	public UserRole(RoleUser role) {
		this.role = role;
	}

	public RoleUser getRole() {
		return this.role;
	}

	public void setRole(RoleUser role) {
		this.role = role;
	}

}
