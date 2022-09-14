package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    private static Connection conn;

    public static Connection getConnection() {
        if(conn == null){
        try {
                String url = "jdbc:sqlserver://revated0.database.windows.net:1433;database=db;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
                String username = System.getenv("dbusername");
                String password = System.getenv("dbpassword");
                conn = DriverManager.getConnection(url, username, password);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    return conn;
    }

}
