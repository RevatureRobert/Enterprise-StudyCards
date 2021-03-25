package dev.enterprise.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * A singleton to hold the utility logic for the application. This
 *      class controls the db configurations and the thread pool utilization
 *      and creation.
 */
public enum ApplicationUtil {
    INSTANCE;

    public static final String URL = "jdbc:postgresql://postgresql-class.cks98gmxels6.us-west-1.rds.amazonaws.com:5432/enterprise?currentSchema=enterprise_study";
    public static final String USERNAME = "enterprise_associate";
    public static final String PASSWORD = "password";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    final int MAX_THREADS = 4;
    ExecutorService threadActivatah = Executors.newFixedThreadPool(MAX_THREADS);

    public ExecutorService getThreadActivatah() {
        return threadActivatah;
    }

    // To bypass the need for loading the class into the runtime manually and
    //      to have tomcat manage our connections, we can utilize tomcats
    //      JNDI container with a configured DataSource
    public final Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
//        Context ctx = null;
//        try {
//            ctx = new InitialContext();
//
//            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/psql");
//            return ds.getConnection();
//        } catch (NamingException e) {
//            e.printStackTrace();
//        }
//
//        throw new SQLException("The datasource could not be configured correctly");
    }


    public void shutdown(){

    }

}
