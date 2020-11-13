<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/24
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="xyg" %>
<html>
<head>
    <title>VMDS</title>
    <link rel="stylesheet" type="text/css" href="js/layui/css/layui.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="js/layui/layui.js"></script>
    <script>

        function openModak() {
            //$("[name='testname']").val("xxxxxxxxxxxxxxx");//向模态框中赋值
            layui.use(['layer'], function () {
                var layer = layui.layer, $ = layui.$;
                layer.open({
                    type: 1,//类型
                    area: ['400px', '300px'],//定义宽和高
                    title: '编辑信息',//题目
                    shadeClose: false,//点击遮罩层关闭
                    content: $('#motaikunag')//打开的内容
                });
            })
        }
    </script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

    <%@include file="common/head.jsp" %>

    <%@include file="common/left.jsp" %>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <button type="button" onclick="openModak()" class="layui-btn layui-btn-primary">查询设备</button>
            <table class="layui-table">
                <colgroup>
                    <col width="150">
                    <col width="200">
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th>序号</th>
                    <th>设备名称</th>
                    <th>设备号</th>
                    <th>当前版本</th>
                    <th>下发版本</th>
                    <th>引擎当前版本</th>
                    <th>引擎下发版本</th>
                    <th>下载时间</th>
                    <th>创建时间</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${devs}" var="dev">
                <tr>
                    <td><c:out value="${dev.device_id}"/></td>
                    <td><c:out value="${dev.device_name}"/></td>
                    <td><c:out value="${dev.device_number}"/></td>
                    <td><c:out value="${dev.curr_vers}"/></td>
                    <td><c:out value="${dev.issue_vers}"/></td>
                    <td><c:out value="${dev.ecurr_vers}"/></td>
                    <td><c:out value="${dev.eissue_vers}"/></td>
                    <td><c:out value="${dev.down_time}"/></td>
                    <td><c:out value="${dev.create_time}"/></td>
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

    function searchform() {
        $.ajax({
            type: 'get',
            url: 'rpdsearch',
            data: $("#rpdform").serialize(),
            success: function (result) {
                window.location.reload();
            },
            error: function (err) {
                alert("error");
            }
        })
    }

</script>
</body>
</html>

<!--模仿bootstrap的模态框-->
<div id="motaikunag" style="display: none;">
    <%--<div class="layui-row">--%>
    <%--<div class="layui-col-md9">--%>
    <%--你的内容 9/12--%>
    <%--</div>--%>
    <%--<div class="layui-col-md3">--%>
    <%--你的内容 3/12--%>
    <%--</div>--%>
    <%--</div>--%>

    <form id="rpdform" action="/rpdsearch" method="post">
        <div class="layui-row">
            <div class="layui-col-md3">
                设备名称
            </div>
            <div class="layui-col-md9">
                <input type="text" name="device_name" value=" ">
            </div>
        </div>

        <div class="layui-row">
            <div class="layui-col-md3">
                设备号
            </div>
            <div class="layui-col-md9">
                <input type="text" name="device_number" value="0">
            </div>
        </div>
        <br/>
        <input type="submit" value="查询" title="查询" />
    </form>
        <%--<button onclick="searchform()" class="layui-btn layui-btn-primary">查询</button>--%>
</div>
