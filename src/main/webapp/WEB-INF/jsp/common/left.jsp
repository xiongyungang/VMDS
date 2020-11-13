<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/25
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <ul class="layui-nav layui-nav-tree"  lay-filter="test">
            <li class="layui-nav-item"><a href="/">首页</a></li>
            <li class="layui-nav-item"><a href="/rpdtester">设备管理</a></li>
            <li class="layui-nav-item"><a href="/rpdrelease">程序管理</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">数据管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;">任务管理</a></dd>
                    <dd><a href="javascript:;">列表二</a></dd>
                    <dd><a href="">超链接</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">统计管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;">日志管理</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">车辆数据</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">车辆配置码规则管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;">日志管理</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">用户及权限</a>
                <dl class="layui-nav-child">
                    <dd><a href="/user/users">用户管理</a></dd>
                </dl>
                <dl class="layui-nav-child">
                    <dd><a href="/user/roles">角色管理</a></dd>
                </dl>
                <dl class="layui-nav-child">
                    <dd><a href="/user/auth">权限管理</a></dd>
                </dl>
            </li>
        </ul>
    </div>
</div>