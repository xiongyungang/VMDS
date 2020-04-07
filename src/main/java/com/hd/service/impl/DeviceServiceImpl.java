package com.hd.service.impl;

import com.hd.dao.DeviceMapper;
import com.hd.entity.Device;
import com.hd.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService{
	@Autowired
	DeviceMapper deviceMapper;
	
	public List<Device> list(){
		return deviceMapper.list();
	}

}
