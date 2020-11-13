package com.hd.service;

import com.hd.entity.Auth;
import com.hd.entity.Role;

import java.util.List;

public interface RoleService {

	List<Role> list();

	List<Auth> listAuth();

	Role getRoleById(Integer id);
}
