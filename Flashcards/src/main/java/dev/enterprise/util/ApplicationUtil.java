package dev.enterprise.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public enum ApplicationUtil {
    INSTANCE;

    public static final String URL = "jdbc:postgresql://postgresql-class.cks98gmxels6.us-west-1.rds.amazonaws.com:5432/enterprise?currentSchema=enterprise_study";
    public static final String USERNAME = "enterprise_associate";
    public static final String PASSWORD = "password";

    final int MAX_THREADS = 4;
    ExecutorService threadActivatah = Executors.newFixedThreadPool(MAX_THREADS);

    public ExecutorService getThreadActivatah() {
        return threadActivatah;
    }

    public final Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public void shutdown(){

    }

}
