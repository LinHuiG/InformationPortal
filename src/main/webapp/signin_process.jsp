<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="top.fxxxx.InformationPortal.dao.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Account ac;
    long id=Integer.parseInt(request.getParameter("id"));
    ac=Operation.getAccount(id);
    String pas=request.getParameter("password");
    if(!pas.equals(ac.getPassword())){
        session.setAttribute("state","你输入的用户名和密码不匹配");
        if(pas.equals(""))session.setAttribute("state","用户不存在");
        response.sendRedirect("signin.jsp");
    }
    else{
        session.setAttribute("account",ac);
        RequestDispatcher dispatcher=request.getRequestDispatcher("signed.jsp");
        dispatcher.forward(request,response);
    }

%>
</body>
</html>

