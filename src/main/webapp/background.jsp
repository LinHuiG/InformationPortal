<%@ page import="top.fxxxx.InformationPortal.dao.Account" %><%--
  Created by IntelliJ IDEA.
  User: 15433
  Date: 2019/6/1
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="js/home.css">
</head>
<body>
<script src="js/jquery-3.1.1.js"></script>
<script src="js/ajax1.js"></script>
<table width="1002" align="center">
    <tr>
        <td width="100%" align="center">
            <div style="background: url(Image/pic_01.png) no-repeat ;height: 92px ;width: 100%">

                <div style="float: right;color: black">

                    <%

                        request.setCharacterEncoding("UTF-8");
                        if (request.getSession(true).getAttribute("Account") == null) {
                    %>
                    <a style="color: black" href="login.jsp">登录</a>
                    <a style="color: black" href="register.jsp">注册</a>
                    <%
                    } else {
                        Account acc = (Account) request.getSession().getAttribute("Account");
                    %>
                    <a style="color: black" href="manage.jsp"  > <%=acc.getName()%></a>
                    <a style="color: black" href="" onclick="logout()">注销</a>
                    <%
                        }
                    %>

                </div>
            </div>
        </td>
    </tr>
    <tr>
        <td>
            <table width="100%">
                <tr>
                    <td class="title01">
                        <a href="index.jsp">首页</a>
                    </td>
                    <td class="title01">
                        <a href="getpart.jsp?partof=中心概况">中心概况</a>
                    </td>
                    <td class="title01">
                        <a href="getpart.jsp?partof=实验教学">实验教学</a>
                    </td>
                    <td class="title01">
                        <a href="getpart.jsp?partof=实验队伍">实验队伍</a>
                    </td>
                    <td class="title01">
                        <a href="getpart.jsp?partof=管理模式">管理模式</a>
                    </td>
                    <td class="title01">
                        <a href="getpart.jsp?partof=设备与环境">设备与环境</a>
                    </td>
                    <td class="title01">
                        <a href="getpart.jsp?partof=成果展示">成果展示</a>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>

