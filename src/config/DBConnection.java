package config;

import constants.AppConstants;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Creates and manages database connections.
 */
public class DBConnection {

    private static Connection connection;
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = new FileInputStream("db.properties")) {
            properties.load(input);
        } catch (IOException e) {
            // Suppress error and log a warning; will default to AppConstants.
            System.err.println("Warning: db.properties not found. Using defaults from AppConstants.");
        }
    }

    private DBConnection() {
    }

    public static Connection getConnection() {

        try {

            if (connection == null || connection.isClosed()) {

                String dbUrl = System.getProperty("db.url",
                        properties.getProperty("db.url", AppConstants.DB_URL));

                String dbUsername = System.getProperty("db.username",
                        properties.getProperty("db.username", AppConstants.DB_USERNAME));

                String dbPassword = System.getProperty("db.password",
                        properties.getProperty("db.password", AppConstants.DB_PASSWORD));

                connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return connection;

    }

}