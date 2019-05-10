package top.fxxxx.InformationPortal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class DataInformation {
    public static String driver = "com.mysql.cj.jdbc.Driver";
    public static String url = "jdbc:mysql://localhost:3306/testInformationPortal?serverTimezone=CTT&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true";
    public static String username = "root";
    public static String password = "123456";
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
        Connection conn = Operation.getConn();
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
                "   content VARCHAR(20000) NOT NULL,\n" +
                "   id VARCHAR(100) NOT NULL,\n" +
                "   PRIMARY KEY ( id )\n" +
                ")ENGINE=InnoDB DEFAULT CHARSET=utf8;";
        Connection conn = Operation.getConn();
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
