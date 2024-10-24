package com.jobportal.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/lk_job";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection connection;
    private static final Logger LOGGER = Logger.getLogger(DBConnection.class.getName());

    public static synchronized Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                LOGGER.log(Level.SEVERE, "Database connection error", e);
                throw new RuntimeException("Database connection error", e); // Propagate the exception
            }
        }
        return connection;
    }
}
