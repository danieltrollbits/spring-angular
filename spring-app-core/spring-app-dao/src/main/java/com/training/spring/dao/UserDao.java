package com.training.spring.dao;

import com.training.spring.model.User;

public interface UserDao {

	User findByUserName(String username);

	void save(User user);
}
