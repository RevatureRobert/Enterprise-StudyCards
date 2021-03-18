package dev.enterprise.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    public static final String URL="jdbc:postgresql://postgresql-class.cks98gmxels6.us-west-1.rds.amazonaws.com:5432/postgres";
    public static final String USERNAME="enterprise_associate";
    public static final String PASSWORD="password";

    public final Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    private static ConnectionUtil instance;
    private ConnectionUtil(){}
    public static final ConnectionUtil getInstance(){
        if(instance == null){
            instance = new ConnectionUtil();
        }
        return instance;
    }
}
