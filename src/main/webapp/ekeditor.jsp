<%@ page import="top.fxxxx.InformationPortal.dao.Account" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body style="width: 100%">
<div style="">
    <%
        request.setCharacterEncoding("UTF-8");
        if (request.getSession(true).getAttribute("Account") == null) {
    %>
    <a href="login.jsp">请先登录</a>
    <%
    } else {
        Account acc = (Account) request.getSession().getAttribute("Account");
        if ((acc.getPermissions() & 2L) == 0) {
    %>
    <a href="index.jsp">权限不足！</a>
    <%
    } else {
    %>
    <script type="text/javascript" src="ckeditor/ckeditor.js"></script>
    <form method="post" action="get.jsp">
        <h2>标题:<input type="text" id="title1" name="title1" style="width:800px;height:35px"></h2>
        <h3>模块选择:<select name="partof">
            <option value="中心概况">中心概况</option>
            <option value="实验教学">实验教学</option>
            <option value="实验队伍">实验队伍</option>
            <option value="管理模式">管理模式</option>
            <option value="设备与环境">设备与环境</option>
            <option value="成功展示">成功展示</option>
        </select></h3>
        <textarea name="editor1" id="editor1" rows="10" cols="80">

    </textarea>
        <input type="submit" onclick="">
        <script>
            CKEDITOR.replace('editor1', {
                //'kama', 'v2', 'office2003'
                height: 600,
                width: 1000
            });
        </script>
    </form>
</div>
<%
        }
    }
%>
</body>
</html>