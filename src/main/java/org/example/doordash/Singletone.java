package org.example.doordash;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Provides the application's shared MySQL connection.
 * Configure DOORDASH_DB_HOST, DOORDASH_DB_NAME, DOORDASH_DB_USER,
 * and DOORDASH_DB_PASSWORD as environment variables before running.
 */
public class Singletone {
    private static final String DB_HOST = envOrDefault("DOORDASH_DB_HOST", "localhost");
    private static final String DB_NAME = envOrDefault("DOORDASH_DB_NAME", "DoorDash");
    private static final String DB_USER_NAME = envOrDefault("DOORDASH_DB_USER", "root");
    private static final String DB_PASSWORD = System.getenv("DOORDASH_DB_PASSWORD");
    private static final String DB_URL = "jdbc:mysql://" + DB_HOST + "/" + DB_NAME;
    private static Connection connection;
    private static final Singletone INSTANCE = new Singletone();

    private Singletone() {
        if (DB_PASSWORD == null || DB_PASSWORD.isBlank()) {
            System.err.println("Missing DOORDASH_DB_PASSWORD environment variable.");
            return;
        }
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER_NAME, DB_PASSWORD);
        } catch (SQLException ex) {
            System.err.println("Could not connect to the DoorDash database. Check DB settings and schema.");
            ex.printStackTrace();
        }
    }

    private static String envOrDefault(String name, String fallback) {
        String value = System.getenv(name);
        return value == null || value.isBlank() ? fallback : value;
    }

    public static Connection getConnection() {
        return connection;
    }
}
