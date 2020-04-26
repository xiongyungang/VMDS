package com.hd.controller;

import com.hd.service.UserService;
import com.hd.utils.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
	@ResponseBody
	public Result user_login(String username, String password, Model model){
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
			//return "/rpdtester";
			return Result.ok();
		}else{
			token.clear();
			return Result.build(233, "认证失败");
			//return "/login.html";
		}
	}

	/**
	 *	用户退出
	 *
	 * @return
	 */
	@RequestMapping(value = "/userlogout", method = RequestMethod.GET)
	@ResponseBody
	public String user_logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "OK";
	}

	@GetMapping(value = "/user")
	public String user_management(Model model)
	{
		return "user";
	}

}
