package com.Servlet;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FindRows implements ServletContextListener{
    private static Connection conn = null;
    private static PreparedStatement pstmt = null;
    private static String sql = "select * from filelist where name LIKE ?";

    public static PreparedStatement getPstmt() {
        return pstmt;
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sqltest?useUnicode=true&setCharacterEncoding=UTF8&useTimezone=true&serverTimezone=PRC";
            String user = "root";
            String password = "48627913";
            conn = DriverManager.getConnection(
                    url, user, password
            );
            pstmt = conn.prepareStatement(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败！");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
