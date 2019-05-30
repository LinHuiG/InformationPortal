<%@ page import="top.fxxxx.InformationPortal.dao.Account" %><%--
  Created by IntelliJ IDEA.
  User: fyx
  Date: 2019/5/30
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    if(request.getSession(true).getAttribute("Account")==null){
%>
    <a href="login.jsp">请先登录</a>
<%
    }else{
        Account acc=(Account)request.getSession().getAttribute("Account");
%>
    <form action="ModifyServlet" method="post">
        Email:<br><input type="text" name="email" value="<%=acc.getEmail()%>">
        <br>
        Password:<br><input type="password" name="password">
        <br>
        Password(comfirm):<br><input type="password" name="check">
        <br>
        Profile:<br><textarea name="profile" style="height: 20%;width: 40%;resize: none"><%=acc.getInfo()%></textarea>
        <br>
        <input type="hidden" name="aim" value="">
        <input type="submit" value="submit" onclick="
if(password.value!==check.value){
    alert('Passwords do not match.');
    return false;
}">
    </form>
<%
    }
%>
</body>
</html>
