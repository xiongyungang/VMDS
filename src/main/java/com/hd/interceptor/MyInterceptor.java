package com.hd.interceptor;

import com.hd.entity.User;
import com.hd.service.UserService;
import com.hd.utils.CookieUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;

    /**
     *
     * @param httpServletRequest 请求
     * @param httpServletResponse 响应
     * @param object 当前拦截器对象
     * @return 是否将当前请求拦截下来，true将拦截处理并进入下一步骤，false请求将被终止
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        Object userBysession = httpServletRequest.getSession().getAttribute("user");
        StringBuffer requestURL = httpServletRequest.getRequestURL();
        if (userBysession == null){
            // 未登录，根据token获取用户
            String loginToken = CookieUtil.findCookieByName(httpServletRequest, "vmds_login_token");
            if (StringUtils.isNotBlank(loginToken)){
                // 获取用户
                User user = userService.getUserByToken(loginToken);
                if (user != null){
                    // 保存用户到session
                    httpServletRequest.getSession().setAttribute("user", user);

                    return true;
                } else {
                    // 用户未找到，清除cookie
                    CookieUtil.clearCookie(httpServletRequest,httpServletResponse,"vmds_login_token");
                    httpServletResponse.sendRedirect("/login.html?url="+requestURL);
                    return false;
                }
            }
            else {
                // 没有cookie，跳转登录页面
                httpServletResponse.sendRedirect("/login.html?url="+requestURL);
                return false;
            }
        }
        else {
            // 已登陆
            return  true;
        }
    }

    /**
     *
     * @param httpServletRequest 请求
     * @param httpServletResponse 响应
     * @param object 当前拦截器对象
     * @param modelAndView 模型视图对象，用于修改视图
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle111...");
    }

    /**
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion111...");
    }
}
