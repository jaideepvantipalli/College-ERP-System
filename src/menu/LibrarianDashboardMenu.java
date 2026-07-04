package menu;

import controller.ReportController;
import model.User;
import reports.LibraryReport;
import util.ConsolePrinter;
import util.InputUtil;
import util.TablePrinter;
import java.util.List;

public class LibrarianDashboardMenu {
    private final User user;
    private final ReportController reportController;

    public LibrarianDashboardMenu(User user) {
        this.user = user;
        this.reportController = new ReportController();
    }

    public void start() {
        while (true) {
            ConsolePrinter.title("LIBRARIAN DASHBOARD");
            System.out.println("1. Book Catalog Management");
            System.out.println("2. Book Circulation Desk (Issue/Return)");
            System.out.println("3. View Library Usage Report");
            System.out.println("0. Logout");

            int choice = InputUtil.readInt("Choice : ");

            switch (choice) {
                case 1:
                    new BookMenu().start();
                    break;
                case 2:
                    new BookIssueMenu().start();
                    break;
                case 3:
                    viewLibraryReport();
                    break;
                case 0:
                    ConsolePrinter.info("Logged out successfully.");
                    return;
                default:
                    ConsolePrinter.warning("Invalid Choice.");
            }
        }
    }

    private void viewLibraryReport() {
        ConsolePrinter.title("LIBRARY CIRCULATION REPORT");
        List<LibraryReport> reports = reportController.libraryReport();
        if (reports == null || reports.isEmpty()) {
            ConsolePrinter.info("No library circulation records found.");
            return;
        }

        TablePrinter.heading("Issue ID", "Student Name", "Book Title", "Issue Date", "Due Date", "Return Date", "Fine (INR)");
        for (LibraryReport r : reports) {
            System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%-18s%n",
                    r.getIssueId(),
                    r.getStudentName(),
                    r.getBookTitle(),
                    r.getIssueDate(),
                    r.getDueDate(),
                    r.getReturnDate() != null ? r.getReturnDate() : "Active",
                    r.getFine());
        }
        TablePrinter.line();
    }
}
