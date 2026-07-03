package menu;

import controller.ReportController;

public class ReportMenu {

    private final ReportController controller;

    public ReportMenu() {

        controller = new ReportController();

    }

    public void start() {

        while (true) {

            System.out.println("\n==============================");
            System.out.println(" REPORTS ");
            System.out.println("==============================");
            System.out.println("1. Attendance Report");
            System.out.println("2. Marks Report");
            System.out.println("3. Fee Report");
            System.out.println("4. Library Report");
            System.out.println("5. Dashboard");
            System.out.println("0. Back");

            System.out.print("Choice : ");

            int choice =
                    Integer.parseInt(new java.util.Scanner(System.in).nextLine());

            switch (choice) {

                case 1:

                    controller.attendanceReport()
                            .forEach(System.out::println);

                    break;

                case 2:

                    controller.marksReport()
                            .forEach(System.out::println);

                    break;

                case 3:

                    controller.feeReport()
                            .forEach(System.out::println);

                    break;

                case 4:

                    controller.libraryReport()
                            .forEach(System.out::println);

                    break;

                case 5:

                    System.out.println(
                            controller.dashboardReport());

                    break;

                case 0:

                    return;

                default:

                    System.out.println("Invalid Choice.");

            }

        }

    }

}