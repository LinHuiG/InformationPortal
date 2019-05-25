<%--
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
    <title>Login</title>
</head>
<body  onload="initBody()">
<%
    // 获取浏览器发送过来的cookie, 获取用户信息
    Cookie[] cookies = request.getCookies();
    String username = "";
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("username".equals(cookie.getName())) {
                username = cookie.getValue();
            }
        }
    }
%>
<span style="color: red; ">${requestScope.message}</span>
<form action="LoginServlet" method="post">
    Account:<input type="text" name="Account" value="<%= username%>"><span
        style="color: red; ">${requestScope.error}</span>
    <br>
    Password:<input type="password" name="Password">
    <br>
    CAPTCHA:<input type="text" name="CAPTCHA">
    <img id="verify">
    <input type="button" value="看不清? 换一张。" id="btn"><font color="red">${requestScope.verifyerror}</font>
    <br>
    <input type="submit" value="Login" onclick="
    if(Account.value===''){
    alert('Account shouldn\'t be empty.');
    return false;
}else if(Password.value===''){
    alert('Password shouldn\'t be empty.');
    return false;
}else if(CAPTCHA.value===''){
    alert('CAPTCHA shouldn\'t be empty.');
    return false;
}">
</form>
<input type = "button" value = "Register" onclick = "window.location.href = './register.jsp'">
<br>
<script type="text/javascript">

    document.getElementById("btn").onclick = function () {
        // 获取img元素
        // 为了让浏览器发送请求到servlet, 所以一定要改变src
        changeImg();
    };
    function initBody() {
        changeImg();
    }
    function changeImg() {
        document.getElementById("verify").src =
            "./CaptchaServlet?time=" + new Date().getTime();
    }
</script>
</body>
</html>