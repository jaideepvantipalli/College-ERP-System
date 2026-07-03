package menu;

import controller.BookIssueController;
import model.BookIssue;
import util.InputUtil;
import util.ConsolePrinter;
import util.TablePrinter;

import java.time.LocalDate;
import java.util.List;

public class BookIssueMenu {

    private final BookIssueController controller;

    public BookIssueMenu() {

        controller = new BookIssueController();

    }

    public void start() {

        while (true) {

            ConsolePrinter.title("Book Issue Management");
            System.out.println("1. Issue Book");
            System.out.println("2. View Issued Books");
            System.out.println("3. Return Book");
            System.out.println("4. Delete Issue Record");
            System.out.println("0. Back");

            int choice = InputUtil.readInt("Choice : ");

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
                    ConsolePrinter.warning("Invalid Choice.");

            }

        }

    }

    private void issueBook() {

        BookIssue issue = new BookIssue();

        issue.setStudentId(InputUtil.readInt("Student ID : "));
        issue.setBookId(InputUtil.readInt("Book ID : "));
        issue.setIssueDate(LocalDate.now());
        issue.setDueDate(LocalDate.now().plusDays(15));
        issue.setReturnDate(null);
        issue.setFine(0);

        if (controller.issueBook(issue))

            ConsolePrinter.success("Book Issued Successfully.");

        else

            ConsolePrinter.error("Issue Failed.");

    }

    private void viewIssuedBooks() {

        List<BookIssue> issues = controller.getAllIssuedBooks();

        if (issues.isEmpty()) {
            ConsolePrinter.info("No active book issues found.");
            return;
        }

        TablePrinter.heading("Issue ID", "Student ID", "Book ID", "Issue Date", "Due Date", "Return Date", "Fine");

        for (BookIssue issue : issues) {

            System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%-18s%n",
                    issue.getIssueId(),
                    issue.getStudentId(),
                    issue.getBookId(),
                    issue.getIssueDate(),
                    issue.getDueDate(),
                    issue.getReturnDate() != null ? issue.getReturnDate() : "Not Returned",
                    issue.getFine());

        }

        TablePrinter.line();

    }

    private void returnBook() {

        int issueId = InputUtil.readInt("Issue ID : ");

        BookIssue issue = controller.getIssueById(issueId);

        if (issue == null) {

            ConsolePrinter.error("Issue Record Not Found.");

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

            ConsolePrinter.success("Book Returned Successfully. Fine: " + issue.getFine());

        else

            ConsolePrinter.error("Return Failed.");

    }

    private void deleteIssue() {

        int issueId = InputUtil.readInt("Issue ID : ");

        if (controller.deleteIssue(issueId))

            ConsolePrinter.success("Deleted Successfully.");

        else

            ConsolePrinter.error("Delete Failed.");

    }

}