package menu;

import controller.ReportController;
import model.User;
import reports.FeeReport;
import util.ConsolePrinter;
import util.InputUtil;
import util.TablePrinter;
import java.util.List;

public class AccountantDashboardMenu {
    private final User user;
    private final ReportController reportController;

    public AccountantDashboardMenu(User user) {
        this.user = user;
        this.reportController = new ReportController();
    }

    public void start() {
        while (true) {
            ConsolePrinter.title("ACCOUNTANT DASHBOARD");
            System.out.println("1. Manage Student Fees");
            System.out.println("2. View Outstanding Balances Report");
            System.out.println("0. Logout");

            int choice = InputUtil.readInt("Choice : ");

            switch (choice) {
                case 1:
                    new FeeMenu().start();
                    break;
                case 2:
                    viewFeeBalancesReport();
                    break;
                case 0:
                    ConsolePrinter.info("Logged out successfully.");
                    return;
                default:
                    ConsolePrinter.warning("Invalid Choice.");
            }
        }
    }

    private void viewFeeBalancesReport() {
        ConsolePrinter.title("FEE BALANCES REPORT");
        List<FeeReport> reports = reportController.feeReport();
        if (reports == null || reports.isEmpty()) {
            ConsolePrinter.info("No fee reports found.");
            return;
        }

        TablePrinter.heading("Student ID", "Student Name", "Total Fee", "Paid Fee", "Balance");
        for (FeeReport r : reports) {
            if (r.getBalance() > 0) {
                System.out.printf("%-18s%-18s%-18s%-18s%-18s%n",
                        r.getStudentId(),
                        r.getStudentName(),
                        r.getTotalFee(),
                        r.getPaidFee(),
                        r.getBalance());
            }
        }
        TablePrinter.line();
    }
}
