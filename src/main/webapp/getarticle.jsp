<%@ page import="top.fxxxx.InformationPortal.dao.Operation" %>
<%@ page import="top.fxxxx.InformationPortal.dao.Article" %>
<%@ page import="javax.xml.crypto.Data" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="top.fxxxx.InformationPortal.dao.Account" %><%--
  Created by IntelliJ IDEA.
  User: WZL
  Date: 2019/5/23
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    long id = Long.valueOf(request.getParameter("article_id"));
    Article article = Operation.getArticle(id);
    String DateTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date(article.getMydate()));
    session.setAttribute("Article",article);
%>
<html>
<head>
    <title><%=article.getTitle()%></title>
    <style>

        #mtitle {
            align-content: center;
            height: 60px;
            width: 100%;
            border-bottom-color: #3b3b1f;
            border-bottom-width: 2px;
            border-bottom-style: double;
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

<jsp:include page="background.jsp">
    <jsp:param name="" value=""></jsp:param>
</jsp:include>

<table width="1002" align="center">
    <tr>
        <td width="100%" height="100%" class="enbed">
            <div id="mtitle">

                <div id="mtitle2">
                    <text id="mtitle3">
                        <%
                            Account acc=null;
                            if(session.getAttribute("Account")!=null)
                                acc=(Account) session.getAttribute("Account");
                            if (acc!=null&&(acc.getPermissions()>= 1))
                            {
                        %>
                        <a style="color: black" id="mtitle3" href="ekeditor.jsp?gx=0"><%=article.getTitle()%></a>
                        <%
                            }
                            else out.print(article.getTitle());
                        %>
                    </text>
                </div>
                <div style="border-width:20px ;margin-top: 50px">
                    <div class="title03" style="width: 80%;align-content: center;margin: 0 auto">
                        <spen class="articletitle" style="color: #000;"><%="发布人: " + article.getAuthor()%>
                        </spen>
                        <test class="date"><%=DateTime%>
                        </test>

                    </div>
                </div>
                <div style="margin: 0px">
                    <%=article.getContent()%>
                </div>
                <div style="height: 100px;margin: 10px" ></div>
            </div>
        </td>
    </tr>
</table>

</body>
</html>
