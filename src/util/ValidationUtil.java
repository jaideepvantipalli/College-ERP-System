package util;

import java.util.regex.Pattern;

public class ValidationUtil {

    private ValidationUtil() {
    }

    public static boolean isValidEmail(String email) {

        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        return Pattern.matches(regex, email);

    }

    public static boolean isValidPhone(String phone) {

        return phone.matches("\\d{10}");

    }

    public static boolean isValidRollNumber(String roll) {

        return roll.matches("[A-Za-z0-9]+");

    }

    public static boolean isValidName(String name) {

        return name != null &&
                name.trim().length() >= 2;

    }

    public static boolean isPositiveAmount(double amount) {

        return amount >= 0;

    }

}