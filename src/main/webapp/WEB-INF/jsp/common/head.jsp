<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/25
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="layui-header">
    <div class="layui-logo">VMDS</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
        <%--<li class="layui-nav-item"><a href="">项目管理</a></li>--%>
        <%--<li class="layui-nav-item"><a href="">接口管理管理</a></li>--%>
        <%--<li class="layui-nav-item"><a href="">用例管理</a></li>--%>
        <%--<li class="layui-nav-item">--%>
            <%--<a href="javascript:;">其它系统</a>--%>
            <%--<dl class="layui-nav-child">--%>
                <%--<dd><a href="">邮件管理</a></dd>--%>
                <%--<dd><a href="">消息管理</a></dd>--%>
                <%--<dd><a href="">授权管理</a></dd>--%>
            <%--</dl>--%>
        <%--</li>--%>
    </ul>
    <ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item">
            <a href="javascript:;">
                <img src="http://t.cn/RCzsdCq";; class="layui-nav-img"/>
                贤心
            </a>
            <dl class="layui-nav-child">
                <dd><a href="">基本资料</a></dd>
                <dd><a href="">安全设置</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item"><a href="#" id="logout">退了</a></li>
    </ul>
</div>
<script>
    $("#logout").click(function () {
        $.ajax({
            url:'/userlogout',
            type:'post',
            success:function (data) {
                if (200 == data['status']){
                    window.location.href = "/index.html";
                }
            },
            error:function () {
            }
        })
    })
</script>
