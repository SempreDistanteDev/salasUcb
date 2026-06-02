package org.salas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Boilerplate de IA

public class DatabaseConfig {
    private static final String URL = "jdbc:postgresql://146.235.35.239:8443/ubuntu";
    private static final String USER = "publico";
    private static final String PASSWORD = "publico";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}