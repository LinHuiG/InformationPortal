<%@ page import="top.fxxxx.InformationPortal.dao.Operation" %>
<%@ page import="top.fxxxx.InformationPortal.dao.Article" %>
<%@ page import="javax.xml.crypto.Data" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 15433
  Date: 2019/5/23
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        long id=Long.valueOf(request.getParameter("article_id"));
        Article article=Operation.getArticle(id);
        out.print("标题："+article.getTitle());
        out.print(article.getContent());

    %>
</body>
</html>
