package util;

import java.util.Scanner;

public class InputUtil {

    private static final Scanner scanner = new Scanner(System.in);

    private InputUtil() {
    }

    public static int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {

                ConsolePrinter.error("Please enter a valid integer.");

            }

        }

    }

    public static double readDouble(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Double.parseDouble(scanner.nextLine());

            } catch (NumberFormatException e) {

                ConsolePrinter.error("Please enter a valid number.");

            }

        }

    }

    public static String readString(String message) {

        System.out.print(message);

        return scanner.nextLine().trim();

    }

    public static java.time.LocalDate readDate(String message) {

        while (true) {

            try {

                System.out.print(message);

                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {

                    return null;

                }

                return java.time.LocalDate.parse(input);

            } catch (java.time.format.DateTimeParseException e) {

                ConsolePrinter.error("Please enter a valid date in yyyy-mm-dd format.");

            }

        }

    }

    public static char readChar(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {

                return input.charAt(0);

            }

            ConsolePrinter.error("Input cannot be empty.");

        }

    }

}