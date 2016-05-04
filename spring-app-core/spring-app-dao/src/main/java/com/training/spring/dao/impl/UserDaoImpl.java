package com.training.spring.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Restrictions;

import com.training.spring.dao.UserDao;
import com.training.spring.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findByUserName(String username) {
		User user = (User) sessionFactory.getCurrentSession()
			.createCriteria(User.class)
			.add(Restrictions.eq("username",username))
			.uniqueResult();
		return user;	
	}

	@Override
	public void save(User user){
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public User getUsernameAndPassword(String username, String password){
		User user = (User) sessionFactory.getCurrentSession()
			.createCriteria(User.class)
			.add(Restrictions.eq("username",username))
			.add(Restrictions.eq("password",password))
			.uniqueResult();
		return user;	
	}

}
