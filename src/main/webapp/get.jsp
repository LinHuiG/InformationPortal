<%@ page import="java.util.Date" %>
<%@ page import="top.fxxxx.InformationPortal.dao.Account" %>
<%@ page import="com.mysql.cj.Session" %>
<%@ page import="top.fxxxx.InformationPortal.dao.Operation" %>
<%@ page import="top.fxxxx.InformationPortal.dao.Article" %><%--
  Created by IntelliJ IDEA.
  User: 15433
  Date: 2019/5/10
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Account account= (Account) session.getAttribute("Account");
    request.setCharacterEncoding("UTF-8");
    if(true)
    {

    }
    String title=request.getParameter("title1");
    String content=request.getParameter("editor1");
    long date=new Date().getTime();
    String author_name=account.getName();
    String partof=request.getParameter("partof");
    long id=date;
    Operation.insertArticle(new Article(title,author_name,content,date,partof,id));
    out.print("添加成功");
%>
</body>
</html>
