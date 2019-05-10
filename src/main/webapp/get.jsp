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
    String s=request.getParameter("editor1");
    s=new String(s.getBytes("iso-8859-1"),"utf-8");
    System.out.println(s+"1231");
    out.print(s.length()+"\n"+s);
%>
</body>
</html>
