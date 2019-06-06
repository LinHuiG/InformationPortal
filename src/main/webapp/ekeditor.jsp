<%@ page import="top.fxxxx.InformationPortal.dao.Account" %>
<%@ page import="java.util.Date" %>
<%@ page import="top.fxxxx.InformationPortal.dao.Operation" %>
<%@ page import="top.fxxxx.InformationPortal.dao.Article" %>
<%@ page import="java.util.List" %>
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
    if (account.getPermissions() < 1) {
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
                    <form method="post" action="">
                        <h2>标题:<input type="text" id="title1" name="title1"
                                      style="width:800px;height:35px" value="<%=article.getTitle()%>">
                        </h2>
                        <h3>模块选择:<select id="first" name="rootpartof" onChange="change()">
                            <option value="中心概况" selected="selected">中心概况</option>
                            <option value="实验教学">实验教学</option>
                            <option value="实验队伍">实验队伍</option>
                            <option value="管理模式">管理模式</option>
                            <option value="设备与环境">设备与环境</option>
                            <option value="成果展示">成果展示</option>
                        </select>
                            <select id="second" name="partof">
                                <option value="中心概况" selected="selected">中心概况</option>
                                <%
                                    List<String> ans=Operation.getPartof("中心概况");
                                    for( String str:ans)
                                    {
                                %>
                                <option value="<%=str%>" ><%=str%></option>
                                <%
                                    }
                                %>
                            </select>
                        </h3>
                        <script>
                            var rootpartof = ["中心概况", "实验教学", "实验队伍", "管理模式", "设备与环境", "成果展示"];
                            var t = [];
                            function change() {
                                var x = document.getElementById("first");
                                var y = document.getElementById("second");
                                y.options.length = 0; // 清除second下拉框的所有内容


                                if (x.selectedIndex == 0) {
                                    y.options.add(new Option("中心概况", "中心概况", false, true));
                                }

                                if (x.selectedIndex == 1) {
                                    y.options.add(new Option("实验教学", "实验教学", false, true));
                                    //y.options.add(new Option("课程列表", "课程列表"));
                                    //y.options.add(new Option("教学模式", "教学模式"));
                                }
                                if (x.selectedIndex == 2) {
                                    y.options.add(new Option("实验队伍", "实验队伍", false, true));
                                    //y.options.add(new Option("队伍建设情况", "队伍建设情况"));
                                }
                                if (x.selectedIndex == 3) {
                                    y.options.add(new Option("管理模式", "管理模式", false, true));
                                    //y.options.add(new Option("相关管理制度", "相关管理制度"));
                                }
                                if (x.selectedIndex == 4) {
                                    y.options.add(new Option("设备与环境", "设备与环境", false, true));
                                    //y.options.add(new Option("实验室介绍及环境照片等", "实验室介绍及环境照片等"));
                                }
                                if (x.selectedIndex == 5) {
                                    y.options.add(new Option("成果展示", "成果展示", false, true));
                                    //y.options.add(new Option("学生创新竞赛等", "学生创新竞赛等"));
                                }
                                <%
                                String[] rootpartof =  {"中心概况","实验教学","实验队伍","管理模式","设备与环境","成果展示"};
                                for (int i=0;i<6;i++)
                                {
                                    ans=Operation.getPartof(rootpartof[i]);
                                    for( String str:ans)
                                    {
                                %>
                                if (x.selectedIndex == <%=i%>) {
                                    y.options.add(new Option("<%=str%>", "<%=str%>"));
                                }
                                <%
                                    }
                                }
                                %>
                            }


                        </script>
                        <textarea name="editor1" id="editor1" rows="10" cols="80">
                            <%=article.getContent()%>

    </textarea>
                        <input type="hidden" name="gx" value="<%=gx%>">

                        <input type="submit" onclick="javascript:this.form.action='addArticle?sc=0';" value="增加文章">
                        <%
                            if (gx.equals("0")) {
                        %>
                        <input type="submit" onclick="javascript:this.form.action='addArticle?sc=1';" value="删除文章">
                        <%
                            }
                        %>
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