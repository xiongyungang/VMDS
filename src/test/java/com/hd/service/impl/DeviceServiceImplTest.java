package com.hd.service.impl;

import com.hd.entity.Device;
import com.hd.service.DeviceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public  class DeviceServiceImplTest {
    @Autowired
    DeviceService deviceService;

    @Test
    public  void list() {
        List<Device> list = deviceService.list();
        System.out.println("list = " + list);
    }

}