package com.hd.task;

import com.hd.entity.Report;
import com.hd.service.DeviceService;
import com.hd.service.RpdService;
import com.hd.service.UserService;
import com.hd.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MyTask {
    @Autowired
    DeviceService deviceService;

    @Autowired
    UserService userService;

    @Autowired
    RpdService rpdService;

    @Resource
    RedisUtils redisUtils;

    /**
     * 每过xx小时，更新redis首页数据
     */
    @Scheduled(cron = "* 1 * * * *")
    public void testTask(){

        Integer device = deviceService.count();
        Integer user = userService.count();
        Integer rpd = rpdService.count();
        //System.out.println("*****count="+ device+"**"+user+"***"+"rpd");
        Report report = new Report();
        report.setDev_num(device);
        report.setProgram_num(rpd);
        report.setUser_num(user);
        redisUtils.set("test", report);
    }
}
