<%@ page import="top.fxxxx.InformationPortal.dao.Account" %>
<%@ page import="top.fxxxx.InformationPortal.dao.Operation" %><%--
  Created by IntelliJ IDEA.
  User: fyx
  Date: 2019/5/30
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台管理</title>
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
                        if (acc.getPermissions() <2) {
                    %>
                    <a style="color: black" href="index.jsp">权限不足！</a>
                    <%
                    } else {
                    %>
                    <form action="control.jsp" method="get">
                        <input type="text" name="acc">
                        <input type="submit" value="三秒钟之内我要这个人的全部信息！" onclick="
    if(acc.value===''){
        alert('用户名不能为空');
    }">
                    </form>
                    <%
                        String aim = request.getParameter("acc");
                        if (aim != null) {
                            Account res = Operation.getAccount(aim);
                            if (res.getId() == -1) {
                    %>
                    查无此人
                    <%
                    } else {
                    %>
                    <form action="" method="post">
                        用户名:<br><%=res.getName()%>
                        <br>
                        电子邮箱:<br><input type="text" name="email" value="">
                        <br>
                        权限:<br><input type="number" name="permission" value="<%=res.getPermissions()%>">
                        <br>
                        个人信息:<br><textarea name="profile"
                                              style="height: 200px;width: 100%;resize: none"><%=res.getInfo()%></textarea>
                        <br>
                        <input type="hidden" name="aim" value="<%=res.getName()%>">
                        <input type="submit" value="确认修改" onclick="javascript:this.form.action='ModifyServlet?sc=0'">
                        <%
                            if (acc.getPermissions()>=3){
                        %>
                        <input type="submit" value="删除账户" onclick="javascript:this.form.action='ModifyServlet?sc=1'">
                        <%
                            }
                        %>
                    </form>
                    <%
                                    }
                                }
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
