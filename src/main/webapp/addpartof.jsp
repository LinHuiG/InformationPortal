<%@ page import="top.fxxxx.InformationPortal.dao.Account" %><%--
  Created by IntelliJ IDEA.
  User: fyx
  Date: 2018/10/17
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>标签增加</title>
</head>
<body onload="initBody()">

<jsp:include page="background.jsp">
    <jsp:param name="" value=""></jsp:param>
</jsp:include>

<%
    if (request.getSession(true).getAttribute("Account") == null) {
%>
<a href="login.jsp">请先登录</a>
<%
    } else {

        Account account = (Account) session.getAttribute("Account");
        if (account.getPermissions() < 3) {
            out.print("<script type=\"text/javascript\">");
            out.println("alert('您没有权限增加模块');");
            out.print("window.location.href='login.jsp';");
            out.print("</script>");
            return;
        }
    }
%>
<table width="1002" align="center">
    <tr>
        <td width="100%" height="100%" class="enbed">
            <div style="align-content: center;width: 100%">
                <div style="width: 40%;align-content: center;margin: 50px auto">
                    <form action="" method="post">
                        <h3>主模块选择:
                            <select  name="rootpartof" >
                                <option value="中心概况" selected="selected">中心概况</option>
                                <option value="实验教学">实验教学</option>
                                <option value="实验队伍">实验队伍</option>
                                <option value="管理模式">管理模式</option>
                                <option value="设备与环境">设备与环境</option>
                                <option value="成果展示">成果展示</option>
                            </select>
                            <input type="text" name="newpartof">
                            <input type="submit" value="增加模块" onclick="javascript:this.form.action='addPartof?sc=0';" >
                            <input type="submit" value="删除模块" onclick="javascript:this.form.action='addPartof?sc=1';" >
                        </h3>
                    </form>
                </div>
            </div>
        </td>
    </tr>
</table>
</body>
</html>