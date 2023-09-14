package com.example.studentregistrationb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

@Singleton(name = "ConnectEJB")
public class ConnectBean {
    private Connection connection = null;

    public ConnectBean() {
    }

    @PostConstruct
    public void init() {
        String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "C##GUSTO";
        String password = "gusto";

        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Create a connection to the Oracle database
            connection = DriverManager.getConnection(dbUrl, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Lock(LockType.READ)
    public Connection getConnection() {
        return connection;
    }
}
