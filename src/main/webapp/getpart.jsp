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
<%
    String partof = request.getParameter("partof");
    System.out.println(partof);
    int thispage = 0;
    if (request.getParameter("thispage") != null && !request.getParameter("thispage").equals(""))
        thispage = Integer.valueOf(request.getParameter("thispage"));
    int count = Operation.getArticlePartofNum(partof);
    int lastpage=(count+14)/15-1;
    if(lastpage<0)lastpage=0;
    if(thispage<0)thispage=0;
    if(thispage>lastpage)thispage=lastpage;
    List<Article> articles = Operation.getArticlePartof(partof, thispage * 15, thispage * 15+ 15);
    for (Article article : articles) {
        String title = article.getTitle();
        String title2;
        long data = article.getMydate();
        long id = article.getId();
        if (title.length() > 20) title2 = title.substring(0, 17) + "...";
        else title2 = title;
        String DateTime =  new SimpleDateFormat("yyyy:MM:dd").format(new Date(data));
        out.print("<a href=\"getarticle.jsp?article_id="+id+"\" target=\"_blank\" title=\"" + title + "\">" + title2 + "  </a>&#160&#160 \n" + DateTime +"<BR>");




    }
%>
<div id="wp_paging_w3">
    <ul class="wp_paging clearfix">
        <li class="pages_count">
            <span class="per_page">每页&nbsp;<em class="per_count">15</em>&nbsp;记录&nbsp;</span>
            <span class="all_count">总共&nbsp;<em class="all_count"><%=count%></em>&nbsp;记录&nbsp;</span>
        </li>
        <li class="page_nav">
            <a class="first" href="getpart.jsp?partof=<%=partof%>&thispage=0" target="_self"><span>第一页</span></a>
            <a class="prev" href="getpart.jsp?partof=<%=partof%>&thispage=<%=thispage-1%>" target="_self"><span>&lt;&lt;上一页</span></a>
            <a class="next" href="getpart.jsp?partof=<%=partof%>&thispage=<%=thispage+1%>" target="_self"><span>下一页&gt;&gt;</span></a>
            <a class="last" href="getpart.jsp?partof=<%=partof%>&thispage=<%=lastpage%>" target="_self"><span>尾页</span></a>
        </li>
        <li class="page_jump">
            <span class="pages">页码&nbsp;<em class="curr_page"><%=thispage+1%></em>/<em class="all_pages"><%=lastpage+1%></em></span>
            <form action="getpart.jsp?partof=<%=partof%>">
                <span><input class="pageNum" type="text" name="thispage" id="thispage"><input type="hidden" class="currPageURL" value=""></span>
                <span><input class="pagingJump" type="submit" value="跳转"></span>
            </form>

        </li>
    </ul>
</div>
</body>
</html>
