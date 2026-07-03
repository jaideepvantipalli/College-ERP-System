package app;

import controller.*;
import model.*;
import enums.*;
import reports.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class AppTest {

    public static void main(String[] args) {
        // Force the app to use the test database
        System.setProperty("db.url", "jdbc:mysql://localhost:3306/college_erp_test");

        System.out.println("===============================================");
        System.out.println("       COLLEGE ERP SYSTEM INTEGRATION TESTS     ");
        System.out.println("===============================================");

        try {
            testDepartmentFlow();
            testFacultyFlow();
            testStudentFlow();
            testSubjectFlow();
            testAttendanceFlow();
            testMarksFlow();
            testFeeFlow();
            testBookFlow();
            testBookIssueFlow();
            testNotificationFlow();
            testReports();

            System.out.println("\n===============================================");
            System.out.println("   ALL INTEGRATION TESTS PASSED SUCCESSFULLY!  ");
            System.out.println("===============================================");
        } catch (Throwable e) {
            System.out.println("\n===============================================");
            System.out.println("           INTEGRATION TEST(S) FAILED          ");
            System.out.println("===============================================");
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void assertEquals(Object expected, Object actual, String message) {
        if (expected == null && actual == null) return;
        if (expected != null && expected.equals(actual)) return;
        throw new AssertionError(message + " [Expected: " + expected + ", Actual: " + actual + "]");
    }

    private static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    private static void testDepartmentFlow() {
        System.out.println("--> Testing Department Flow...");
        DepartmentController controller = new DepartmentController();

        // 1. Add Department
        Department dept = new Department();
        dept.setDepartmentName("Information Technology");
        dept.setDepartmentCode("IT");
        dept.setHodName("Dr. Sarah Connor");
        dept.setStatus("ACTIVE");
        assertTrue(controller.addDepartment(dept), "Should successfully add IT department");

        // 2. View All and Find
        List<Department> list = controller.getAllDepartments();
        boolean found = false;
        int targetId = -1;
        for (Department d : list) {
            if ("IT".equals(d.getDepartmentCode())) {
                found = true;
                targetId = d.getDepartmentId();
                assertEquals("Information Technology", d.getDepartmentName(), "Name should match");
                assertEquals("Dr. Sarah Connor", d.getHodName(), "HOD should match");
            }
        }
        assertTrue(found, "Added department should be found in all departments list");

        // 3. Search Department
        Department retrieved = controller.getDepartmentById(targetId);
        assertEquals("IT", retrieved.getDepartmentCode(), "Retrieved code should match");

        // 4. Update Department
        retrieved.setHodName("Dr. John Connor");
        assertTrue(controller.updateDepartment(retrieved), "Should successfully update department HOD");
        Department updatedRetrieved = controller.getDepartmentById(targetId);
        assertEquals("Dr. John Connor", updatedRetrieved.getHodName(), "HOD should be updated");

        System.out.println("    [PASSED] Department Flow");
    }

    private static void testFacultyFlow() {
        System.out.println("--> Testing Faculty Flow...");
        FacultyController controller = new FacultyController();

        // 1. Add Faculty
        Faculty faculty = new Faculty();
        faculty.setEmployeeId("EMP999");
        faculty.setFirstName("Alan");
        faculty.setLastName("Turing");
        faculty.setEmail("alan.turing@svec.edu");
        faculty.setPhone("9999999999");
        faculty.setDesignation("Professor Emeritus");
        faculty.setDepartmentId(1); // CSE Department (from sample data)
        faculty.setJoiningDate(LocalDate.now());
        faculty.setStatus("ACTIVE");
        assertTrue(controller.addFaculty(faculty), "Should successfully add Alan Turing");

        // 2. View All and Find
        List<Faculty> list = controller.getAllFaculty();
        boolean found = false;
        int targetId = -1;
        for (Faculty f : list) {
            if ("EMP999".equals(f.getEmployeeId())) {
                found = true;
                targetId = f.getFacultyId();
                assertEquals("Alan", f.getFirstName(), "First name should match");
                assertEquals("Turing", f.getLastName(), "Last name should match");
            }
        }
        assertTrue(found, "Added faculty should be found in list");

        // 3. Search Faculty
        Faculty retrieved = controller.getFacultyById(targetId);
        assertEquals("alan.turing@svec.edu", retrieved.getEmail(), "Retrieved email should match");

        // 4. Update Faculty
        retrieved.setPhone("8888888888");
        assertTrue(controller.updateFaculty(retrieved), "Should successfully update faculty");
        Faculty updatedRetrieved = controller.getFacultyById(targetId);
        assertEquals("8888888888", updatedRetrieved.getPhone(), "Phone should be updated");

        // 5. Faculty By Department
        List<Faculty> deptFaculties = controller.getFacultyByDepartment(1);
        assertTrue(deptFaculties.size() >= 1, "Department 1 should have faculty members");

        System.out.println("    [PASSED] Faculty Flow");
    }

    private static void testStudentFlow() {
        System.out.println("--> Testing Student Flow...");
        StudentController controller = new StudentController();

        // 1. Add Student
        Student student = new Student();
        student.setRollNumber("23CSE999");
        student.setFirstName("Ada");
        student.setLastName("Lovelace");
        student.setGender("FEMALE");
        student.setDateOfBirth(LocalDate.of(2005, 12, 10));
        student.setEmail("ada.lovelace@gmail.com");
        student.setPhone("9888888888");
        student.setDepartmentId(1); // CSE Department
        student.setAcademicYear(3);
        student.setSection('A');
        student.setAddress("London");
        student.setAdmissionDate(LocalDate.now());
        student.setStatus("ACTIVE");
        assertTrue(controller.addStudent(student), "Should successfully add Ada Lovelace");

        // 2. View All and Find
        List<Student> list = controller.getAllStudents();
        boolean found = false;
        int targetId = -1;
        for (Student s : list) {
            if ("23CSE999".equals(s.getRollNumber())) {
                found = true;
                targetId = s.getStudentId();
                assertEquals("Ada", s.getFirstName(), "First name should match");
                assertEquals("Lovelace", s.getLastName(), "Last name should match");
            }
        }
        assertTrue(found, "Added student should be found in list");

        // 3. Search Student
        Student retrieved = controller.getStudentById(targetId);
        assertEquals("ada.lovelace@gmail.com", retrieved.getEmail(), "Retrieved email should match");

        // 4. Update Student
        retrieved.setPhone("9777777777");
        assertTrue(controller.updateStudent(retrieved), "Should successfully update student");
        Student updatedRetrieved = controller.getStudentById(targetId);
        assertEquals("9777777777", updatedRetrieved.getPhone(), "Phone should be updated");

        // 5. Students By Department
        List<Student> deptStudents = controller.getStudentsByDepartment(1);
        assertTrue(deptStudents.size() >= 1, "Department 1 should have students");

        System.out.println("    [PASSED] Student Flow");
    }

    private static void testSubjectFlow() {
        System.out.println("--> Testing Subject Flow...");
        SubjectController controller = new SubjectController();

        // 1. Add Subject
        Subject subject = new Subject();
        subject.setSubjectCode("CS999");
        subject.setSubjectName("Theory of Computation");
        subject.setSemester(5);
        subject.setCredits(4);
        subject.setDepartmentId(1);
        subject.setFacultyId(1); // Assigned faculty
        subject.setStatus("ACTIVE");
        assertTrue(controller.addSubject(subject), "Should successfully add subject");

        // 2. View All and Find
        List<Subject> list = controller.getAllSubjects();
        boolean found = false;
        int targetId = -1;
        for (Subject s : list) {
            if ("CS999".equals(s.getSubjectCode())) {
                found = true;
                targetId = s.getSubjectId();
                assertEquals("Theory of Computation", s.getSubjectName(), "Subject name should match");
            }
        }
        assertTrue(found, "Added subject should be found in list");

        // 3. Search Subject
        Subject retrieved = controller.getSubjectById(targetId);
        assertEquals(4, retrieved.getCredits(), "Retrieved credits should match");

        // 4. Update Subject
        retrieved.setSubjectName("TOC Advanced");
        assertTrue(controller.updateSubject(retrieved), "Should successfully update subject");
        Subject updatedRetrieved = controller.getSubjectById(targetId);
        assertEquals("TOC Advanced", updatedRetrieved.getSubjectName(), "Subject name should be updated");

        // 5. Subjects By Department & Faculty
        assertTrue(controller.getSubjectsByDepartment(1).size() >= 1, "Department 1 should have subjects");
        assertTrue(controller.getSubjectsByFaculty(1).size() >= 1, "Faculty 1 should have subjects");

        System.out.println("    [PASSED] Subject Flow");
    }

    private static void testAttendanceFlow() {
        System.out.println("--> Testing Attendance Flow...");
        AttendanceController controller = new AttendanceController();

        // 1. Add Attendance
        Attendance attendance = new Attendance();
        attendance.setStudentId(1);
        attendance.setSubjectId(2);
        attendance.setFacultyId(1);
        attendance.setAttendanceDate(LocalDate.now());
        attendance.setStatus(AttendanceStatus.PRESENT);
        assertTrue(controller.addAttendance(attendance), "Should successfully add attendance");

        // 2. View All and Find
        List<Attendance> list = controller.getAllAttendance();
        boolean found = false;
        int targetId = -1;
        for (Attendance a : list) {
            if (a.getStudentId() == 1 && a.getSubjectId() == 2 && a.getAttendanceDate().equals(LocalDate.now())) {
                found = true;
                targetId = a.getAttendanceId();
                assertEquals(AttendanceStatus.PRESENT, a.getStatus(), "Status should be PRESENT");
            }
        }
        assertTrue(found, "Added attendance should be found in list");

        // 3. Search Attendance
        Attendance retrieved = controller.getAttendanceById(targetId);
        assertEquals(1, retrieved.getFacultyId(), "Retrieved faculty ID should match");

        // 4. Update Attendance
        retrieved.setStatus(AttendanceStatus.ABSENT);
        assertTrue(controller.updateAttendance(retrieved), "Should successfully update attendance");
        Attendance updatedRetrieved = controller.getAttendanceById(targetId);
        assertEquals(AttendanceStatus.ABSENT, updatedRetrieved.getStatus(), "Status should be ABSENT");

        // 5. Attendance By Student
        assertTrue(controller.getAttendanceByStudent(1).size() >= 1, "Student 1 should have attendance records");

        System.out.println("    [PASSED] Attendance Flow");
    }

    private static void testMarksFlow() {
        System.out.println("--> Testing Marks Flow...");
        MarksController controller = new MarksController();

        // 1. Add Marks
        Marks marks = new Marks();
        marks.setStudentId(1);
        marks.setSubjectId(2); // From DBMS subject in sample data
        marks.setInternal1(20.0);
        marks.setInternal2(18.0);
        marks.setAssignment(10.0);
        marks.setSemesterExam(45.0);
        marks.setTotal(93.0);
        marks.setGrade("A+");
        assertTrue(controller.addMarks(marks), "Should successfully add marks");

        // 2. View All and Find
        List<Marks> list = controller.getAllMarks();
        boolean found = false;
        int targetId = -1;
        for (Marks m : list) {
            if (m.getStudentId() == 1 && m.getSubjectId() == 2) {
                found = true;
                targetId = m.getMarkId();
                assertEquals(93.0, m.getTotal(), "Total should match");
                assertEquals("A+", m.getGrade().trim(), "Grade should match");
            }
        }
        assertTrue(found, "Added marks should be found in list");

        // 3. Search Marks
        Marks retrieved = controller.getMarksById(targetId);
        assertEquals(20.0, retrieved.getInternal1(), "Internal 1 should match");

        // 4. Update Marks
        retrieved.setInternal1(25.0);
        retrieved.setTotal(98.0);
        assertTrue(controller.updateMarks(retrieved), "Should successfully update marks");
        Marks updatedRetrieved = controller.getMarksById(targetId);
        assertEquals(25.0, updatedRetrieved.getInternal1(), "Internal 1 should be updated");

        // 5. Marks By Student
        assertTrue(controller.getMarksByStudent(1).size() >= 1, "Student 1 should have marks records");

        System.out.println("    [PASSED] Marks Flow");
    }

    private static void testFeeFlow() {
        System.out.println("--> Testing Fee Flow...");
        FeeController controller = new FeeController();

        // 1. Add Fee
        Fee fee = new Fee();
        fee.setStudentId(2); // Student 2 from sample data
        fee.setTotalFee(60000.0);
        fee.setPaidFee(40000.0);
        fee.setBalance(20000.0);
        fee.setPaymentDate(LocalDate.now());
        fee.setStatus(FeeStatus.PARTIAL);
        assertTrue(controller.addFee(fee), "Should successfully add fee");

        // 2. View All and Find
        List<Fee> list = controller.getAllFees();
        boolean found = false;
        int targetId = -1;
        for (Fee f : list) {
            if (f.getStudentId() == 2 && f.getTotalFee() == 60000.0) {
                found = true;
                targetId = f.getFeeId();
                assertEquals(20000.0, f.getBalance(), "Balance should match");
            }
        }
        assertTrue(found, "Added fee should be found in list");

        // 3. Search Fee
        Fee retrieved = controller.getFeeById(targetId);
        assertEquals(40000.0, retrieved.getPaidFee(), "Paid fee should match");

        // 4. Update Fee
        retrieved.setPaidFee(60000.0);
        retrieved.setBalance(0.0);
        retrieved.setStatus(FeeStatus.PAID);
        assertTrue(controller.updateFee(retrieved), "Should successfully update fee");
        Fee updatedRetrieved = controller.getFeeById(targetId);
        assertEquals(0.0, updatedRetrieved.getBalance(), "Balance should be updated to 0");
        assertEquals(FeeStatus.PAID, updatedRetrieved.getStatus(), "Status should be updated to PAID");

        // 5. Fee By Student
        assertTrue(controller.getFeeByStudent(2).size() >= 1, "Student 2 should have fee records");

        System.out.println("    [PASSED] Fee Flow");
    }

    private static void testBookFlow() {
        System.out.println("--> Testing Book Flow...");
        BookController controller = new BookController();

        // 1. Add Book
        Book book = new Book();
        book.setIsbn("9780132350884");
        book.setTitle("Clean Code");
        book.setAuthor("Robert C. Martin");
        book.setPublisher("Prentice Hall");
        book.setCategory("Programming");
        book.setQuantity(5);
        book.setAvailableQuantity(5);
        assertTrue(controller.addBook(book), "Should successfully add book Clean Code");

        // 2. View All and Find
        List<Book> list = controller.getAllBooks();
        boolean found = false;
        int targetId = -1;
        for (Book b : list) {
            if ("9780132350884".equals(b.getIsbn())) {
                found = true;
                targetId = b.getBookId();
                assertEquals("Clean Code", b.getTitle(), "Title should match");
            }
        }
        assertTrue(found, "Added book should be found in list");

        // 3. Search Book
        Book retrieved = controller.getBookById(targetId);
        assertEquals("Robert C. Martin", retrieved.getAuthor(), "Author should match");

        // 4. Update Book
        retrieved.setQuantity(7);
        retrieved.setAvailableQuantity(7);
        assertTrue(controller.updateBook(retrieved), "Should successfully update book");
        Book updatedRetrieved = controller.getBookById(targetId);
        assertEquals(7, updatedRetrieved.getQuantity(), "Quantity should be updated");

        System.out.println("    [PASSED] Book Flow");
    }

    private static void testBookIssueFlow() {
        System.out.println("--> Testing Book Issue Flow...");
        BookIssueController controller = new BookIssueController();

        // 1. Issue Book
        BookIssue issue = new BookIssue();
        issue.setStudentId(1);
        issue.setBookId(1);
        issue.setIssueDate(LocalDate.now());
        issue.setDueDate(LocalDate.now().plusDays(15));
        issue.setReturnDate(null);
        issue.setFine(0);
        assertTrue(controller.issueBook(issue), "Should successfully issue book");

        // 2. View All and Find
        List<BookIssue> list = controller.getAllIssuedBooks();
        boolean found = false;
        int targetId = -1;
        for (BookIssue bi : list) {
            if (bi.getStudentId() == 1 && bi.getBookId() == 1 && bi.getReturnDate() == null) {
                found = true;
                targetId = bi.getIssueId();
            }
        }
        assertTrue(found, "Added book issue should be found in list");

        // 3. Return Book
        BookIssue retrieved = controller.getIssueById(targetId);
        retrieved.setReturnDate(LocalDate.now());
        retrieved.setFine(0);
        assertTrue(controller.updateIssue(retrieved), "Should successfully return book (update issue)");
        BookIssue returnedIssue = controller.getIssueById(targetId);
        assertEquals(LocalDate.now(), returnedIssue.getReturnDate(), "Return date should be set");

        System.out.println("    [PASSED] Book Issue Flow");
    }

    private static void testNotificationFlow() {
        System.out.println("--> Testing Notification Flow...");
        NotificationController controller = new NotificationController();

        // 1. Send Notification
        Notification notification = new Notification();
        notification.setTitle("Holiday Notice");
        notification.setMessage("College closed on Monday.");
        notification.setTargetRole(NotificationType.ALL);
        notification.setCreatedBy(1); // Admin user
        notification.setCreatedDate(LocalDateTime.now());
        assertTrue(controller.addNotification(notification), "Should successfully send notification");

        // 2. View All and Find
        List<Notification> list = controller.getAllNotifications();
        boolean found = false;
        int targetId = -1;
        for (Notification n : list) {
            if ("Holiday Notice".equals(n.getTitle())) {
                found = true;
                targetId = n.getNotificationId();
                assertEquals("College closed on Monday.", n.getMessage(), "Message should match");
            }
        }
        assertTrue(found, "Sent notification should be found in list");

        // 3. Search Notification
        Notification retrieved = controller.getNotificationById(targetId);
        assertEquals(NotificationType.ALL, retrieved.getTargetRole(), "Target role should match");

        // 4. Update Notification
        retrieved.setTitle("Holiday Cancelled");
        retrieved.setMessage("College is open on Monday.");
        assertTrue(controller.updateNotification(retrieved), "Should successfully update notification");
        Notification updatedRetrieved = controller.getNotificationById(targetId);
        assertEquals("Holiday Cancelled", updatedRetrieved.getTitle(), "Title should be updated");

        System.out.println("    [PASSED] Notification Flow");
    }

    private static void testReports() {
        System.out.println("--> Testing Reports & Dashboard...");
        ReportController controller = new ReportController();

        // 1. Attendance Report
        assertTrue(controller.attendanceReport().size() >= 1, "Should retrieve attendance report");

        // 2. Marks Report
        assertTrue(controller.marksReport().size() >= 1, "Should retrieve marks report");

        // 3. Fee Report
        assertTrue(controller.feeReport().size() >= 1, "Should retrieve fee report");

        // 4. Library Report
        assertTrue(controller.libraryReport().size() >= 1, "Should retrieve library report");

        // 5. Dashboard Report
        DashboardReport r = controller.dashboardReport();
        assertTrue(r.getTotalStudents() >= 1, "Total students in dashboard should be >= 1");
        assertTrue(r.getTotalFaculty() >= 1, "Total faculty in dashboard should be >= 1");
        assertTrue(r.getTotalDepartments() >= 1, "Total departments in dashboard should be >= 1");
        assertTrue(r.getTotalSubjects() >= 1, "Total subjects in dashboard should be >= 1");
        assertTrue(r.getTotalBooks() >= 1, "Total books in dashboard should be >= 1");

        System.out.println("    [PASSED] Reports & Dashboard");
    }
}
