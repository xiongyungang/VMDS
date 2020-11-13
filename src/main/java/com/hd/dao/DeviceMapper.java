package com.hd.dao;

import com.hd.entity.Device;
import com.hd.entity.Report;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceMapper {
    List<Device> list();

    /**
     * 获取设备数
     * @return
     */
    Integer count();
}
