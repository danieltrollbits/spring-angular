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

}
