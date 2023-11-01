package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/data";
    private static final String USERNAME = "root";
    private static final String PASS = "35312324";
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USERNAME,PASS);
            System.out.println("Коннект ОК");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Проблема подключения к БД");
        }
        return connection;
    }
}

/*   public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to database...");
            Connection connection = DriverManager.getConnection(
                    URL, USERNAME, PASS);
            if (connection != null) {
                System.out.println("Database connection established!");
            } else {
                throw new SQLException("Error connecting to database");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

*/