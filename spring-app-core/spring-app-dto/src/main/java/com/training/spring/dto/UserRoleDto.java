package com.training.spring.dto;

import com.training.spring.model.RoleUser;

public class UserRoleDto extends BaseDto{

	private RoleUser role;

	public UserRoleDto() {
	}

	public UserRoleDto(RoleUser role) {
		this.role = role;
	}

	public RoleUser getRole() {
		return this.role;
	}

	public void setRole(RoleUser role) {
		this.role = role;
	}

}
