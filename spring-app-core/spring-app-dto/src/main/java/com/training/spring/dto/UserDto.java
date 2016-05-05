package com.training.spring.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.Date;
import com.training.spring.model.UserRole;

public class UserDto extends BaseDto {

	private String username;

	private String password;

	private boolean enabled;

	private UserRole userRoleDto;

	private String name;

	private Date dateCreated;

	public UserDto() {
	}

	public UserDto(String username, String password, String name) {
		this.username = username;
		this.password = password;
		this.name = name;
	}

	public UserDto(String username, String password, String name, UserRole userRoleDto) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.userRoleDto = userRoleDto;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public UserRole getUserRoleDto() {
		return this.userRoleDto;
	}

	public void setUserRoleDto(UserRole userRoleDto) {
		this.userRoleDto = userRoleDto;
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}

	public Date getDateCreated(){
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated){
		this.dateCreated = dateCreated;
	}

}
