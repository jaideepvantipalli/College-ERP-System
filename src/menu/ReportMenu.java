package menu;

import controller.ReportController;
import reports.*;
import util.InputUtil;
import util.ConsolePrinter;
import util.TablePrinter;

import java.util.List;

public class ReportMenu {

    private final ReportController controller;

    public ReportMenu() {

        controller = new ReportController();

    }

    public void start() {

        while (true) {

            ConsolePrinter.title("Reports & Dashboard");
            System.out.println("1. Attendance Report");
            System.out.println("2. Marks Report");
            System.out.println("3. Fee Report");
            System.out.println("4. Library Report");
            System.out.println("5. Dashboard");
            System.out.println("0. Back");

            int choice = InputUtil.readInt("Choice : ");

            switch (choice) {

                case 1:
                    showAttendanceReport();
                    break;

                case 2:
                    showMarksReport();
                    break;

                case 3:
                    showFeeReport();
                    break;

                case 4:
                    showLibraryReport();
                    break;

                case 5:
                    showDashboard();
                    break;

                case 0:
                    return;

                default:
                    ConsolePrinter.warning("Invalid Choice.");

            }

        }

    }

    private void showAttendanceReport() {

        List<AttendanceReport> list = controller.attendanceReport();

        if (list.isEmpty()) {
            ConsolePrinter.info("No attendance report data found.");
            return;
        }

        TablePrinter.heading("Student ID", "Student Name", "Subject", "Total Classes", "Present Classes", "Percentage");

        for (AttendanceReport r : list) {

            System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%n",
                    r.getStudentId(),
                    r.getStudentName(),
                    r.getSubjectName(),
                    r.getTotalClasses(),
                    r.getPresentClasses(),
                    r.getPercentage() + "%");

        }

        TablePrinter.line();

    }

    private void showMarksReport() {

        List<MarksReport> list = controller.marksReport();

        if (list.isEmpty()) {
            ConsolePrinter.info("No marks report data found.");
            return;
        }

        TablePrinter.heading("Student ID", "Student Name", "Subject", "Total Marks", "Grade");

        for (MarksReport r : list) {

            System.out.printf("%-18s%-18s%-18s%-18s%-18s%n",
                    r.getStudentId(),
                    r.getStudentName(),
                    r.getSubjectName(),
                    r.getTotal(),
                    r.getGrade());

        }

        TablePrinter.line();

    }

    private void showFeeReport() {

        List<FeeReport> list = controller.feeReport();

        if (list.isEmpty()) {
            ConsolePrinter.info("No fee report data found.");
            return;
        }

        TablePrinter.heading("Student ID", "Student Name", "Total Fee", "Paid Fee", "Balance");

        for (FeeReport r : list) {

            System.out.printf("%-18s%-18s%-18s%-18s%-18s%n",
                    r.getStudentId(),
                    r.getStudentName(),
                    r.getTotalFee(),
                    r.getPaidFee(),
                    r.getBalance());

        }

        TablePrinter.line();

    }

    private void showLibraryReport() {

        List<LibraryReport> list = controller.libraryReport();

        if (list.isEmpty()) {
            ConsolePrinter.info("No library report data found.");
            return;
        }

        TablePrinter.heading("Issue ID", "Student Name", "Book Title", "Issue Date", "Due Date", "Return Date", "Fine");

        for (LibraryReport r : list) {

            System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%-18s%n",
                    r.getIssueId(),
                    r.getStudentName(),
                    r.getBookTitle(),
                    r.getIssueDate(),
                    r.getDueDate(),
                    r.getReturnDate() != null ? r.getReturnDate() : "Not Returned",
                    r.getFine());

        }

        TablePrinter.line();

    }

    private void showDashboard() {

        DashboardReport r = controller.dashboardReport();

        ConsolePrinter.title("System Dashboard Overview");
        System.out.printf("%-25s: %d%n", "Total Students", r.getTotalStudents());
        System.out.printf("%-25s: %d%n", "Total Faculty", r.getTotalFaculty());
        System.out.printf("%-25s: %d%n", "Total Departments", r.getTotalDepartments());
        System.out.printf("%-25s: %d%n", "Total Subjects", r.getTotalSubjects());
        System.out.printf("%-25s: %d%n", "Total Books", r.getTotalBooks());
        TablePrinter.line();

    }

}