package com.im.heaven.service;

import com.im.heaven.model.User;

public interface UserService {
	public java.util.List<User> login(String name,String password);
	public void save(User user);
	public User findByName(String usernName);
}
