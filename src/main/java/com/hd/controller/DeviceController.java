package com.hd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hd.entity.Device;
import com.hd.service.DeviceService;

@Controller
@RequestMapping("")
public class DeviceController {
	@Autowired
	DeviceService deviceService;
	
	@RequestMapping(value = "/rpdtester", method = RequestMethod.GET)
	public String rpdtester(ModelMap map){
		List<Device> devs = deviceService.list();
		map.put("devs", devs);
		return "rpdtester";
	}

	@RequestMapping(value = "/rpdsearch", method = RequestMethod.POST)
	public String rpdsearch(ModelMap map, @RequestParam(value = "device_name", defaultValue = "")String name,@RequestParam(value = "device_number", defaultValue = "0")Integer num){
		Device device = new Device(0, name, num, "", "","","","","");

		List<Device> devs = deviceService.listByDevice(device);
		map.put("devs", devs);
		return "rpdtester";
	}

}
