package menu;

import java.util.Scanner;

public class AdminMenu {

    private final Scanner scanner;

    public AdminMenu() {

        scanner = new Scanner(System.in);

    }

    public void start() {

        while (true) {

            System.out.println();
            System.out.println("==================================");
            System.out.println(" ADMIN DASHBOARD ");
            System.out.println("==================================");
            System.out.println("1. Department Module");
            System.out.println("2. Student Module");
            System.out.println("3. Faculty Module");
            System.out.println("4. Subject Module");
            System.out.println("5. Attendance Module");
            System.out.println("6. Marks Module");
            System.out.println("7. Fee Module");
            System.out.println("8. Library Module");
            System.out.println("9. Notification Module");
            System.out.println("0. Exit");
            System.out.print("Choice : ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:

                    new DepartmentMenu().start();

                    break;

                case 2:

                    new StudentMenu().start();

                    break;

                case 3:

                    new FacultyMenu().start();

                    break;

                case 4:

                    new SubjectMenu().start();

                    break;

                case 5:

                    new AttendanceMenu().start();

                    break;

                case 6:

                    System.out.println("Marks Module Coming Next.");

                    break;

                case 7:

                    System.out.println("Fee Module Coming Next.");

                    break;

                case 8:

                    System.out.println("Library Module Coming Next.");

                    break;

                case 9:

                    System.out.println("Notification Module Coming Next.");

                    break;

                case 0:

                    System.out.println("Thank You.");

                    System.exit(0);

                default:

                    System.out.println("Invalid Choice.");

            }

        }

    }

}