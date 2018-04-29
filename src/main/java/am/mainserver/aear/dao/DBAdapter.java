package am.mainserver.aear.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class DBAdapter {

    private static DBAdapter instance;
    private Connection connection;

    private DBAdapter() throws SQLException, MissingResourceException {
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        String host = rb.getString("host");
        String db = rb.getString("db");
        String user = rb.getString("user");
        String password = rb.getString("password");
        String jdbcUrlMessageFormat = MessageFormat.format(
                "jdbc:mysql://{0}:3306/{1}", host, db
        );
        connection = DriverManager.getConnection(jdbcUrlMessageFormat, user, password);
    }

    public static DBAdapter getInstance() {
        if (instance == null) {
            try {
                instance = new DBAdapter();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}