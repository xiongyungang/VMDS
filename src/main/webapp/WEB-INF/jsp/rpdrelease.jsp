<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/24
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>VMDS</title>
    <link rel="stylesheet" type="text/css" href="js/layui/css/layui.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="js/layui/layui.js"></script>
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
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th>版本号</th>
                    <th>系统名称</th>
                    <th>程序配置</th>
                    <th>描述</th>
                    <th>创建时间</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${rels}" var="rel">
                <tr>
                    <td><c:out value="${rel.releasenr}"/></td>
                    <td><c:out value="${rel.system}"/></td>
                    <td><c:out value="${rel.releaseconfig}"/></td>
                    <td><c:out value="${rel.releasedesc}"/></td>
                    <td><c:out value="${rel.create_time}"/></td>
                </tr>
                </c:forEach>
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