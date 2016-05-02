package com.training.spring.dto;

import java.util.HashSet;
import java.util.Set;
import com.training.spring.dto.UserRoleDto;

public class UserDto extends BaseDto {

	private String username;

	private String password;

	private boolean enabled;

	private Set<UserRoleDto> userRoleDto = new HashSet<UserRoleDto>(0);

	private String name;

	public UserDto() {
	}

	public UserDto(String username, String password, String name) {
		this.username = username;
		this.password = password;
		this.name = name;
	}

	public UserDto(String username, String password, String name, Set<UserRoleDto> userRoleDto) {
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

	public Set<UserRoleDto> getUserRoleDto() {
		return this.userRoleDto;
	}

	public void setUserRoleDto(Set<UserRoleDto> userRoleDto) {
		this.userRoleDto = userRoleDto;
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}

}
