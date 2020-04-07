package com.hd.service.impl;

import com.hd.entity.User;
import com.hd.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    UserService userService;

    @Test
    public void findUserByName() throws Exception {
        User user = userService.findUserByName("xyg");
        System.out.println("user = " + user);
    }

}