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
            reqUrl += "?" + queryString;
        }
        return reqUrl;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        String email, profile, pwd, aim, permission;
        Account acc;
        aim = request.getParameter("aim");
        Account holder = (Account) session.getAttribute("Account");
        acc = aim.equals("") ? (Account) session.getAttribute("Account") : Operation.getAccount(aim);
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        if (acc.getName().equals(holder.getName()) && !aim.equals("")) {
            out.print("<script type=\"text/javascript\"> ");
            out.println("alert('不能在此修改自己的信息');");
            out.println("location.href='manage.jsp';");
            out.print("</script>");
            return;
        }
        if (!aim.equals("") && holder.getPermissions()< 2) {
            out.print("<script type=\"text/javascript\"> ");
            out.println("alert('您没有权限');");
            out.println("location.href='manage.jsp';");
            out.print("</script>");
            return;
        }

        if (request.getParameter("sc") != null && request.getParameter("sc").equals("1")) {
            if (holder.getPermissions()>=3)
            {
                Operation.deleteAccount(acc.getName());
                request.getRequestDispatcher("./control.jsp?").forward(request, response);
            }
            else
            {
                out.print("<script type=\"text/javascript\"> ");
                out.println("alert('您没有权限删除他人账号');");
                out.println("location.href='" + (aim.equals("") ? "manage.jsp" : "control.jsp?acc=" + aim) + "';");
                out.print("</script>");

            }
            return;
        }
        email = request.getParameter("email");
        pwd = request.getParameter("password");
        profile = request.getParameter("profile");
        permission = request.getParameter("permission");

        if (pwd != null && !pwd.equals("")) acc.setPassword(pwd);
        if (email != null && !email.equals("")) {
            if (VerificationUtil.isEmail(email)) acc.setEmail(email);
            else {
                out.print("<script type=\"text/javascript\"> ");
                out.println("alert('请输入合法的邮箱地址');");
                out.println("location.href='" + (aim.equals("") ? "manage.jsp" : "control.jsp?acc=" + aim) + "';");
                out.print("</script>");
                return;
            }
        }
        if (profile != null && !profile.equals("")) acc.setInfo(profile);
        if (permission != null && !permission.equals("")) {
            if (holder.getPermissions()<3&& Integer.valueOf(permission)!=acc.getPermissions()) {
                out.print("<script type=\"text/javascript\"> ");
                out.println("alert('您不能修改他人权限');");
                out.println("location.href='" + (aim.equals("") ? "manage.jsp" : "control.jsp?acc=" + aim) + "';");
                out.print("</script>");
                return;
            }
            acc.setPermissions(Math.min(Integer.parseInt(permission),3));
        }
        Operation.updateAccount(acc);
        //     out.print("<script>alert('"+error+"'); window.location='index.jsp' </script>");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
