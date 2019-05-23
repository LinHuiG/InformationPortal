<%--
  Created by IntelliJ IDEA.
  User: WZL
  Date: 2019/5/16
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="top.fxxxx.InformationPortal.dao.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String password=request.getParameter("password");
    String name=request.getParameter("name");
    long id=Long.parseLong(request.getParameter("id"));
    if(name.equals(""))name=String.valueOf(id);
    String email=request.getParameter("email");
    String password2=request.getParameter("password2");
    Account ac;
    boolean success=true;
    if(password.contains(" "))
    {
        session.setAttribute("state","密码不能含有空格");
        success=false;
    }
    else if(password.length()<6){
        session.setAttribute("state","<br>密码太短");
        success=false;
    }
    else if(!password.equals(password2)){
        session.setAttribute("state","<br>两次输入密码不同");
        success=false;
    }
    else {
        ac=Operation.getAccount(id);
        if(!ac.getPassword().equals("")){
            session.setAttribute("state","用户名已存在");
            success=false;
        }
        else {
            ac=new Account("",id,password,0,email);
            Operation.insertAccount(ac);
            response.sendRedirect("index.jsp");
        }
    }
    if (!success)response.sendRedirect("register.jsp");
%>
</body>
</html>