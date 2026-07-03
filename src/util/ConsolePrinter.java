package util;

public class ConsolePrinter {

    private ConsolePrinter() {
    }

    public static void title(String title) {

        System.out.println();

        System.out.println(ConsoleColor.CYAN +
                "======================================================");

        System.out.printf("%30s%n", title.toUpperCase());

        System.out.println(
                "======================================================"
                + ConsoleColor.RESET);

    }

    public static void success(String message) {

        System.out.println(ConsoleColor.GREEN +
                "✔ " + message + ConsoleColor.RESET);

    }

    public static void error(String message) {

        System.out.println(ConsoleColor.RED +
                "✖ " + message + ConsoleColor.RESET);

    }

    public static void warning(String message) {

        System.out.println(ConsoleColor.YELLOW +
                "⚠ " + message + ConsoleColor.RESET);

    }

    public static void info(String message) {

        System.out.println(ConsoleColor.BLUE +
                message + ConsoleColor.RESET);

    }

}