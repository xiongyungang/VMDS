package com.hd.service.impl;

import com.hd.dao.UserMapper;
import com.hd.entity.User;
import com.hd.service.UserService;
import com.hd.utils.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;

	@Override
	public User getUserByLogin(PageData pageData) {
		return userMapper.getUserByLogin(pageData);
	}

	@Override
	public User getUserByToken(String token) {
		return userMapper.getUserByToken(token);
	}

	@Override
	public void saveUser(User user) {
		userMapper.saveUser(user);
	}

	@Override
	public List<User> list() {
		return userMapper.list();
	}

	@Override
	public List<Map> welcome() {
		return userMapper.welcome();
	}
}
