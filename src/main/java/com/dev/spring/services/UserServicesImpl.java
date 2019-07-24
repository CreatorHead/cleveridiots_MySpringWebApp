package com.dev.spring.services;

import org.springframework.stereotype.Service;

import com.dev.spring.beans.User;
import com.dev.spring.dao.JPAImpl;
import com.dev.spring.dao.UserDAO;

@Service
public class UserServicesImpl implements UserServices {
	private UserDAO db = new JPAImpl();

	public Boolean createProfile(User user) {
		return db.createProfile(user);
	}

	@Override
	public User getUser(Integer userId) {
		return db.getUser(userId);
	}

	@Override
	public User removeUser(Integer userId) {
		return db.removeUser(userId);
	}

	@Override
	public Boolean updatePassword(Integer userId, String passwd) {
		return db.updatePassword(userId, passwd);
	}

	@Override
	public User login(Integer userId, String password) {
		return db.login(userId,password);
	}
}
