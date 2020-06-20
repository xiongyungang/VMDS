package com.hd.dao;

import com.hd.entity.Auth;
import com.hd.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {

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
