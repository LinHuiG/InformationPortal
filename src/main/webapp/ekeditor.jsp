<%@ page import="top.fxxxx.InformationPortal.dao.Account" %>
<%@ page import="java.util.Date" %>
<%@ page import="top.fxxxx.InformationPortal.dao.Operation" %>
<%@ page import="top.fxxxx.InformationPortal.dao.Article" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body style="width: 100%">

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
    if ((account.getPermissions() & 2) == 0) {
        out.print("<script type=\"text/javascript\">");
        out.println("alert('您没有权限');");
        out.print("window.location.href='login.jsp';");
        out.print("</script>");
} else {

    request.setCharacterEncoding("UTF-8");
    Article article = (Article) session.getAttribute("Article");
    String gx = request.getParameter("gx");//0更新文章 1新文章
    if (gx.equals("1")) {
        article = new Article();
    }
%>
<table width="1002" align="center">
    <tr>
        <td width="100%" height="100%" class="enbed">
            <div style="align-content: center;width: 100%">

                <div style="width: 40%;align-content: center;margin: 50px 10px">
                    <script type="text/javascript" src="ckeditor/ckeditor.js"></script>
                    <form method="post" action="addArticle">
                        <h2>标题:<input type="text" id="title1" name="title1"
                                      style="width:800px;height:35px" value="<%=article.getTitle()%>">
                        </h2>
                        <h3>模块选择:<select name="partof">
                            <option value="中心概况">中心概况</option>
                            <option value="实验教学">实验教学</option>
                            <option value="实验队伍">实验队伍</option>
                            <option value="管理模式">管理模式</option>
                            <option value="设备与环境">设备与环境</option>
                            <option value="成功展示">成功展示</option>
                        </select></h3>
                        <textarea name="editor1" id="editor1" rows="10" cols="80">
                            <%=article.getContent()%>

    </textarea>
                        <input type="hidden" name="gx" value="<%=gx%>">
                        <input type="submit" onclick="">
                        <script>
                            CKEDITOR.replace('editor1', {
                                //'kama', 'v2', 'office2003'
                                height: 600,
                                width: 950
                            });
                        </script>
                    </form>
                </div>

            </div>
        </td>
    </tr>
</table>
<%

        }
    }
%>
</body>
</html>