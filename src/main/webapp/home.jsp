<%--
  Created by IntelliJ IDEA.
  User: WZL
  Date: 2019/5/23
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="home.css">
</head>
<body>

    <table width="1002" align="center">
        <tr >
            <td width="100%" align="center">
                <img align="center" src="http://hhic.hhu.edu.cn/_upload/tpl/00/a3/163/template163/images/hhic-banner1.jpg">
            </td>
        </tr>
        <tr>
            <td><table width="100%"><tr>
                <td class="title01">
                    <a href="home.jsp?partof=首页">首页</a>
                </td>
                <td class="title01">
                    <a href="home.jsp?partof=中心概况">中心概况</a>
                </td>
                <td class="title01">
                    <a href="home.jsp?partof=实验教学">实验教学</a>
                </td>
                <td class="title01">
                    <a href="home.jsp?partof=实验队伍">实验队伍</a>
                </td>
                <td class="title01">
                    <a href="home.jsp?partof=管理模式">管理模式</a>
                </td>
                <td class="title01">
                    <a href="home.jsp?partof=设备与环境">设备与环境</a>
                </td>
                <td class="title01">
                    <a href="home.jsp?partof=成果展示">成功展示</a>
                </td>
            </tr></table></td>
        </tr>
        <tr>
            <td width="100%" height=800px>
                <%
                    request.setCharacterEncoding("UTF-8");
                    if(request.getParameter("partof")==null||"首页".equals(request.getParameter("partof"))){
                %>
                <jsp:include page="mainpage.jsp"/>
                <%
                }
                else {
                    request.setCharacterEncoding("UTF-8");
                    String part = request.getParameter("partof");
                    System.out.println(part);
                %>
                <jsp:include page="getpart.jsp">
                    <jsp:param name="partof" value="<%=part%>"/>
                    <jsp:param name="thispage" value="0"/>
                </jsp:include>
                <% }%>
            </td>
        </tr>
    </table>
</body>
</html>
