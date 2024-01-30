package com.wallet.wallet.connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dataBaseConnection {

static {
    String url = System.getenv("DB_url");
    String user = System.getenv("DB_username");
    String password = System.getenv("DB_password");
    try {
        Connection connecion = DriverManager.getConnection(url, user, password);
        System.out.println("Connection establish.");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
