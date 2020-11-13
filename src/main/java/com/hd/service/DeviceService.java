package com.hd.service;

import com.hd.entity.Device;
import com.hd.entity.Report;

import java.util.List;

public interface DeviceService {

	List<Device> list();

	Integer count();
}
