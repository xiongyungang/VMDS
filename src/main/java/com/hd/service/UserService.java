package com.hd.service;

import com.hd.entity.User;
import com.hd.utils.PageData;

import java.util.List;
import java.util.Map;

public interface UserService {

	User getUserByLogin(PageData pageData);

	User getUserByToken(String token);

	void saveUser(User user);

	List<User> list();

	List<Map> welcome();
}
