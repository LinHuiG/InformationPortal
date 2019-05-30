<%--
  Created by IntelliJ IDEA.
  User: fyx
  Date: 2018/10/21
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String e=request.getParameter("error");
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Register</title>
</head>
<body onload="initBody()">
<span style="color: red; ">${requestScope.message}</span>
<form action="./RegisterServlet" method="post">
    Account:<br><input type="text" name="Account" value=""><span
        style="color: red; ">${requestScope.error}</span>
    <br>
    Email:<br><input type="text" name="Email" value="">
    <br>
    Password:<br><input type="password" name="Password">
    <br>
    Password(comfirm):<br><input type="password" name="Check">
    <br>
    CAPTCHA:<br><input type="text" name="CAPTCHA">
    <img id="verify">
    <input type="button" value="看不清? 换一张。" id="btn"><font color="red">${requestScope.verifyerror}</font>
    <br>
    <input type="submit" value="Register" onclick="
    if(Account.value===''){
    alert('Account shouldn\'t be empty.');
    return false;
}else if(Password.value===''){
    alert('Password shouldn\'t be empty.');
    return false;
}else if(Check.value===''){
    alert('Password(comfirm) shouldn\'t be empty.');
    return false;
}else if(CAPTCHA.value===''){
    alert('CAPTCHA shouldn\'t be empty.');
    return false;
}else if(Password.value!==Check.value){
    alert('Passwords do not match.');
    return false;
}">
</form>
<strong><span style="color: #990000; " id="error"></span></strong><br>
<script type="text/javascript">

    document.getElementById("btn").onclick = function () {
        // 获取img元素
        // 为了让浏览器发送请求到servlet, 所以一定要改变src
        changeImg();
    };
    function initBody() {
        changeImg();
        if(<%=e!=null%>){
            document.getElementById("error").innerHTML=<%='\"'+e+'\"'%>;
        }
    }
    function changeImg() {
        document.getElementById("verify").src =
            "./CaptchaServlet?time=" + new Date().getTime();
    }
</script>
</body>
</html>
