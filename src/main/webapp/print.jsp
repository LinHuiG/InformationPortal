<%@ page import="top.fxxxx.InformationPortal.dao.Operation" %>
<%@ page import="top.fxxxx.InformationPortal.dao.Article" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: WZL
  Date: 2019/5/23
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table class="subblock">

    <%
        String part=request.getParameter("partname");
        System.out.println(part+"111");
    %>
    <tr>
        <td class="title02">
            <%=part%>
        </td>
    </tr>
        <%
        int num=Operation.getArticlePartofNum(part);
        num=Math.min(num,6);
        assert (num!=0);
        for (Article article:Operation.getArticlePartof(part,0,num)){
            %>
        <tr>
            <td class="articlename">
                <%=article.getTitle()%>
            </td>
        </tr>
        <%
        }
    %>
    </table>
</body>
</html>
