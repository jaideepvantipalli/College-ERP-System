package util;

public class TablePrinter {

    private TablePrinter() {
    }

    public static void line() {

        System.out.println(
                "----------------------------------------------------------------------------");

    }

    public static void heading(String... headings) {

        line();

        for (String heading : headings) {

            System.out.printf("%-18s", heading);

        }

        System.out.println();

        line();

    }

}