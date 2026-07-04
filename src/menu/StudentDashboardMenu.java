package menu;

import controller.*;
import model.*;
import reports.*;
import util.*;
import enums.NotificationType;
import java.util.List;

public class StudentDashboardMenu {
    private final User user;
    private final StudentController studentController;
    private final ReportController reportController;
    private final NotificationController notificationController;
    private final BookIssueController bookIssueController;
    private final BookController bookController;
    private final DepartmentController departmentController;
    private Student currentStudent;

    public StudentDashboardMenu(User user) {
        this.user = user;
        this.studentController = new StudentController();
        this.reportController = new ReportController();
        this.notificationController = new NotificationController();
        this.bookIssueController = new BookIssueController();
        this.bookController = new BookController();
        this.departmentController = new DepartmentController();
        
        List<Student> students = studentController.getAllStudents();
        for (Student s : students) {
            if (s.getRollNumber().equalsIgnoreCase(user.getUsername())) {
                this.currentStudent = s;
                break;
            }
        }
    }

    public void start() {
        if (currentStudent == null) {
            ConsolePrinter.error("Student profile not found for user: " + user.getUsername());
            return;
        }

        while (true) {
            ConsolePrinter.title("STUDENT DASHBOARD");
            System.out.println("Welcome, " + currentStudent.getFirstName() + " " + (currentStudent.getLastName() != null ? currentStudent.getLastName() : ""));
            System.out.println("1. View Profile");
            System.out.println("2. View Attendance");
            System.out.println("3. View Marks & Report Card");
            System.out.println("4. View Fee Details");
            System.out.println("5. View Issued Books (Library)");
            System.out.println("6. View Announcements");
            System.out.println("0. Logout");

            int choice = InputUtil.readInt("Choice : ");

            switch (choice) {
                case 1:
                    viewProfile();
                    break;
                case 2:
                    viewAttendance();
                    break;
                case 3:
                    viewMarks();
                    break;
                case 4:
                    viewFees();
                    break;
                case 5:
                    viewIssuedBooks();
                    break;
                case 6:
                    viewAnnouncements();
                    break;
                case 0:
                    ConsolePrinter.info("Logged out successfully.");
                    return;
                default:
                    ConsolePrinter.warning("Invalid Choice.");
            }
        }
    }

    private void viewProfile() {
        ConsolePrinter.title("MY PROFILE");
        System.out.println("Roll Number : " + currentStudent.getRollNumber());
        System.out.println("Full Name   : " + currentStudent.getFirstName() + " " + (currentStudent.getLastName() != null ? currentStudent.getLastName() : ""));
        System.out.println("Gender      : " + currentStudent.getGender());
        System.out.println("Date of Birth: " + currentStudent.getDateOfBirth());
        System.out.println("Email       : " + currentStudent.getEmail());
        System.out.println("Phone       : " + currentStudent.getPhone());
        
        String deptName = "Unknown";
        Department dept = departmentController.getDepartmentById(currentStudent.getDepartmentId());
        if (dept != null) {
            deptName = dept.getDepartmentName() + " (" + dept.getDepartmentCode() + ")";
        }
        System.out.println("Department  : " + deptName);
        System.out.println("Academic Year: Year " + currentStudent.getAcademicYear());
        System.out.println("Section     : " + currentStudent.getSection());
        System.out.println("Address     : " + currentStudent.getAddress());
        System.out.println("Admission Date: " + currentStudent.getAdmissionDate());
        System.out.println("Status      : " + currentStudent.getStatus());
        TablePrinter.line();
    }

    private void viewAttendance() {
        ConsolePrinter.title("MY ATTENDANCE");
        List<AttendanceReport> reports = reportController.attendanceReport();
        boolean hasAttendance = false;
        
        for (AttendanceReport r : reports) {
            if (r.getStudentId() == currentStudent.getStudentId()) {
                if (!hasAttendance) {
                    TablePrinter.heading("Subject", "Total Classes", "Present Classes", "Percentage");
                    hasAttendance = true;
                }
                System.out.printf("%-18s%-18s%-18s%-18.2f%%%n", 
                        r.getSubjectName(), 
                        r.getTotalClasses(), 
                        r.getPresentClasses(), 
                        r.getPercentage());
            }
        }
        if (!hasAttendance) {
            ConsolePrinter.info("No attendance records found.");
        } else {
            TablePrinter.line();
        }
    }

