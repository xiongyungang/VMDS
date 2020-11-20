package com.hd.dao;

import com.hd.VmdsApplication;
import com.hd.dao.DeviceMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = VmdsApplication.class)
public class DeviceMapperTest {
    @Resource
    DeviceMapper deviceMapper;

    @Test
    public void list() throws Exception {
        deviceMapper.list();
        System.out.println("true = " + true);
    }

}