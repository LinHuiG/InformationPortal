<%@ page import="top.fxxxx.InformationPortal.dao.Operation" %>
<%@ page import="java.util.List" %>
<%@ page import="top.fxxxx.InformationPortal.dao.Article" %><%--
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
    <link type="text/css" href="style.css" rel="stylesheet">
</head>
<body>
<%
    String partof = request.getParameter("partof");
    int thispage = 0;
    if (request.getParameter("thispage") != null && !request.getParameter("thispage").equals(""))
        thispage = Integer.valueOf(request.getParameter("thispage"));
    int count = Operation.getArticlePartofNum(partof);
    List<Article> articles = Operation.getArticlePartof(partof, thispage * 10, thispage * 10 + 10);
    for (Article article : articles) {
        String title = article.getTitle();
        String title2;
        Long data = article.getMydate();
        if (title.length() > 20) title2 = title.substring(0, 17) + "...";
        else title2 = title;
        out.print("<tbody><tr> \n" +
                "<td align=\"left\"><a href=\"/2019/0227/c2828a187836/page.htm\" target=\"_blank\" title=\"" + title + "\">" + title2 + "</a></td> \n" +
                " \n" +
                "<td align=\"left\" width=\"30px\"><div style=\"white-space:nowrap\">02-27</div></td> \n" +
                " \n" +
                "</tr> \n" +
                "</tbody>"
        );
    }
    out.print(
            "<ul class=\"wp_paging clearfix\"> \n" +
            "     <li class=\"pages_count\"> \n" +
            "         <span class=\"per_page\">每页&nbsp;<em class=\"per_count\">14</em>&nbsp;记录&nbsp;</span> \n" +
            "         <span class=\"all_count\">总共&nbsp;<em class=\"all_count\">237</em>&nbsp;记录&nbsp;</span> \n" +
            "     </li> \n" +
            "     <li class=\"page_nav\"> \n" +
            "         <a class=\"first\" href=\"javascript:void(0);\" target=\"_self\"><span>第一页</span></a> \n" +
            "         <a class=\"prev\" href=\"javascript:void(0);\" target=\"_self\"><span>&lt;&lt;上一页</span></a> \n" +
            "         <a class=\"next\" href=\"/2830/list2.htm\" target=\"_self\"><span>下一页&gt;&gt;</span></a> \n" +
            "         <a class=\"last\" href=\"/2830/list17.htm\" target=\"_self\"><span>尾页</span></a> \n" +
            "     </li> \n" +
            "     <li class=\"page_jump\"> \n" +
            "         <span class=\"pages\">页码&nbsp;<em class=\"curr_page\">1</em>/<em class=\"all_pages\">17</em></span> \n" +
            "         <span><input class=\"pageNum\" type=\"text\"><input type=\"hidden\" class=\"currPageURL\" value=\"\"></span> \n" +
            "         <span><a class=\"pagingJump\" href=\"javascript:void(0);\" target=\"_self\">跳转到&nbsp;</a></span> \n" +
            "     </li> \n" +
            "</ul>");
%>
</body>
</html>
