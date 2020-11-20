package com.hd.controller;

import com.hd.entity.Auth;
import com.hd.entity.Role;
import com.hd.entity.User;
import com.hd.service.RoleService;
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

import java.util.List;

@Controller
@RequestMapping("")
public class UserController {
	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;

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
		// 封装当前用户数据
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		// 获取当前用户
		Subject currentUser = SecurityUtils.getSubject();

		try {
			// 执行登陆操作
			// 主体提交登录请求到SecurityManager
			currentUser.login(token);
		}catch (IncorrectCredentialsException ice){
			model.addAttribute("msg","密码不正确");
		}catch(UnknownAccountException uae){
			model.addAttribute("msg","账号不存在");
		}catch(AuthenticationException ae){
			model.addAttribute("msg","状态不正常");
		}
		if(currentUser.isAuthenticated()){
			return Result.ok("auth success");
		}else{
			token.clear();
			return Result.build(100001, "auth fail");
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

	/**
	 * 用户管理
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/user")
	public String user_management(Model model)
	{
		//获取所有用户
		List<User> users = userService.getAllUser();
		model.addAttribute("users", users);
		return "user";
	}

	/**
	 * 角色管理
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/role")
	public String role_management(Model model)
	{
		//获取所有角色
		List<Role> roles = roleService.findAllRole();
		model.addAttribute("roles", roles);
		return "role";
	}

	/**
	 * 权限管理
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/auth")
	public String auth_management(Model model)
	{
		//获取所有权限
		List<Auth> auths = roleService.findAllAuth();
		model.addAttribute("auths", auths);
		return "auth";
	}

}
