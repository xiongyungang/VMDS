package com.hd.service.impl;

import com.hd.dao.UserMapper;
import com.hd.entity.Role;
import com.hd.entity.User;
import com.hd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper userMapper;
	
	public User findUserByName(String name){
		return userMapper.findUserByName(name);
	}

	@Override
	public Role findRoleByName(String name) {
		return userMapper.findRoleByName(name);
	}

}
