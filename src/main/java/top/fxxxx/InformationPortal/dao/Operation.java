package top.fxxxx.InformationPortal.dao;

import java.sql.*;

public class Operation {
    private static Connection getConn() {

    Connection conn = null;
    try {
        Class.forName(DataInformation.driver); //classLoader,加载对应驱动
        conn = (Connection) DriverManager.getConnection(DataInformation.url, DataInformation.username, DataInformation.password);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return conn;
}
    private static int insertAccount(Account account) {
        Connection conn = getConn();
        int i = 0;
        String sql = "insert into account (name,id,password,permissions,email,info,status) values(?,?,?,?,?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, account.getName());
            pstmt.setString(2, account.getId()+"");
            pstmt.setString(3, account.getPassword());
            pstmt.setString(4,account.getPermissions()+"");
            pstmt.setString(5,account.getEmail());
            pstmt.setString(6,account.getInfo());
            pstmt.setString(7,account.getStatus());
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    private static int insertArticle(Article article) {
        Connection conn = getConn();
        int i = 0;
        String sql = "insert into article (title,author,content,id,) values(?,?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, article.getTitle());
            pstmt.setString(2, article.getAuthor()+"");
            pstmt.setString(3, article.getContent());
            pstmt.setString(4,article.getId()+"");
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }


    private static int updateAccount(Account account) {
        Connection conn = getConn();
        int i = 0;
        String sql = "update account set name = ? , password = ?,permissions = ?,email = ? ,info = ? ,status = ? where id= ? ";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, account.getName());
            pstmt.setString(2, account.getPassword());
            pstmt.setString(3,account.getPermissions()+"");
            pstmt.setString(4,account.getEmail());
            pstmt.setString(5,account.getInfo());
            pstmt.setString(6,account.getStatus());
            pstmt.setString(7,account.getId()+"");
            i = pstmt.executeUpdate();
            System.out.println("resutl: " + i);
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    private static int updateArticle(Article article) {
        Connection conn = getConn();
        int i = 0;
        String sql = "update article set title = ?,author = ?,content = ? where id= ? ";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, article.getTitle());

            pstmt.setString(2, article.getAuthor()+"");
            pstmt.setString(3, article.getContent());
            pstmt.setString(4,article.getId()+"");
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    private static Article getArticle(long id)
    {
        Connection conn = getConn();
        String sql = "select * from article where id = ?";
        PreparedStatement pstmt;
        String title="";
        String author="";
        String content="";
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            pstmt.setString(1, id+"");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                title=rs.getString("title");
                author=rs.getString("author");
                content=rs.getString("content");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Article ans=new Article(title,author,content,id);
        return ans;
    }
    private static Account getAccount(long id)
    {
        Connection conn = getConn();
        String sql = "select * from account where id = ?";
        PreparedStatement pstmt;
        String name="";
        String password="";
        int permissions=0;
        String email="";
        String info="";
        String status="";
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            pstmt.setString(1, id+"");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                name=rs.getString("name");
                password=rs.getString("password");
                permissions=Integer.valueOf(rs.getString("permissions"));
                email=rs.getString("email");
                info=rs.getString("info");
                status=rs.getString("status");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Account ans=new Account(name,id,password,permissions,email,info,status);
        return ans;
    }
    private static Integer getAll() {
        Connection conn = getConn();
        String sql = "select * from students";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int col = rs.getMetaData().getColumnCount();
            System.out.println("============================");
            while (rs.next()) {
                for (int i = 1; i <= col; i++) {
                    System.out.print(rs.getString(i) + "\t");
                    if ((i == 2) && (rs.getString(i).length() < 8)) {
                        System.out.print("\t");
                    }
                }
                System.out.println("");
            }
            System.out.println("============================");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static int delete(String name) {
        Connection conn = getConn();
        int i = 0;
        String sql = "delete from students where Name='" + name + "'";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            i = pstmt.executeUpdate();
            System.out.println("resutl: " + i);
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    public static void main(String[] args)
    {
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
