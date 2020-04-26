package com.hd.controller;

import com.hd.entity.Device;
import com.hd.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("")
public class DeviceController {
	@Autowired
	DeviceService deviceService;

	@RequestMapping("/")
	@ResponseBody
	public String toTest() {
		return "Hello World";
	}

	/**
	 *
	 * @param map
	 * @return
	 */
	@GetMapping("/rpdtester")
	public String rpdtester(ModelMap map){
		List<Device> devs = deviceService.list();
		map.addAttribute("devs", devs);
		return "rpdtester";
	}

}
