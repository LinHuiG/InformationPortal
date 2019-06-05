<%@ page import="top.fxxxx.InformationPortal.dao.Account" %><%--
  Created by IntelliJ IDEA.
  User: fyx
  Date: 2019/5/30
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人中心</title>
</head>
<body>

<jsp:include page="background.jsp">
    <jsp:param name="" value=""></jsp:param>
</jsp:include>

<table width="1002" align="center">
    <tr>
        <td width="100%" height="100%" class="enbed">
            <div style="align-content: center;width: 100%">

                <div style="width: 40%;align-content: center;margin: 50px auto">

                    <%

                        request.setCharacterEncoding("UTF-8");
                        if (request.getSession(true).getAttribute("Account") == null) {
                    %>
                    <a style="color: black" href="login.jsp">请先登录</a>
                    <%
                    } else {
                        Account acc = (Account) request.getSession().getAttribute("Account");
                    %>
                    <form action="ModifyServlet" method="post">
                        用户名:<br><%=acc.getName()%>
                        <br>
                        电子邮箱:<br><input type="text" name="email" value="<%=acc.getEmail()%>">
                        <br>
                        密码:<br><input type="password" name="password">
                        <br>
                        确认密码:<br><input type="password" name="check">
                        <br>
                        个人信息:<br><textarea name="profile"
                                           style="height: 200px;width: 100%;resize: none"><%=acc.getInfo()%></textarea>
                        <br>
                        <input type="hidden" name="aim" value="">
                        <input type="submit" value="提交" onclick="
if(password.value!==check.value){
    alert('密码不一致');
    return false;
}">
                    </form>
                </div>
                <div style="width: 40%;align-content: center;margin: 50px auto">
                    <%
                        if (acc.getPermissions() >= 1) {
                    %>
                    <a style="color: black" href="ekeditor.jsp?gx=1">增加文章</a>
                    <%
                        }
                        if (acc.getPermissions() >= 2) {
                    %>
                    <a style="color: black" href="control.jsp">设置账户</a>
                    <%
                            }
                        }
                    %>
                </div>
            </div>
        </td>
    </tr>
</table>
</body>
</html>
