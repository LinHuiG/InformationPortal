package top.fxxxx.InformationPortal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class DataInformation {
    public static String driver = "com.mysql.cj.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/testInformationPortal?serverTimezone=CTT&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true";
    private static String username = "root";
    private static String password = "123456";
    public static void init()
    {
        int i=creatAccount();
        if(i!=0)
        {
            System.out.println("创建Account表失败");
            return;
        }
        i=creatArticle();
        if(i!=0)
        {
            System.out.println("创建Article表失败");
            return;
        }
    }
    protected static Connection getConn() {

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
    static int creatAccount()
    {
        String sql= "CREATE TABLE IF NOT EXISTS account(\n" +
                "   name VARCHAR(100),\n" +
                "   id VARCHAR(100) NOT NULL,\n" +
                "   password VARCHAR(100) NOT NULL,\n" +
                "   permissions VARCHAR(1000),\n" +
                "   email VARCHAR(40),\n" +
                "   info VARCHAR(40),\n"+
                "   status VARCHAR(40),\n" +
                "   PRIMARY KEY ( id )\n" +
                ")ENGINE=InnoDB DEFAULT CHARSET=utf8;";
        Connection conn = DataInformation.getConn();
        int i = -1;

        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    static int creatArticle()
    {
        String sql= "CREATE TABLE IF NOT EXISTS article(\n" +
                "   title VARCHAR(100),\n" +
                "   author VARCHAR(100) NOT NULL,\n" +
                "   partof VARCHAR(100) NOT NULL,\n" +
                "   content LONGTEXT NOT NULL,\n" +
                "   id VARCHAR(100) NOT NULL,\n" +
                "   PRIMARY KEY ( id )\n" +
                ")ENGINE=InnoDB DEFAULT CHARSET=utf8;";
        Connection conn = DataInformation.getConn();
        int i = -1;
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
}
