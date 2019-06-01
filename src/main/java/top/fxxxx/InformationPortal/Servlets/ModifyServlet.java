package top.fxxxx.InformationPortal.Servlets;

import top.fxxxx.InformationPortal.Util.VerificationUtil;
import top.fxxxx.InformationPortal.dao.Account;
import top.fxxxx.InformationPortal.dao.Operation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/ModifyServlet")
public class ModifyServlet extends HttpServlet {
    public String getUrl(HttpServletRequest req) {
        String reqUrl = req.getRequestURL().toString();
        String queryString = req.getQueryString(); // d=789
        if (queryString != null) {
            reqUrl += "?"+queryString;
        }
        return reqUrl;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession(false);
        String email,profile,pwd,aim,permission;
        Account acc;
        aim=request.getParameter("aim");
        acc=aim.equals("")?(Account)session.getAttribute("Account"):Operation.getAccount(aim);
        email=request.getParameter("email");
        pwd=request.getParameter("password");
        profile=request.getParameter("profile");
        permission=request.getParameter("permission");
        if(pwd!=null&&!pwd.equals(""))acc.setPassword(pwd);
        if(email!=null&&!email.equals(""))
        {
            if( VerificationUtil.isEmail(email)) acc.setEmail(email);
            else
            {
                response.setContentType("text/html;charset=UTF-8");
                response.setCharacterEncoding("UTF-8");
                PrintWriter out = response.getWriter();
                out.print("<script type=\"text/javascript\"> ");
                out.println("alert('请输入合法的邮箱地址');");
                out.println("location.href='"+(aim.equals("")?"manage.jsp":"control.jsp?acc="+aim)+"';");
                out.print("</script>");
                return;
            }
        }
        if(profile!=null&&!profile.equals(""))acc.setInfo(profile);
        if(permission!=null&&!permission.equals(""))acc.setPermissions(Integer.parseInt(permission));
        Operation.updateAccount(acc);
        //     out.print("<script>alert('"+error+"'); window.location='index.jsp' </script>");
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

}
