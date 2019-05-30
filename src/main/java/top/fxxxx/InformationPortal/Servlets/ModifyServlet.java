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

@WebServlet("/ModifyServlet")
public class ModifyServlet extends HttpServlet {
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
        if(email!=null&&!email.equals(""))acc.setEmail(email);
        if(profile!=null&&!profile.equals(""))acc.setInfo(profile);
        if(permission!=null&&!permission.equals(""))acc.setPermissions(Integer.parseInt(permission));
        Operation.updateAccount(acc);
        //     out.print("<script>alert('"+error+"'); window.location='index.jsp' </script>");
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

}
