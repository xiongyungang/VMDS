package com.hd.dao;

import com.hd.entity.Role;
import com.hd.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    /**
     * 通过用户名获取用户
     * @param name	用户名
     * @return	用户实例
     */
    User findUserByName(String name);

    /**
     * 通过用户名获取用户角色
     * @param name  用户名
     * @return 用户角色
     */
    Role findRoleByName(String name);
}
