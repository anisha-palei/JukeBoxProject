/*
 * Author : Anisha Palei
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */

package com.niit.jdp.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionService {

    private static final String URL = "jdbc:mysql://localhost:3306/sales";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    Connection connection;

    public DatabaseConnectionService() {
        connection=null;
    }
    private void connect() throws ClassNotFoundException, SQLException {
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public Connection getConnectionToDatabase() throws SQLException, ClassNotFoundException {
        connect();
        return connection;
    }
}
