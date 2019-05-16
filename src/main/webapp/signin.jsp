<%--
  Created by IntelliJ IDEA.
  User: 15433
  Date: 2019/5/10
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="top.fxxxx.InformationPortal.dao.*" %>
<jsp:useBean class="top.fxxxx.InformationPortal.javabean.bean" id="bean"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="" method="post">
        <input type="text" name="id" />
        <input type="text" name="password" />
    </form>
<%
    Account ac;
    long id=Integer.parseInt(request.getParameter("id"));
    ac=Operation.getAccount(id);
    String pas=request.getParameter("password");


%>
</body>
</html>
