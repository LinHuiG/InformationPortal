<%@ page import="top.fxxxx.InformationPortal.dao.Operation" %>
<%@ page import="top.fxxxx.InformationPortal.dao.Article" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
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
        String rootpart=request.getParameter("partname");
    %>
    <tr>
        <td class="title02">
            <a style="color: black" href="getrootpart.jsp?rootpartof=<%=rootpart%>"><%=rootpart%></a>
        </td>
    </tr>
        <%
        int num=Operation.getArticleRootpartofNum(rootpart);
        num=Math.min(num,6);
        assert (num!=0);
        for (Article article:Operation.getArticleRootpartof(rootpart,0,num)){
            String titlecut=article.getTitle();
            if(titlecut.length()>20)
            {
                titlecut=titlecut.substring(0,18)+"...";
            }
            %>
        <tr>
            <td class="title03">
                <text class="articletitle" ><a href="getarticle.jsp?article_id=<%=article.getId()%>" style="color: #000;"><%=titlecut%></a></text>
                <text class="date"><%=new SimpleDateFormat("yyyy-MM-dd").format(new Date(article.getMydate()))%></text>
            </td>
        </tr>
        <%
        }
        while (num<6){
        %>
        <tr>
            <td class="title03">
                <br>
            </td>
        </tr>
        <%
            num++;
        }
    %>
    </table>
</body>
</html>
