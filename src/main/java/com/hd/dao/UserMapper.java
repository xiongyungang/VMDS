package com.hd.dao;

import com.hd.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User findUserByName(String name);
}
