package app.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    public DBHelper() {
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(PropertyReader.getProperty("db.host"),
                    PropertyReader.getProperty("db.login"),
                    PropertyReader.getProperty("db.password"));
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
