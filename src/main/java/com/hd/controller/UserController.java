package com.hd.controller;

import com.hd.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class UserController {
	@Autowired
	UserService userService;

	/**
	 *	登录验证
	 *
	 * @param username	用户名
	 * @param password	密码
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/userlogin")
	public String device_management(String username, String password, Model model){
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		Subject currentUser = SecurityUtils.getSubject();

		try {
			//主体提交登录请求到SecurityManager
			currentUser.login(token);
		}catch (IncorrectCredentialsException ice){
			model.addAttribute("msg","密码不正确");
		}catch(UnknownAccountException uae){
			model.addAttribute("msg","账号不存在");
		}catch(AuthenticationException ae){
			model.addAttribute("msg","状态不正常");
		}
		if(currentUser.isAuthenticated()){
			System.out.println("认证成功");
			//model.addAttribute("currentUser", currentUser());
			return "device_management";
		}else{
			token.clear();
			return "/login.html";
		}
	}

}
