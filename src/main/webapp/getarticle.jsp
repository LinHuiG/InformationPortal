<%@ page import="top.fxxxx.InformationPortal.dao.Operation" %>
<%@ page import="top.fxxxx.InformationPortal.dao.Article" %>
<%@ page import="javax.xml.crypto.Data" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
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
    <style>

        #mtitle {
            align-content: center;
            height: 60px;
            width: 100%;
            border-bottom-color: #3b3b1f ;
            border-bottom-width:2px ;
            border-bottom-style:double ;
        }

        #mtitle2 {
            margin: 30px auto;
            text-align: center;
        }

        #mtitle3 {
            font-family: 微软雅黑;
            font-size: larger;
        }
    </style>
</head>
<body>
<%
    long id = Long.valueOf(request.getParameter("article_id"));
    Article article = Operation.getArticle(id);
    String DateTime=new SimpleDateFormat("yyyy-MM-dd").format(new Date(article.getMydate()));
%>
<div id="mtitle">

    <div id="mtitle2">
        <text id="mtitle3"><%=article.getTitle()%>
        </text>
    </div>
    <div style="border-width:20px ;margin-top: 50px">
        <div class="title03" style="width: 80%;align-content: center;margin: 0 auto">
            <spen class="articletitle" style="color: #000;" ><%="发布人: "+article.getAuthor()%></spen>
            <test class="date"><%=DateTime%></test>
        </div>
    </div>
    <div style="margin: 50px">
        <%=article.getContent()%>
    </div>
</div>
</body>
</html>
