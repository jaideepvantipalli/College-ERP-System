package menu;

import controller.LoginController;
import java.util.Scanner;
import model.User;

public class LoginMenu {

    private final Scanner scanner;
    private final LoginController controller;

    public LoginMenu() {

        scanner = new Scanner(System.in);

        controller = new LoginController();

    }

    public void start() {

        System.out.println();

        System.out.println("====================================");

        System.out.println("        LOGIN");

        System.out.println("====================================");

        System.out.print("Username : ");

        String username = scanner.nextLine();

        System.out.print("Password : ");

        String password = scanner.nextLine();

        User user = controller.login(username,
                                     password);

        if (user != null) {

            System.out.println();

            System.out.println("Login Successful");

            System.out.println("Welcome " +
                    user.getUsername());

            if (user.getRole().name().equals("ADMIN")) {

                new AdminMenu().start();

            } else {

            System.out.println("Module for "+ user.getRole()+ " will be implemented later.");

            }

        }

        else {

            System.out.println();

            System.out.println("Invalid Username or Password");

        }

    }

}