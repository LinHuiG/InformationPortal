package top.fxxxx.InformationPortal.Servlets;

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

@WebServlet("/addPartof")
public class addPartof extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        if (session.getAttribute("Account") == null) {
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print("<script type=\"text/javascript\"> ");
            out.println("alert('请登录');");
            out.print("window.location.href='login.jsp';");
            out.print("</script>");
            return;
        }
        Account account = (Account) session.getAttribute("Account");
        if (account.getPermissions() < 3)
        {
            response.setContentType("text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print("<script type=\"text/javascript\">");
            out.println("alert('您没有权限');");
            out.print("window.location.href='login.jsp';");
            out.print("</script>");
            return;
        }
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String rootpartof=request.getParameter("rootpartof");
        String partof=request.getParameter("newpartof");
        String sc=request.getParameter("sc");
        if (rootpartof!=null&&!rootpartof.equals(""))
        {

            if (partof!=null&&!partof.equals(""))
            {
                if(sc.equals("1"))
                {
                    Operation.deletePartof(rootpartof,partof);
                    request.getRequestDispatcher("./index.jsp").forward(request, response);
                    return;
                }
                Operation.insertPartof(rootpartof,partof);
                request.getRequestDispatcher("./index.jsp").forward(request, response);
            }
        }
    }
}
