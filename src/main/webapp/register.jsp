<%--
  Created by IntelliJ IDEA.
  User: WZL
  Date: 2019/5/16
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="top.fxxxx.InformationPortal.dao.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <br><%=session.getAttribute("state")%>
    <form action="register_process.jsp" method="post">
        <br>用户名
        <br><input type="text" name="id">
        <br>昵称
        <br><input type="text" name="name">
        <br>绑定邮箱
        <br><input type="text" name="email">
        <br>密码
        <br><input type="password" name="password">
        <br>确认密码
        <br><input type="password" name="password2">
        <br><input type="submit" value="确认" >
    </form>
</body>
</html>
