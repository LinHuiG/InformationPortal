package top.fxxxx.InformationPortal.Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Print  extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){

    }
    public void doGet(HttpServletRequest request,HttpServletResponse response){
        doPost(request,response);
    }
}
