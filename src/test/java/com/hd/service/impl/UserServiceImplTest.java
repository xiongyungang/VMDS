package com.hd.service.impl;

import com.hd.entity.Auth;
import com.hd.entity.User;
import com.hd.service.RoleService;
import com.hd.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Test
    public void findUserByName() throws Exception {
        User user = userService.findUserByName("xyg");
        System.out.println("user = " + user);
    }

    @Test
    public void test1()
    {
        List<Auth> auths = roleService.findAuthByRoleId(1);
        System.out.println("auths = " + auths);
    }
}