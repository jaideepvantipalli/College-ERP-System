package menu;

import java.util.Scanner;

public class LibraryMenu {

    private final Scanner scanner;

    public LibraryMenu() {

        scanner = new Scanner(System.in);

    }

    public void start() {

        while (true) {

            System.out.println("\n==============================");
            System.out.println(" LIBRARY MANAGEMENT ");
            System.out.println("==============================");
            System.out.println("1. Book Management");
            System.out.println("2. Book Issue Management");
            System.out.println("0. Back");

            System.out.print("Choice : ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:

                    new BookMenu().start();

                    break;

                case 2:

                    new BookIssueMenu().start();

                    break;

                case 0:

                    return;

                default:

                    System.out.println("Invalid Choice.");

            }

        }

    }

}