package com.hd.controller;

import com.hd.entity.User;
import com.hd.service.UserService;
import com.hd.utils.CookieUtil;
import com.hd.utils.PageData;
import com.hd.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class PageController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/userlogin", method = RequestMethod.POST)
    @ResponseBody
    public Object login(HttpSession session,HttpServletRequest request, HttpServletResponse response) {
        PageData pageData = new PageData(request);
        User user = userService.getUserByLogin(pageData);
        if (null == user) {
            // 用户未找到
            return Result.build(404, "username and password error", null);
        }

        // 添加cookie token
        Long mi = System.currentTimeMillis();
        CookieUtil.addCookie(response, "vmds_login_token", mi.toString(), 60 * 60 * 24 * 7);

        // 更新用户token
        user.setToken(mi.toString());
        userService.saveUser(user);

        session.setAttribute("user", user);
        return Result.ok();
    }

    @RequestMapping(value = "/userlogout", method = RequestMethod.POST)
    @ResponseBody
    public Object logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        session.removeAttribute("user");
        CookieUtil.clearCookie(request, response, "vmds_login_token");
        return Result.ok();
    }

    @RequestMapping(value = "/home_welcome", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    @ResponseBody
    public Object welcome(){
        List<Map> welcome = userService.welcome();
        return welcome;
    }
}
