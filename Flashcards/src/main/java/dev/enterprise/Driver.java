package dev.enterprise;

import dev.enterprise.config.ConnectionUtil;

import java.sql.SQLException;

public class Driver {


    public static void main(String[] args) throws SQLException {
        System.out.println(ConnectionUtil.getInstance().getConnection().getClass().getName());
    }
}
