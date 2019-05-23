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

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException { }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession(false);
        PrintWriter out=response.getWriter();
        String account,email,pwd,captcha,check,error=null;
        account=request.getParameter("Account");
        email=request.getParameter("Email");
        pwd=request.getParameter("Password");
        captcha=request.getParameter("CAPTCHA");
        check=session==null?null:(String)session.getAttribute("CheckCode");
        synchronized (this) {
            if (hasNull(account, pwd, captcha, check)){
                request.setAttribute("message","Incomplete parameters!");
            } else if (!captcha.equalsIgnoreCase(check)){
                request.setAttribute("verifyerror","Incorrect CAPTCHA!");
            } else {
                try {
                    if (addUser(account,email,pwd)){
                        //注册成功
                        success(request,response);
                        return;
                    }else request.setAttribute("error","The account is already taken.");
                } catch (Exception e) {
                    e.printStackTrace();
                    request.setAttribute("message","Database error.");
                }
            }
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
    }
    //检查是否有null
    private boolean hasNull(String... strs){
        for(String s:strs)if(s==null)return true;
        return false;
    }
    private void success(HttpServletRequest request, HttpServletResponse response){
        try {
            request.getRequestDispatcher("./index.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
    private boolean addUser(String acc,String email,String pwd){
        Account ac=new Account(acc,System.currentTimeMillis(),pwd,0,email);
        int res=Operation.insertAccount(ac);
        System.out.println(res);
        return res==1;
    }
}