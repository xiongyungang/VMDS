package com.hd.service;

import com.hd.entity.Auth;
import com.hd.entity.Role;

import java.util.List;


public interface RoleService {

	/**
	 * 通过角色id获取角色权限
	 * @param roleId	角色id
	 * @return	        权限列表
	 */
	List<Auth> findAuthByRoleId(Integer roleId);

	/**
	 * 获取所有角色
	 * @return
	 */
	List<Role> findAllRole();

	/**
	 * 获取所有权限
	 * @return
	 */
	List<Auth> findAllAuth();
}
