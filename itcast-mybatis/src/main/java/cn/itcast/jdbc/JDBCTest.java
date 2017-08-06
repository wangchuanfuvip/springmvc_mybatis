package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest {

    public static void main(String[] args) {
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            // 加载驱动

            Class.forName("com.mysql.jdbc.Driver");

            // 创建连接
            String url = "jdbc:mysql://127.0.0.1:3306/mybatis";
            String username = "root";
            String password = "123456";

            connection = DriverManager.getConnection(url, username, password);

            String sql = "SELECT * FROM tb_user WHERE user_name = ?";
            // 获取Statement对象
            preparedStatement = connection.prepareStatement(sql);

            // 设置参数,2个参数，下标、数据，下标是从1开始
            preparedStatement.setString(1, "zhangsan");

            // 执行sql
            resultSet = preparedStatement.executeQuery();

            // 处理结果集
            while (resultSet.next()) {
                System.out.println("username : " + resultSet.getString("user_name"));
                System.out.println("name : " + resultSet.getString("name"));
                System.out.println("age : " + resultSet.getInt("age"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭连接，释放资源
            try {
                if (null != resultSet) {
                    resultSet.close();
                }
                if (null != preparedStatement) {
                    preparedStatement.close();
                }
                if (null != connection) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
