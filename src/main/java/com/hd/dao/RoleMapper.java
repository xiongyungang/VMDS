package com.hd.dao;

import com.hd.entity.Auth;
import com.hd.entity.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {
    @Select("SELECT * from tb_role")
    List<Role> list();

    @Select("SELECT * FROM tb_auth")
    List<Auth> listAuth();

    @Select("SELECT * FROM tb_role WHERE role_id = #{id}")
    Role getRoleById(Integer id);
}
