package com.training.spring.service;

import com.training.spring.dto.UserDto;
import java.util.List;

public interface UserService {
	UserDto save(UserDto userDto);

	List<UserDto> getPendingUsers();

	void acceptAccount(int userId);
}