package top.fxxxx.InformationPortal.Servlets;

import top.fxxxx.InformationPortal.dao.Account;
import top.fxxxx.InformationPortal.dao.Article;
import top.fxxxx.InformationPortal.dao.Operation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/addArticle")
public class addArticle  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session=request.getSession(true);
        if(session.getAttribute("Account") == null)return;
        Account account=(Account) session.getAttribute("Account");
        if((account.getPermissions() & 2) == 0)return;
        Article article=(Article)session.getAttribute("Article");
        String gx=request.getParameter("gx");//0更新文章 1新文章
        String title=request.getParameter("title1");
        String partof=request.getParameter("partof");
        String content=request.getParameter("editor1");

        long date=new Date().getTime();
        if(gx.equals("1"))
        {
            article=new Article(title,account.getName(),content,date,partof,date);
            Operation.insertArticle(article);

        }
        else
        {

            article.setTitle(title);
            article.setPartof(partof);
            article.setContent(content);
            date=article.getMydate();
            if (request.getParameter("sc")!=null&&request.getParameter("sc").equals("1")) Operation.deleteArticle(article.getId());
            else Operation.updateArticle(article);
        }
        request.getRequestDispatcher("./getarticle.jsp?article_id="+date).forward(request,response);
    }
}
