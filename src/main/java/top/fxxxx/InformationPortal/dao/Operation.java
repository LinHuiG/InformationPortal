package top.fxxxx.InformationPortal.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Operation {


    public static int insertAccount(Account account) {
        Connection conn = DataInformation.getConn();
        int i = 0;
        String sql = "insert into account (name,id,password,permissions,email,info,status) values(?,?,?,?,?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, account.getName());
            pstmt.setLong(2, account.getId() );
            pstmt.setString(3, account.getPassword());
            pstmt.setLong(4, account.getPermissions() );
            pstmt.setString(5, account.getEmail());
            pstmt.setString(6, account.getInfo());
            pstmt.setString(7, account.getStatus());
            i = pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public static int insertArticle(Article article) {
        Connection conn = DataInformation.getConn();
        int i = 0;
        String sql = "insert into article (title,author,content,mydate,partof,id) values(?,?,?,?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, article.getTitle());
            pstmt.setLong(2, article.getAuthor() );
            pstmt.setString(3, article.getContent());
            pstmt.setLong(4, article.getMydate() );
            pstmt.setString(5, article.getPartof());
            pstmt.setLong(6, article.getId() );
            i = pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public static int updateAccount(Account account) {
        Connection conn = DataInformation.getConn();
        int i = 0;
        String sql = "update account set name = ? , password = ?,permissions = ?,email = ? ,info = ? ,status = ? where name= ? ";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, account.getName());
            pstmt.setString(2, account.getPassword());
            pstmt.setLong(3, account.getPermissions() );
            pstmt.setString(4, account.getEmail());
            pstmt.setString(5, account.getInfo());
            pstmt.setString(6, account.getStatus());
            pstmt.setString(7, account.getName() );
            i = pstmt.executeUpdate();
            System.out.println("resutl: " + i);
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public static int updateArticle(Article article) {
        Connection conn = DataInformation.getConn();
        int i = 0;
        String sql = "update article set title = ?,author = ?,content = ?,mydate = ?,partof = ? where id= ? ";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, article.getTitle());
            pstmt.setLong(2, article.getAuthor() );
            pstmt.setString(3, article.getContent());
            pstmt.setLong(4, article.getMydate() );
            pstmt.setString(5, article.getPartof());
            pstmt.setLong(6, article.getId());
            i = pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public static Account getAccount(String name) {
        Connection conn = DataInformation.getConn();
        String sql = "select * from account where name = ?";
        PreparedStatement pstmt;
        long id = -1;
        String password = "";
        int permissions = 0;
        String email = "";
        String info = "";
        String status = "";
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                id = rs.getLong("id");
                password = rs.getString("password");
                permissions = Integer.valueOf(rs.getString("permissions"));
                email = rs.getString("email");
                info = rs.getString("info");
                status = rs.getString("status");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Account ans = new Account(name, id, password, permissions, email, info, status);
        return ans;
    }

    public static Article getArticle(long id) {
        Connection conn = DataInformation.getConn();
        String sql = "select * from article where id = ?";
        PreparedStatement pstmt;
        String title = "";
        long author = 0;
        String content = "";
        long mydate = 0;
        String partof = "";
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setLong(1, id );
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                title = rs.getString("title");
                author = rs.getLong("author");
                mydate = rs.getLong("mydate");
                content = rs.getString("content");
                partof = rs.getString("partof");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Article ans = new Article(title, author, content, mydate, partof, id);
        return ans;
    }

    public static int deleteAccount(String name) {
        Connection conn = DataInformation.getConn();
        int i = 0;
        String sql = "delete from account where name= ?";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, name);
            i = pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public static int deleteArticle(long id) {
        Connection conn = DataInformation.getConn();
        int i = 0;
        String sql = "delete from article where id=?";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setLong(1, id);
            i = pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public static List<Article> getArticlePartof(String partof) {
        List<Article> ans = new ArrayList<>();
        Connection conn = DataInformation.getConn();
        String sql = "select * from article where partof = ? order by mydate desc limit 6";
        PreparedStatement pstmt;
        String title = "";
        long author = 0;
        long mydate = 0;
        long id = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, partof);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                title = rs.getString("title");
                author = rs.getLong("author");
                mydate = rs.getLong("mydate");
                partof = rs.getString("partof");
                ans.add(new Article(title, author, "", mydate, partof, id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ans;
    }

    public static List<Article> getArticlePartof(String partof, int begin, int limit) {
        int num=getArticlePartofNum(partof);
        if(begin+limit>num)limit=num-begin;
        List<Article> ans = new ArrayList<>();
        Connection conn = DataInformation.getConn();
        String sql = "select * from article where partof = ? order by mydate desc limit ?,?";
        PreparedStatement pstmt;
        String title = "";
        long author = 0;
        long mydate = 0;
        long id = 0;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, partof);
            pstmt.setInt(2, begin );
            pstmt.setInt(3, limit );
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                title = rs.getString("title");
                author = rs.getLong("author");
                mydate = rs.getLong("mydate");
                partof = rs.getString("partof");
                id = rs.getLong("id");
                ans.add(new Article(title, author, "", mydate, partof, id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ans;
    }

    public static int getArticlePartofNum(String partof) {
        int ans = 0;
        Connection conn = DataInformation.getConn();
        String sql = "select count(*) from article where partof = ?";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, partof);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            ans = rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ans;
    }

    public static void main(String[] args) {
/*
        getAll();
        System.out.println("111");
        insert(new Student("Achilles男", "Male", "14"));
        getAll();
        System.out.println("111");
        insert(new Student("Bean", "", "7"));
        update(new Student("Bean", "", "8"));
        delete("Achilles");
        getAll();
        System.out.println("111");

*/
    }
}
