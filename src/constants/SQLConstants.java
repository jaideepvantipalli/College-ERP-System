package constants;

/**
 * SQL queries used across the application.
 */
public final class SQLConstants {

    private SQLConstants() {
    }

    // Login

    public static final String LOGIN =

            "SELECT * FROM users " +
            "WHERE username=? AND password=?";

}