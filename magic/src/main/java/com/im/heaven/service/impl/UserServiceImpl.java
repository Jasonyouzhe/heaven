package com.im.heaven.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.im.heaven.dao.UserDao;
import com.im.heaven.model.User;
import com.im.heaven.service.UserService;
import com.im.heaven.util.Util;

@Service
public class UserServiceImpl implements UserService {


	@Autowired
	private UserDao userDao;
	@Override
	public List<User> login(String name,String password) {
//		return (User) userDao.get(User.class, id);
		return userDao.find("from User user where user.username='"+ name +"' and user.password='"+ password+"'");
		
	}
	@Override
	public void save(User user) {
		userDao.save(user);
		
	}
	@Override
	public User findByName(String usernName) {
		StringBuffer hql = new StringBuffer("from User u where 1=1");
		List<Object> paramList = new ArrayList<>();
		if (!Util.isNull(usernName)){
			hql.append(" and u.username = ?");
			paramList.add(usernName);
		}
		return userDao.get(hql.toString(), paramList.toArray());
	}

}
