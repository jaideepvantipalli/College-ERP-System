package config;

import constants.AppConstants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Creates and manages database connections.
 */
public class DBConnection {

    private static Connection connection;

    private DBConnection() {
    }

    public static Connection getConnection() {

        try {

            if (connection == null || connection.isClosed()) {

                String dbUrl = System.getProperty("db.url", AppConstants.DB_URL);

                connection = DriverManager.getConnection(

                        dbUrl,

                        AppConstants.DB_USERNAME,

                        AppConstants.DB_PASSWORD
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return connection;

    }

}