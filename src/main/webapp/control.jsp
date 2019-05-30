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
<%
    request.setCharacterEncoding("UTF-8");
    if(request.getSession(true).getAttribute("Account")==null){
%>
<a href="login.jsp">请先登录</a>
<%
    }else{
        Account acc=(Account)request.getSession().getAttribute("Account");
        if((acc.getPermissions()&1L)==0){
%>
<a href="index.jsp">权限不足！</a>
<%
        }else{
%>
<form action="control.jsp" method="get">
    <input type="text" name="acc">
    <input type="submit" value="三秒钟之内我要这个人的全部信息！" onclick="
    if(acc.value===''){
        alert('empty account.');
    }">
</form>
<%
            String aim=request.getParameter("acc");
            if(aim!=null){
                Account res= Operation.getAccount(aim);
                if(res.getId()==-1){
%>
查无此人
<%
                }else{
%>
<form action="ModifyServlet" method="post">
    Account:<br><%=res.getName()%>
    <br>
    Email:<br><input type="text" name="email" value="">
    <br>
    Permission:<br><input type="number" name="permission" value="<%=res.getPermissions()%>">
    <br>
    Profile:<br><textarea name="profile" style="height: 20%;width: 40%;resize: none"><%=res.getInfo()%></textarea>
    <br>
    <input type="hidden" name="aim" value="<%=res.getName()%>">
    <input type="submit" value="submit">
</form>
<%
                }
            }
        }
    }
%>

</body>
</html>
