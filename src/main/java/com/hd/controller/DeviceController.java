package com.hd.controller;

import com.hd.entity.Device;
import com.hd.entity.Report;
import com.hd.service.DeviceService;
import com.hd.service.RpdService;
import com.hd.service.UserService;
import com.hd.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("")
public class DeviceController {
	@Autowired
	DeviceService deviceService;
	@Autowired
	UserService userService;
	@Autowired
	RpdService rpdService;

	@Resource
	RedisUtils redisUtils;

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

	@GetMapping("/redis_home")
	@ResponseBody
	public Object redis_home(){
		return redisUtils.get("test");
	}

	@GetMapping("/home_reset")
	@ResponseBody
	public Object home_reset(){
		Integer device = deviceService.count();
		Integer user = userService.count();
		Integer rpd = rpdService.count();
		Report report = new Report();
		report.setDev_num(device);
		report.setProgram_num(rpd);
		report.setUser_num(user);
		boolean status = redisUtils.set("test", report);
		report.setStatus(status==true?"true":"false");
		return report;
	}
}
