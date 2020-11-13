package com.hd.dao;

import com.hd.entity.Device;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface DeviceMapper {
    List<Device> list();

    List<Device> listByDevice(Device device);
}
