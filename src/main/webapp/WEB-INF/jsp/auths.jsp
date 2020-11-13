<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/4
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>VMDS</title>
    <link rel="stylesheet" type="text/css" href="/js/layui/css/layui.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="/js/layui/layui.js"></script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <%@include file="common/head.jsp" %>
    <%@include file="common/left.jsp" %>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <table class="layui-table">
                <colgroup>
                    <col width="150">
                    <col width="200">
                </colgroup>
                <thead>
                <tr>
                    <th>序号</th>
                    <th>权限</th>
                    <th>说明</th>
                    <th>创建时间</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${auths}" var="auth">
                    <tr>
                        <td>${auth.auth_id}</td>
                        <td>${auth.auth_name}</td>
                        <td>${auth.auth_desc}</td>
                        <td>${auth.create_time}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <%@include file="common/foot.jsp" %>
</div>

<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;
    });

</script>
</body>
</html>
