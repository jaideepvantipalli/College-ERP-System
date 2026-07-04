package constants;

/**
 * Global constants used throughout the College ERP System.
 */
public final class AppConstants {

    private AppConstants() {
        // Prevent object creation
    }

    // ==========================
    // APPLICATION
    // ==========================

    public static final String APP_NAME = "College ERP Management System";
    public static final String APP_VERSION = "1.0";

    // ==========================
    // DATABASE
    // ==========================

    public static final String DB_URL =
            "jdbc:mysql://localhost:3306/college_erp";

    public static final String DB_USERNAME = "your_username";

    public static final String DB_PASSWORD = "your_password";

    // ==========================
    // MENU
    // ==========================

    public static final int EXIT = 0;

}