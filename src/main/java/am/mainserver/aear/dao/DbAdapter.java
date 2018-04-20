package am.mainserver.aear.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ResourceBundle;

public class DbAdapter {

    private static DbAdapter instance;
    private Connection connection;

    private DbAdapter()throws SQLException {
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        String host = rb.getString("host");
        String db = rb.getString("db");
        String user = rb.getString("user");


        String jdbcUrlMessageFormat = MessageFormat.format(
                "jdbc:mysql://{0}:3306/{1}",host,db
        );

        connection = DriverManager.getConnection(jdbcUrlMessageFormat,user,null);
    }

    public static DbAdapter getInstance(){
        if (instance == null){
            try {
                instance = new DbAdapter();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return instance;
    }

    public Connection getConnection(){
        return connection;
    }
}
