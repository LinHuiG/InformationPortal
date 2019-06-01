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
    String e = request.getParameter("error");
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Register</title>
</head>
<body onload="initBody()">

<jsp:include page="background.jsp">
    <jsp:param name="" value=""></jsp:param>
</jsp:include>

<table width="1002" align="center">
    <tr>
        <td width="100%" height="100%" class="enbed">
            <div style="align-content: center;width: 100%">
                <div style="width: 40%;align-content: center;margin: 50px auto">

                    <span style="color: red; ">${requestScope.message}</span>
                    <form action="RegisterServlet" method="post">
                        用户名:<br><input type="text" name="Account" value="<%=request.getParameter("Account")==null?"":request.getParameter("Account")%>"><span
                            style="color: red; ">${requestScope.error}</span>
                        <br>
                        电子邮箱:<br><input type="text" name="Email" value="<%=request.getParameter("Email")==null?"":request.getParameter("Email")%>"><span
                            style="color: red; ">${requestScope.wrongemail}</span>
                        <br>
                        密码:<br><input type="password" name="Password" value="<%=request.getParameter("Password")==null?"":request.getParameter("Password")%>">
                        <br>
                        确认密码:<br><input type="password" name="Check" value="<%=request.getParameter("Check")==null?"":request.getParameter("Check")%>">
                        <br>
                        验证码:<br><input type="text" name="CAPTCHA">
                        <img id="verify">
                        <input type="button" value="看不清? 换一张。" id="btn"><font color="red">${requestScope.verifyerror}</font>
                        <br>
                        <input type="submit" value="注册" onclick="
    if(Account.value===''){
    alert('用户名不能为空');
    return false;
}else if(Password.value===''){
    alert('密码不能为空');
    return false;
}else if(Check.value===''){
    alert('确认密码不能为空');
    return false;
}else if(CAPTCHA.value===''){
    alert('验证码不能为空');
    return false;
}else if(Password.value!==Check.value){
    alert('密码不一致');
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
                            if (<%=e!=null%>) {
                                document.getElementById("error").innerHTML =<%='\"'+e+'\"'%>;
                            }
                        }

                        function changeImg() {
                            document.getElementById("verify").src =
                                "./CaptchaServlet?time=" + new Date().getTime();
                        }
                    </script>
                </div>
            </div>
        </td>
    </tr>
</table>
</body>
</html>
