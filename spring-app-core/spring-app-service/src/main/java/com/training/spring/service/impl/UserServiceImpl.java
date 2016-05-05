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
			userDao.save(new User(userDto.getUsername(),passwordEncoder.encode(userDto.getPassword()),userDto.getName(),UserRole.USER));
			return userDto;	
		}
	}

	@Transactional(readOnly = true)
	@Override
	public List<UserDto> getPendingUsers(){
		List<User> users = userDao.getPendingUsers();
		return toDtos(users);
	}

	@Transactional
	@Override
	public void acceptAccount(int userId){
		userDao.acceptAccount(userId);
	}

	public List<UserDto> toDtos(List<User> users){
		List<UserDto> userDtos = new ArrayList<>(); 
		for (User user : users){
			userDtos.add(toDto(user));
		}
		return userDtos;
	}

	public UserDto toDto(User user){
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setUsername(user.getUsername());
		userDto.setPassword(user.getPassword());
		userDto.setName(user.getName());
		userDto.setUserRoleDto(user.getUserRole());
		userDto.setDateCreated(user.getDateCreated());
		return userDto;
	}

}