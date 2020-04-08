package com.hd.config;

import com.hd.entity.Role;
import com.hd.entity.User;
import com.hd.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权入口");
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 获取用户权限
        Role role = userService.findRoleByName(user.getName());
        //todo:role=null ??
        // 设置该用户拥有的权限
        HashSet<String> roles = new HashSet<>();
        roles.add(role.getRole_name());
        info.setRoles(roles);
        return info;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //  获取用户名
        String userName = (String)authenticationToken.getPrincipal();
        //  查询有无该用户
        User user = userService.findUserByName(userName);
        if (null == user)
        {
            // 没有该用户
            return null;
        }
        //  有该用户, 判断密码
        /**
         * 参数1： 从数据库获取的userduix
         * 参数2： 密码
         * 参数3： 当前realm名称
         */
        return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
    }
}
