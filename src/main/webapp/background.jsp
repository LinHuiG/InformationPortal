<%@ page import="top.fxxxx.InformationPortal.dao.Account" %>
<%@ page import="java.util.List" %>
<%@ page import="top.fxxxx.InformationPortal.dao.Operation" %><%--
  Created by IntelliJ IDEA.
  User: WZL
  Date: 2019/6/1
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>河海大学实验中心门户</title>
    <link rel="stylesheet" type="text/css" href="js/home.css">
    <style>
        table{
            background-color: rgba(247,251,255,.8);
        }
    </style>
</head>
<body style="background-image: url(Image/bg.jpg) ; background-repeat: repeat-x; ">
<script src="js/jquery-3.1.1.js"></script>
<script src="js/ajax1.js"></script>
<table style="background: url(Image/head.jpg) no-repeat; height: 125px" width="1002"  align="center" >

    <tr>
        <td width="100%" align="center">
            <div style="height: 115px ;width: 100%">

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
                        <a style="color: whitesmoke" href="index.jsp">首页</a>
                    </td>
                    <td class="title01">
                        <a style="color: whitesmoke" href="getrootpart.jsp?rootpartof=中心概况">中心概况</a>

                    </td>
                    <td class="title01">
                        <a style="color: whitesmoke" href="getrootpart.jsp?rootpartof=实验教学">实验教学</a>
                    </td>
                    <td class="title01">
                        <a style="color: whitesmoke" href="getrootpart.jsp?rootpartof=实验队伍">实验队伍</a>
                    </td>
                    <td class="title01">
                        <a style="color: whitesmoke" href="getrootpart.jsp?rootpartof=管理模式">管理模式</a>
                    </td>
                    <td class="title01">
                        <a style="color: whitesmoke" href="getrootpart.jsp?rootpartof=设备与环境">设备与环境</a>
                    </td>
                    <td class="title01">
                        <a style="color: whitesmoke" href="getrootpart.jsp?rootpartof=成果展示">成果展示</a>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</body>
</html>

