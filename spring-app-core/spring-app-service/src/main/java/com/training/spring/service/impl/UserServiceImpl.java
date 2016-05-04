package com.training.spring.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.training.spring.service.UserService;
import com.training.spring.dao.UserDao;
import com.training.spring.model.UserRole;
import com.training.spring.dto.UserDto;
import com.training.spring.model.User;
import com.training.spring.model.UserRole;
import com.training.spring.dto.UserRoleDto;
import com.training.spring.model.RoleUser;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
    private PasswordEncoder passwordEncoder;

	@Transactional
	@Override
	public UserDto save(UserDto userDto){
		if(userDao.findByUserName(userDto.getUsername()) != null){
			return null;
		}
		else{ 
			userDao.save(new User(userDto.getUsername(),passwordEncoder.encode(userDto.getPassword()),userDto.getName()));
			return userDto;	
		}
	}

	@Transactional(readOnly = true)
	@Override
	public UserDto getUsernameAndPassword(String username, String password){
		User user = userDao.getUsernameAndPassword(username, password);
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setUsername(user.getUsername());
		userDto.setPassword(user.getPassword());
		Set<UserRoleDto> userRoleDto = new HashSet<>();
		for (UserRole userRole : user.getUserRole()){
			userRoleDto.add(new UserRoleDto(userRole.getRole()));
		}
		userDto.setUserRoleDto(userRoleDto);
		return userDto;
	}

}
