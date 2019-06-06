package top.fxxxx.InformationPortal.dao;

import org.dom4j.Element;
import top.fxxxx.InformationPortal.Util.ConfigProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataInformation {
    private static Connection conn = null;

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
        i=creatPartof();
        if(i!=0)
        {
            System.out.println("创建Partof表失败");
            return;
        }
        Operation.insertAccount(new Account("root",0,"123456",100,""));
    }
    public static Connection getConn(){
        try {
            if(conn==null||conn.isClosed()){
                synchronized (DataInformation.class){
                    if(conn==null||conn.isClosed()){
                        conn=createConnection();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    private static Connection createConnection() throws Exception {
        String DB_URL,USER,PASS;
        Element sql= ConfigProvider.getConfig("SQL");
        // 注册 JDBC 驱动
        Class.forName(sql.elementText("JDBC_DRIVER"));
        DB_URL=sql.elementText("url");
        USER=sql.elementText("username");
        PASS=sql.elementText("password");
        return DriverManager.getConnection(DB_URL,USER,PASS);
    }

    static int creatAccount()
    {
        String sql= "CREATE TABLE IF NOT EXISTS account(\n" +
                "   name VARCHAR(100),\n" +
                "   id BIGINT NOT NULL,\n" +
                "   password VARCHAR(100) NOT NULL,\n" +
                "   permissions BIGINT ,\n" +
                "   email VARCHAR(40),\n" +
                "   info VARCHAR(40),\n"+
                "   status VARCHAR(40),\n" +
                "   PRIMARY KEY ( name )\n" +
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
                "   rootpartof VARCHAR(100) NOT NULL,\n" +
                "   mydate BIGINT NOT NULL,\n" +
                "   content LONGTEXT NOT NULL,\n" +
                "   id BIGINT NOT NULL,\n" +
                "   PRIMARY KEY ( id ),\n" +
                "   KEY ( mydate )\n" +
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
    static int creatPartof()
    {
        String sql= "CREATE TABLE IF NOT EXISTS partof(\n" +
                "   partof VARCHAR(100) NOT NULL,\n" +
                "   rootpartof VARCHAR(100) NOT NULL,\n" +
                "   PRIMARY KEY ( partof )" +
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
