package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static Connection connection = null;
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/data";
    private static final String USERNAME = "root";
    private static final String PASS = "35312324";

    public static Connection getConnection () {

        try {
            Class.forName (DRIVER);
            connection = DriverManager.getConnection (URL, USERNAME, PASS);
            System.out.println ("Коннект ОК");
        } catch ( ClassNotFoundException | SQLException e ) {
            e.printStackTrace ();
            System.out.println ("Проблема подключения к БД");
        }
        return connection;
    }
    public static Connection closeConnection() {
        try {
            if (connection != null) {
                getConnection().close();
                System.out.println("Подключение отключено");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}

