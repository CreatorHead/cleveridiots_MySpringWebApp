package com.dev.spring.services;

import com.dev.spring.beans.User;

public interface UserServices {
	public Boolean createProfile(User user);
	public User getUser(Integer userId);
	public User removeUser(Integer userId);
	public Boolean updatePassword(Integer userId, String passwd);
	public User login(Integer userId, String password);
}
