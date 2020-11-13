package com.hd.service.impl;

import com.hd.dao.RoleMapper;
import com.hd.entity.Auth;
import com.hd.entity.Role;
import com.hd.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleMapper roleMapper;

	@Override
	public List<Role> list() {
		return roleMapper.list();
	}

	@Override
	public List<Auth> listAuth() {
		return roleMapper.listAuth();
	}

	@Override
	public Role getRoleById(Integer id) {
		return roleMapper.getRoleById(id);
	}
}
