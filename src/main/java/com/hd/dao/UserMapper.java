package com.hd.dao;

import com.hd.entity.User;
import com.hd.utils.PageData;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    User getUserByLogin(PageData pageData);

    void saveUser(User user);

    User getUserByToken(String token);

    @Select("select * from tb_user")
    List<User> list();

    @Select("SELECT COUNT(1) ct FROM tb_device" +
            " UNION ALL" +
            " SELECT COUNT(1) ct FROM rpd_release" +
            " UNION ALL" +
            " SELECT COUNT(1) ct FROM tb_user")
    List<Map> welcome();
}
