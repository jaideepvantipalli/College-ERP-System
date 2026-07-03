package menu;

import controller.LoginController;
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

            if (user.getRole().name().equals("ADMIN")) {

                new AdminMenu().start();

            } else {

                ConsolePrinter.warning("Module for " + user.getRole() + " will be implemented later.");

            }

        } else {

            ConsolePrinter.error("Invalid Username or Password");

        }

    }

}