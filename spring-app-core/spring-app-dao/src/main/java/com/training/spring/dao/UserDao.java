package com.training.spring.dao;

import com.training.spring.model.User;
import java.util.List;

public interface UserDao {

	User findByUserName(String username);

	void save(User user);

	List<User> getPendingUsers();

	void acceptAccount(int id);
}
