package menu;

import controller.*;
import model.*;
import util.*;
import enums.AttendanceStatus;
import enums.NotificationType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class FacultyDashboardMenu {
    private final User user;
    private final FacultyController facultyController;
    private final SubjectController subjectController;
    private final AttendanceController attendanceController;
    private final StudentController studentController;
    private final MarksController marksController;
    private final NotificationController notificationController;
    private final DepartmentController departmentController;
    private Faculty currentFaculty;

    public FacultyDashboardMenu(User user) {
        this.user = user;
        this.facultyController = new FacultyController();
        this.subjectController = new SubjectController();
        this.attendanceController = new AttendanceController();
        this.studentController = new StudentController();
        this.marksController = new MarksController();
        this.notificationController = new NotificationController();
        this.departmentController = new DepartmentController();

        List<Faculty> faculties = facultyController.getAllFaculty();
        for (Faculty f : faculties) {
            if (f.getEmployeeId().equalsIgnoreCase(user.getUsername())) {
                this.currentFaculty = f;
                break;
            }
        }
    }

    public void start() {
        if (currentFaculty == null) {
            ConsolePrinter.error("Faculty profile not found for user: " + user.getUsername());
            return;
        }

        while (true) {
            ConsolePrinter.title("FACULTY DASHBOARD");
            System.out.println("Welcome, Prof. " + currentFaculty.getFirstName() + " " + (currentFaculty.getLastName() != null ? currentFaculty.getLastName() : ""));
            System.out.println("1. View Profile");
            System.out.println("2. View Assigned Subjects");
            System.out.println("3. Record Attendance");
            System.out.println("4. View Subject Attendance");
            System.out.println("5. Add/Update Student Marks");
            System.out.println("6. Post Announcement");
            System.out.println("0. Logout");

            int choice = InputUtil.readInt("Choice : ");

            switch (choice) {
                case 1:
                    viewProfile();
                    break;
                case 2:
                    viewAssignedSubjects();
                    break;
                case 3:
                    recordAttendance();
                    break;
                case 4:
                    viewSubjectAttendance();
                    break;
                case 5:
                    addUpdateMarks();
                    break;
                case 6:
                    postAnnouncement();
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
        System.out.println("Employee ID  : " + currentFaculty.getEmployeeId());
        System.out.println("Full Name    : " + currentFaculty.getFirstName() + " " + (currentFaculty.getLastName() != null ? currentFaculty.getLastName() : ""));
        System.out.println("Designation  : " + currentFaculty.getDesignation());
        System.out.println("Email        : " + currentFaculty.getEmail());
        System.out.println("Phone        : " + currentFaculty.getPhone());
        
        String deptName = "Unknown";
        Department dept = departmentController.getDepartmentById(currentFaculty.getDepartmentId());
        if (dept != null) {
            deptName = dept.getDepartmentName() + " (" + dept.getDepartmentCode() + ")";
        }
        System.out.println("Department   : " + deptName);
        System.out.println("Joining Date : " + currentFaculty.getJoiningDate());
        System.out.println("Status       : " + currentFaculty.getStatus());
        TablePrinter.line();
    }

    private void viewAssignedSubjects() {
        ConsolePrinter.title("MY ASSIGNED SUBJECTS");
        List<Subject> subjects = subjectController.getSubjectsByFaculty(currentFaculty.getFacultyId());
        
        if (subjects == null || subjects.isEmpty()) {
            ConsolePrinter.info("No subjects assigned to you.");
            return;
        }

        TablePrinter.heading("Subject ID", "Subject Code", "Subject Name", "Semester", "Credits");
        for (Subject s : subjects) {
            System.out.printf("%-18s%-18s%-18s%-18s%-18s%n",
                    s.getSubjectId(),
                    s.getSubjectCode(),
                    s.getSubjectName(),
                    s.getSemester(),
                    s.getCredits());
        }
        TablePrinter.line();
    }

    private void recordAttendance() {
        ConsolePrinter.title("RECORD ATTENDANCE");
        List<Subject> subjects = subjectController.getSubjectsByFaculty(currentFaculty.getFacultyId());
        if (subjects == null || subjects.isEmpty()) {
            ConsolePrinter.warning("You must have assigned subjects to record attendance.");
            return;
        }

        viewAssignedSubjects();
        int subjectId = InputUtil.readInt("Enter Subject ID from list: ");
        
        // Validate that this faculty is assigned to the subject
        Subject targetSubject = null;
        for (Subject s : subjects) {
            if (s.getSubjectId() == subjectId) {
                targetSubject = s;
                break;
            }
        }
        if (targetSubject == null) {
            ConsolePrinter.error("Invalid Subject ID or subject not assigned to you.");
            return;
        }

        String dateStr = InputUtil.readString("Enter Date (YYYY-MM-DD) [Enter for Today]: ");
        LocalDate date = dateStr.trim().isEmpty() ? LocalDate.now() : LocalDate.parse(dateStr);

        // Fetch students in the department
        List<Student> students = studentController.getStudentsByDepartment(targetSubject.getDepartmentId());
        if (students == null || students.isEmpty()) {
            ConsolePrinter.info("No students found in department ID " + targetSubject.getDepartmentId());
            return;
        }

        ConsolePrinter.info("Marking attendance for " + targetSubject.getSubjectName() + " on " + date);
        int presentCount = 0;
        int totalCount = 0;

        for (Student s : students) {
            if (!"ACTIVE".equalsIgnoreCase(s.getStatus())) continue;
            
            String prompt = "Roll: " + s.getRollNumber() + " - " + s.getFirstName() + " " + (s.getLastName() != null ? s.getLastName() : "") + " Present? (y/n): ";
            String resp = InputUtil.readString(prompt);
            
            Attendance att = new Attendance();
            att.setStudentId(s.getStudentId());
            att.setSubjectId(subjectId);
            att.setFacultyId(currentFaculty.getFacultyId());
            att.setAttendanceDate(date);
            
            if ("y".equalsIgnoreCase(resp.trim()) || "yes".equalsIgnoreCase(resp.trim())) {
                att.setStatus(AttendanceStatus.PRESENT);
                presentCount++;
            } else {
                att.setStatus(AttendanceStatus.ABSENT);
            }
            
            attendanceController.addAttendance(att);
            totalCount++;
        }

        ConsolePrinter.success("Successfully recorded attendance. " + presentCount + "/" + totalCount + " present.");
    }

    private void viewSubjectAttendance() {
        ConsolePrinter.title("SUBJECT ATTENDANCE REGISTRY");
        List<Subject> subjects = subjectController.getSubjectsByFaculty(currentFaculty.getFacultyId());
        if (subjects == null || subjects.isEmpty()) {
            ConsolePrinter.info("No assigned subjects.");
            return;
        }
        
        viewAssignedSubjects();
        int subjectId = InputUtil.readInt("Enter Subject ID: ");
        
        boolean assigned = false;
        for (Subject s : subjects) {
            if (s.getSubjectId() == subjectId) {
                assigned = true;
                break;
            }
        }
        if (!assigned) {
            ConsolePrinter.error("Subject is not assigned to you.");
            return;
        }

        List<Attendance> attendanceList = attendanceController.getAllAttendance();
        boolean hasRecords = false;

        for (Attendance a : attendanceList) {
            if (a.getSubjectId() == subjectId) {
                if (!hasRecords) {
                    TablePrinter.heading("Date", "Student ID", "Roll Number", "Status");
                    hasRecords = true;
                }
                String roll = "N/A";
                Student student = studentController.getStudentById(a.getStudentId());
                if (student != null) {
                    roll = student.getRollNumber();
                }
                System.out.printf("%-18s%-18s%-18s%-18s%n",
                        a.getAttendanceDate(),
                        a.getStudentId(),
                        roll,
                        a.getStatus());
            }
        }
        if (!hasRecords) {
            ConsolePrinter.info("No attendance records found for this subject.");
        } else {
            TablePrinter.line();
        }
    }

    private void addUpdateMarks() {
        ConsolePrinter.title("ADD/UPDATE STUDENT MARKS");
        List<Subject> subjects = subjectController.getSubjectsByFaculty(currentFaculty.getFacultyId());
        if (subjects == null || subjects.isEmpty()) {
            ConsolePrinter.info("No assigned subjects.");
            return;
        }

        viewAssignedSubjects();
        int subjectId = InputUtil.readInt("Enter Subject ID: ");

        Subject targetSubject = null;
        for (Subject s : subjects) {
            if (s.getSubjectId() == subjectId) {
                targetSubject = s;
                break;
            }
        }
        if (targetSubject == null) {
            ConsolePrinter.error("Subject not assigned to you.");
            return;
        }

        String rollNo = InputUtil.readString("Enter Student Roll Number: ");
        Student targetStudent = null;
        List<Student> students = studentController.getAllStudents();
        for (Student s : students) {
            if (s.getRollNumber().equalsIgnoreCase(rollNo)) {
                targetStudent = s;
                break;
            }
        }
        if (targetStudent == null) {
            ConsolePrinter.error("Student with Roll Number " + rollNo + " not found.");
            return;
        }

        // Check if marks record already exists
        Marks existingMarks = null;
        List<Marks> marksList = marksController.getAllMarks();
        for (Marks m : marksList) {
            if (m.getStudentId() == targetStudent.getStudentId() && m.getSubjectId() == subjectId) {
                existingMarks = m;
                break;
            }
        }

        double int1 = InputUtil.readDouble("Internal 1 Marks (Max 25): ");
        double int2 = InputUtil.readDouble("Internal 2 Marks (Max 25): ");
        double assign = InputUtil.readDouble("Assignment Marks (Max 10): ");
        double sem = InputUtil.readDouble("Semester Exam Marks (Max 50): ");
        
        double total = int1 + int2 + assign + sem;
        String grade;
        if (total >= 90) grade = "A";
        else if (total >= 80) grade = "B";
        else if (total >= 70) grade = "C";
        else if (total >= 60) grade = "D";
        else grade = "F";

        Marks marks = (existingMarks != null) ? existingMarks : new Marks();
        marks.setStudentId(targetStudent.getStudentId());
        marks.setSubjectId(subjectId);
        marks.setInternal1(int1);
        marks.setInternal2(int2);
        marks.setAssignment(assign);
        marks.setSemesterExam(sem);
        marks.setTotal(total);
        marks.setGrade(grade);

        boolean success;
        if (existingMarks != null) {
            success = marksController.updateMarks(marks);
        } else {
            success = marksController.addMarks(marks);
        }

        if (success) {
            ConsolePrinter.success("Marks saved successfully! Total: " + total + " | Grade: " + grade);
        } else {
            ConsolePrinter.error("Failed to save student marks.");
        }
    }

    private void postAnnouncement() {
        ConsolePrinter.title("POST ANNOUNCEMENT");
        String title = InputUtil.readString("Title : ");
        String message = InputUtil.readString("Message : ");
        String target = InputUtil.readString("Target Role (ALL/STUDENT/FACULTY): ");
        
        Notification note = new Notification();
        note.setTitle(title);
        note.setMessage(message);
        try {
            note.setTargetRole(NotificationType.valueOf(target.toUpperCase()));
        } catch (IllegalArgumentException e) {
            ConsolePrinter.error("Invalid Target Role. Using default: ALL");
            note.setTargetRole(NotificationType.ALL);
        }
        note.setCreatedBy(user.getUserId());
        note.setCreatedDate(LocalDateTime.now());

        if (notificationController.addNotification(note)) {
            ConsolePrinter.success("Announcement posted successfully!");
        } else {
            ConsolePrinter.error("Failed to post announcement.");
        }
    }
}