    private void viewMarks() {
        ConsolePrinter.title("MY REPORT CARD");
        
        MarksController marksController = new MarksController();
        List<Marks> marksList = marksController.getMarksByStudent(currentStudent.getStudentId());
        
        if (marksList == null || marksList.isEmpty()) {
            ConsolePrinter.info("No marks records found.");
            return;
        }

        TablePrinter.heading("Subject", "Internal 1", "Internal 2", "Assignment", "Sem Exam", "Total", "Grade");
        for (Marks m : marksList) {
            String subjectName = "Subject ID " + m.getSubjectId();
            SubjectController subjectController = new SubjectController();
            Subject sub = subjectController.getSubjectById(m.getSubjectId());
            if (sub != null) {
                subjectName = sub.getSubjectName();
            }
            System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%-18s%n",
                    subjectName,
                    m.getInternal1(),
                    m.getInternal2(),
                    m.getAssignment(),
                    m.getSemesterExam(),
                    m.getTotal(),
                    m.getGrade());
        }
        TablePrinter.line();
    }

    private void viewFees() {
        ConsolePrinter.title("MY FEE STATUS");
        FeeController feeController = new FeeController();
        List<Fee> fees = feeController.getFeeByStudent(currentStudent.getStudentId());
        
        if (fees == null || fees.isEmpty()) {
            ConsolePrinter.info("No fee details found.");
            return;
        }

        TablePrinter.heading("Total Fee", "Paid Fee", "Balance", "Payment Date", "Status");
        for (Fee f : fees) {
            System.out.printf("%-18s%-18s%-18s%-18s%-18s%n",
                    f.getTotalFee(),
                    f.getPaidFee(),
                    f.getBalance(),
                    f.getPaymentDate() != null ? f.getPaymentDate() : "N/A",
                    f.getStatus());
        }
        TablePrinter.line();
    }

    private void viewIssuedBooks() {
        ConsolePrinter.title("MY ISSUED BOOKS");
        List<BookIssue> issues = bookIssueController.getAllIssuedBooks();
        boolean hasIssues = false;

        for (BookIssue issue : issues) {
            if (issue.getStudentId() == currentStudent.getStudentId() && issue.getReturnDate() == null) {
                if (!hasIssues) {
                    TablePrinter.heading("Book Title", "Issue Date", "Due Date", "Fine (INR)");
                    hasIssues = true;
                }
                String bookTitle = "Book ID " + issue.getBookId();
                Book book = bookController.getBookById(issue.getBookId());
                if (book != null) {
                    bookTitle = book.getTitle();
                }
                System.out.printf("%-18s%-18s%-18s%-18.2f%n",
                        bookTitle,
                        issue.getIssueDate(),
                        issue.getDueDate(),
                        issue.getFine());
            }
        }
        if (!hasIssues) {
            ConsolePrinter.info("You do not have any active issued books.");
        } else {
            TablePrinter.line();
        }
    }

    private void viewAnnouncements() {
        ConsolePrinter.title("ANNOUNCEMENTS");
        List<Notification> list = notificationController.getAllNotifications();
        boolean hasAnnouncements = false;

        for (Notification n : list) {
            if (n.getTargetRole() == NotificationType.ALL || n.getTargetRole() == NotificationType.STUDENT) {
                if (!hasAnnouncements) {
                    TablePrinter.heading("Date", "Title", "Message");
                    hasAnnouncements = true;
                }
                System.out.printf("%-18s%-18s%-18s%n",
                        n.getCreatedDate().toLocalDate(),
                        n.getTitle(),
                        n.getMessage());
            }
        }
        if (!hasAnnouncements) {
            ConsolePrinter.info("No announcements found.");
        } else {
            TablePrinter.line();
        }
    }
}
