package menu;

import controller.BookIssueController;
import model.BookIssue;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class BookIssueMenu {

    private final Scanner scanner;
    private final BookIssueController controller;

    public BookIssueMenu() {

        scanner = new Scanner(System.in);
        controller = new BookIssueController();

    }

    public void start() {

        while (true) {

            System.out.println("\n================================");
            System.out.println(" BOOK ISSUE MANAGEMENT ");
            System.out.println("================================");
            System.out.println("1. Issue Book");
            System.out.println("2. View Issued Books");
            System.out.println("3. Return Book");
            System.out.println("4. Delete Issue Record");
            System.out.println("0. Back");

            System.out.print("Choice : ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    issueBook();
                    break;

                case 2:
                    viewIssuedBooks();
                    break;

                case 3:
                    returnBook();
                    break;

                case 4:
                    deleteIssue();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid Choice.");

            }

        }

    }

    private void issueBook() {

        BookIssue issue = new BookIssue();

        System.out.print("Student ID : ");
        issue.setStudentId(Integer.parseInt(scanner.nextLine()));

        System.out.print("Book ID : ");
        issue.setBookId(Integer.parseInt(scanner.nextLine()));

        issue.setIssueDate(LocalDate.now());

        issue.setDueDate(LocalDate.now().plusDays(15));

        issue.setReturnDate(null);

        issue.setFine(0);

        if (controller.issueBook(issue))

            System.out.println("Book Issued Successfully.");

        else

            System.out.println("Issue Failed.");

    }

    private void viewIssuedBooks() {

        List<BookIssue> issues =
                controller.getAllIssuedBooks();

        for (BookIssue issue : issues) {

            System.out.println(issue);

        }

    }

    private void returnBook() {

        System.out.print("Issue ID : ");

        int issueId =
                Integer.parseInt(scanner.nextLine());

        BookIssue issue =
                controller.getIssueById(issueId);

        if (issue == null) {

            System.out.println("Issue Record Not Found.");

            return;

        }

        issue.setReturnDate(LocalDate.now());

        if (issue.getReturnDate().isAfter(issue.getDueDate())) {

            long days =
                    issue.getReturnDate().toEpochDay()
                    - issue.getDueDate().toEpochDay();

            issue.setFine(days * 5);

        } else {

            issue.setFine(0);

        }

        if (controller.updateIssue(issue))

            System.out.println("Book Returned Successfully.");

        else

            System.out.println("Return Failed.");

    }

    private void deleteIssue() {

        System.out.print("Issue ID : ");

        int issueId =
                Integer.parseInt(scanner.nextLine());

        if (controller.deleteIssue(issueId))

            System.out.println("Deleted Successfully.");

        else

            System.out.println("Delete Failed.");

    }

}