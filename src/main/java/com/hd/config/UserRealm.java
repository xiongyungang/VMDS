package com.hd.config;

import com.hd.entity.Auth;
import com.hd.entity.Role;
import com.hd.entity.User;
import com.hd.service.RoleService;
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
import java.util.List;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 这里拿到的User对象是认证时设置的SimpleAuthenticationInfo类的参数
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        // 授权信息对象
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 获取用户角色
        Role role = userService.findRoleByName(user.getName());
        //todo:role=null ??

        // 将角色名称提供给info
        HashSet<String> roles = new HashSet<>();
        roles.add(role.getRole_name());
        info.setRoles(roles);

        // 获取角色所有权限，将权限名称提供给info
        List<Auth> auths = roleService.findAuthByRoleId(role.getRole_id());
        for (Auth auth :
                auths) {
            // 设置当前用户的权限
            info.addStringPermission(auth.getAuth_name());
        }

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
        if (null == user) {
            // 没有该用户
            return null;  // 登陆时会抛出UnknownAccountException
        }

        /**
         * 密码认证
         * 参数1： 从数据库获取的userduix
         * 参数2： 密码
         * 参数3： 当前realm名称
         */
        return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
    }
}
