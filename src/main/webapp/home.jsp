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
                    <a >首页</a>
                </td>
                <td class="title01">
                    <a>中心概况</a>
                </td>
                <td class="title01">
                    <a>中心管理</a>
                </td>
                <td class="title01">
                    <a>通讯公告</a>
                </td>
                <td class="title01">
                    <a>首页</a>
                </td>
            </tr></table></td>
        </tr>
        <tr>
            <td width="100%" height=800px>
                <jsp:include page="mainpage.jsp"/>

            </td>
        </tr>
    </table>
</body>
</html>
