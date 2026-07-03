package menu;

import controller.AttendanceController;
import enums.AttendanceStatus;
import model.Attendance;
import util.InputUtil;
import util.ConsolePrinter;
import util.TablePrinter;

import java.time.LocalDate;
import java.util.List;

public class AttendanceMenu {

    private final AttendanceController controller;

    public AttendanceMenu() {

        controller = new AttendanceController();

    }

    public void start() {

        while (true) {

            ConsolePrinter.title("Attendance Management");
            System.out.println("1. Add Attendance");
            System.out.println("2. View Attendance");
            System.out.println("3. Search Attendance");
            System.out.println("4. Update Attendance");
            System.out.println("5. Delete Attendance");
            System.out.println("6. Attendance By Student");
            System.out.println("0. Back");

            int choice = InputUtil.readInt("Choice : ");

            switch (choice) {

                case 1:
                    addAttendance();
                    break;

                case 2:
                    viewAttendance();
                    break;

                case 3:
                    searchAttendance();
                    break;

                case 4:
                    updateAttendance();
                    break;

                case 5:
                    deleteAttendance();
                    break;

                case 6:
                    attendanceByStudent();
                    break;

                case 0:
                    return;

                default:
                    ConsolePrinter.warning("Invalid Choice.");

            }

        }

    }

    private void addAttendance() {

        Attendance attendance = new Attendance();

        attendance.setStudentId(InputUtil.readInt("Student ID : "));
        attendance.setSubjectId(InputUtil.readInt("Subject ID : "));
        attendance.setFacultyId(InputUtil.readInt("Faculty ID : "));
        attendance.setAttendanceDate(InputUtil.readDate("Attendance Date (yyyy-mm-dd): "));

        String statusStr = InputUtil.readString("Status (PRESENT/ABSENT): ").toUpperCase();
        while (!statusStr.equals("PRESENT") && !statusStr.equals("ABSENT")) {
            ConsolePrinter.warning("Invalid Status. Please enter PRESENT or ABSENT.");
            statusStr = InputUtil.readString("Status (PRESENT/ABSENT): ").toUpperCase();
        }
        attendance.setStatus(AttendanceStatus.valueOf(statusStr));

        if (controller.addAttendance(attendance))

            ConsolePrinter.success("Attendance Added Successfully.");

        else

            ConsolePrinter.error("Failed.");

    }

    private void viewAttendance() {

        List<Attendance> attendanceList = controller.getAllAttendance();

        if (attendanceList.isEmpty()) {
            ConsolePrinter.info("No attendance records found.");
            return;
        }

        TablePrinter.heading("ID", "Student ID", "Subject ID", "Faculty ID", "Date", "Status");

        for (Attendance a : attendanceList) {

            System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%n",
                    a.getAttendanceId(),
                    a.getStudentId(),
                    a.getSubjectId(),
                    a.getFacultyId(),
                    a.getAttendanceDate(),
                    a.getStatus());

        }

        TablePrinter.line();

    }

    private void searchAttendance() {

        int id = InputUtil.readInt("Attendance ID : ");

        Attendance a = controller.getAttendanceById(id);

        if (a != null) {

            TablePrinter.heading("ID", "Student ID", "Subject ID", "Faculty ID", "Date", "Status");
            System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%n",
                    a.getAttendanceId(),
                    a.getStudentId(),
                    a.getSubjectId(),
                    a.getFacultyId(),
                    a.getAttendanceDate(),
                    a.getStatus());
            TablePrinter.line();

        } else

            ConsolePrinter.error("Attendance Record Not Found.");

    }

    private void updateAttendance() {

        int id = InputUtil.readInt("Attendance ID : ");

        Attendance attendance = controller.getAttendanceById(id);

        if (attendance == null) {

            ConsolePrinter.error("Attendance Record Not Found.");

            return;

        }

        String statusStr = InputUtil.readString("New Status (PRESENT/ABSENT): ").toUpperCase();
        while (!statusStr.equals("PRESENT") && !statusStr.equals("ABSENT")) {
            ConsolePrinter.warning("Invalid Status. Please enter PRESENT or ABSENT.");
            statusStr = InputUtil.readString("New Status (PRESENT/ABSENT): ").toUpperCase();
        }
        attendance.setStatus(AttendanceStatus.valueOf(statusStr));

        if (controller.updateAttendance(attendance))

            ConsolePrinter.success("Attendance Updated Successfully.");

        else

            ConsolePrinter.error("Update Failed.");

    }

    private void deleteAttendance() {

        int id = InputUtil.readInt("Attendance ID : ");

        if (controller.deleteAttendance(id))

            ConsolePrinter.success("Deleted Successfully.");

        else

            ConsolePrinter.error("Delete Failed.");

    }

    private void attendanceByStudent() {

        int studentId = InputUtil.readInt("Student ID : ");

        List<Attendance> attendanceList =
                controller.getAttendanceByStudent(studentId);

        if (attendanceList.isEmpty()) {
            ConsolePrinter.info("No attendance records found for this student.");
            return;
        }

        TablePrinter.heading("ID", "Student ID", "Subject ID", "Faculty ID", "Date", "Status");

        for (Attendance a : attendanceList) {

            System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%n",
                    a.getAttendanceId(),
                    a.getStudentId(),
                    a.getSubjectId(),
                    a.getFacultyId(),
                    a.getAttendanceDate(),
                    a.getStatus());

        }

        TablePrinter.line();

    }

}