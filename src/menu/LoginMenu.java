package menu;

import controller.LoginController;
import enums.UserRole;
import model.User;
import util.InputUtil;
import util.ConsolePrinter;

public class LoginMenu {

    private final LoginController controller;

    public LoginMenu() {

        controller = new LoginController();

    }

    public void start() {

        ConsolePrinter.title("LOGIN");

        String username = InputUtil.readString("Username : ");
        String password = InputUtil.readString("Password : ");

        User user = controller.login(username, password);

        if (user != null) {

            ConsolePrinter.success("Login Successful");
            ConsolePrinter.info("Welcome " + user.getUsername());

            switch (user.getRole()) {
                case ADMIN:
                    new AdminMenu().start();
                    break;
                case STUDENT:
                    new StudentDashboardMenu(user).start();
                    break;
                case FACULTY:
                    new FacultyDashboardMenu(user).start();
                    break;
                case LIBRARIAN:
                    new LibrarianDashboardMenu(user).start();
                    break;
                case ACCOUNTANT:
                    new AccountantDashboardMenu(user).start();
                    break;
                default:
                    ConsolePrinter.warning("Module for " + user.getRole() + " is not recognized.");
            }

        } else {

            ConsolePrinter.error("Invalid Username or Password");

        }

    }

}