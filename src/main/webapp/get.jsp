<%--
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
    String title=request.getParameter("title1");
    title=new String(title.getBytes("iso-8859-1"),"utf-8");
    String content=request.getParameter("editor1");
    content=new String(content.getBytes("iso-8859-1"),"utf-8");
    System.out.println(title +content+"1231");
    out.print(title+content.length()+"\n"+content);
%>
</body>
</html>
