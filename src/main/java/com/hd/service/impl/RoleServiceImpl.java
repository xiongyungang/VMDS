package com.hd.service.impl;

import com.hd.dao.RoleMapper;
import com.hd.entity.Auth;
import com.hd.entity.Role;
import com.hd.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	RoleMapper roleMapper;

	@Override
	public List<Auth> findAuthByRoleId(Integer roleId) {
		return roleMapper.findAuthByRoleId(roleId);
	}

	@Override
	public List<Role> findAllRole() {
		return roleMapper.findAllRole();
	}

	@Override
	public List<Auth> findAllAuth() {
		return roleMapper.findAllAuth();
	}
}
