<%@ page import="top.fxxxx.InformationPortal.dao.Operation" %>
<%@ page import="java.util.List" %>
<%@ page import="top.fxxxx.InformationPortal.dao.Article" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: 15433
  Date: 2019/5/23
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="background.jsp">
    <jsp:param name="" value=""></jsp:param>
</jsp:include>

<table width="1002" align="center">
    <tr>
        <td width="100%" height="100%" class="enbed">
            <div style="align-content: center;width: 100%">

                <%
                    int onepagenum=25;
                    String partof = request.getParameter("partof");
                    int thispage = 0;
                    if (request.getParameter("thispage") != null && !request.getParameter("thispage").equals(""))
                        thispage = Integer.valueOf(request.getParameter("thispage"));
                    int count = Operation.getArticlePartofNum(partof);
                    int lastpage = (count + onepagenum-1) / onepagenum - 1;
                    if (lastpage < 0) lastpage = 0;
                    if (thispage < 0) thispage = 0;
                    if (thispage > lastpage) thispage = lastpage;
                    List<Article> articles = Operation.getArticlePartof(partof, thispage * onepagenum, onepagenum);
                    for (Article article : articles) {
                        String title = article.getTitle();
                        long data = article.getMydate();
                        long id = article.getId();
                        String DateTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date(data));
                %>
                <div class="title03" style="width: 80%;align-content: center;margin: 0 auto">
                    <a class="articletitle" style="color: #000;" href="getarticle.jsp?article_id=<%=id%> "
                       title="<%=title%>"><%=title%>
                    </a>
                    <test class="date"><%=DateTime%>
                    </test>
                </div>
                <%

                    }
                %>
                <div>
                    <ul>
                        <li>
                            <span>每页&nbsp;<em><%=onepagenum%></em>&nbsp;记录&nbsp;</span>
                            <span>总共&nbsp;<em><%=count%></em>&nbsp;记录&nbsp;</span>
                        </li>
                        <li >
                            <a style="color: black" href="getpart.jsp?partof=<%=partof%>&thispage=0" target="_self"><span>第一页</span></a>
                            <a style="color: black" href="getpart.jsp?partof=<%=partof%>&thispage=<%=thispage-1%>" target="_self"><span>&lt;&lt;上一页</span></a>
                            <a style="color: black" href="getpart.jsp?partof=<%=partof%>&thispage=<%=thispage+1%>" target="_self"><span>下一页&gt;&gt;</span></a>
                            <a style="color: black" href="getpart.jsp?partof=<%=partof%>&thispage=<%=lastpage%>" target="_self"><span>尾页</span></a>
                        </li>
                        <li>
                            <span>页码&nbsp;<em><%=thispage + 1%></em>/<em><%=lastpage + 1%></em></span>
                            <form action="getpart.jsp">
                                <span><input type="text" name="thispage" id="thispage"><input type="hidden"
                                                                                              value=""></span>
                                <input type="hidden" name="partof" value="<%=partof%>">
                                <span><input type="submit" value="跳转"></span>
                            </form>

                        </li>
                    </ul>
                </div>
            </div>
        </td>
    </tr>
</table>
</body>
</html>
