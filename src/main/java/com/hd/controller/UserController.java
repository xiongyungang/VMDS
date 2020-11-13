package com.hd.controller;

import com.hd.entity.Auth;
import com.hd.entity.Role;
import com.hd.entity.User;
import com.hd.service.RoleService;
import com.hd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    /**
     * 用户管理
     * @return
     */
    @RequestMapping(value = "/user/users", method = RequestMethod.GET)
    public String userList(ModelMap map) {
        List<User> users = userService.list();
        for (User user:
             users) {
            Role roleById = roleService.getRoleById(user.getRole());
            user.setRoleEntity(roleById);
        }
        map.put("users", users);
        return "users";
    }

    /**
     * 角色管理
     * @param model
     * @return
     */
    @RequestMapping(value = "/user/roles", method = RequestMethod.GET)
    public String roleList(ModelMap model){
        List<Role> roles = roleService.list();
        model.put("roles", roles);
        return "roles";
    }

    /**
     * 权限管理
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/user/auth", method = RequestMethod.GET)
    public String authList(ModelMap modelMap){
        List<Auth> auths = roleService.listAuth();
        modelMap.put("auths", auths);
        return "auths";
    }
}
