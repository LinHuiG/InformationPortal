<%--
  Created by IntelliJ IDEA.
  User: WZL
  Date: 2019/5/23
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="home.css">
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
%>
    <table class="main"  width="100%" height="100%">
        <tr>
            <td class="huafeng">
                <jsp:include page="print.jsp">
                    <jsp:param name="partname" value="成果展示"/>
                </jsp:include>
            </td>
            <td class="huafeng">
                <jsp:include page="print.jsp">
                    <jsp:param name="partname" value="中心概况"/>
                </jsp:include>
            </td>
        </tr>
        <tr>
            <td class="huafeng">
                <jsp:include page="print.jsp">
                    <jsp:param name="partname" value="实验教学"/>
                </jsp:include>
            </td>
            <td class="huafeng">
                <jsp:include page="print.jsp">
                    <jsp:param name="partname" value="实验队伍"/>
                </jsp:include>
            </td>
        </tr>
        <tr>
            <td class="huafeng">
                <jsp:include page="print.jsp">
                    <jsp:param name="partname" value="管理模式"/>
                </jsp:include>
            </td>
            <td class="huafeng">
                <jsp:include page="print.jsp">
                    <jsp:param name="partname" value="设备与环境"/>
                </jsp:include>
            </td>
        </tr>
    </table>
</body>
</html>
