package menu;

import util.InputUtil;
import util.ConsolePrinter;

public class AdminMenu {

    public void start() {

        while (true) {

            ConsolePrinter.title("ADMIN DASHBOARD");
            System.out.println("1. Department Module");
            System.out.println("2. Student Module");
            System.out.println("3. Faculty Module");
            System.out.println("4. Subject Module");
            System.out.println("5. Attendance Module");
            System.out.println("6. Marks Module");
            System.out.println("7. Fee Module");
            System.out.println("8. Library Module");
            System.out.println("9. Notification Module");
            System.out.println("10. Report Module");
            System.out.println("0. Exit");

            int choice = InputUtil.readInt("Choice : ");

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
                    new MarksMenu().start();
                    break;

                case 7:
                    new FeeMenu().start();
                    break;

                case 8:
                    new LibraryMenu().start();
                    break;

                case 9:
                    new NotificationMenu().start();
                    break;

                case 10:
                    new ReportMenu().start();
                    break;

                case 0:
                    ConsolePrinter.info("Thank You.");
                    System.exit(0);

                default:
                    ConsolePrinter.warning("Invalid Choice.");

            }

        }

    }

}