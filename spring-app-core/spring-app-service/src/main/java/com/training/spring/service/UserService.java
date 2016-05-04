package com.training.spring.service;

import com.training.spring.dto.UserDto;

public interface UserService {
	UserDto save(UserDto userDto);

	UserDto getUsernameAndPassword(String username, String password);
}