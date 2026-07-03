package util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {

    private PasswordUtil() {
    }

    public static String hashPassword(String password) {

        try {

            MessageDigest md =
                    MessageDigest.getInstance("SHA-256");

            byte[] hash =
                    md.digest(password.getBytes(StandardCharsets.UTF_8));

            StringBuilder builder =
                    new StringBuilder();

            for (byte b : hash) {

                builder.append(
                        String.format("%02x", b));

            }

            return builder.toString();

        }

        catch (NoSuchAlgorithmException e) {

            throw new RuntimeException(e);

        }

    }

    public static boolean verifyPassword(String password,
                                         String hashedPassword) {

        return hashPassword(password)
                .equals(hashedPassword);

    }

}