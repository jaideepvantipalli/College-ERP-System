package menu;

import util.InputUtil;
import util.ConsolePrinter;

public class LibraryMenu {

    public void start() {

        while (true) {

            ConsolePrinter.title("LIBRARY MANAGEMENT");
            System.out.println("1. Book Management");
            System.out.println("2. Book Issue Management");
            System.out.println("0. Back");

            int choice = InputUtil.readInt("Choice : ");

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
                    ConsolePrinter.warning("Invalid Choice.");

            }

        }

    }

}