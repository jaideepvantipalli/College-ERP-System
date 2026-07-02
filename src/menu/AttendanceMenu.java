package menu;

import controller.AttendanceController;
import enums.AttendanceStatus;
import model.Attendance;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AttendanceMenu {

    private final Scanner scanner;
    private final AttendanceController controller;

    public AttendanceMenu() {

        scanner = new Scanner(System.in);
        controller = new AttendanceController();

    }

    public void start() {

        while (true) {

            System.out.println("\n================================");
            System.out.println(" ATTENDANCE MANAGEMENT ");
            System.out.println("================================");
            System.out.println("1. Add Attendance");
            System.out.println("2. View Attendance");
            System.out.println("3. Search Attendance");
            System.out.println("4. Update Attendance");
            System.out.println("5. Delete Attendance");
            System.out.println("6. Attendance By Student");
            System.out.println("0. Back");

            System.out.print("Choice : ");

            int choice = Integer.parseInt(scanner.nextLine());

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
                    System.out.println("Invalid Choice.");

            }

        }

    }

    private void addAttendance() {

        Attendance attendance = new Attendance();

        System.out.print("Student ID : ");
        attendance.setStudentId(Integer.parseInt(scanner.nextLine()));

        System.out.print("Subject ID : ");
        attendance.setSubjectId(Integer.parseInt(scanner.nextLine()));

        System.out.print("Faculty ID : ");
        attendance.setFacultyId(Integer.parseInt(scanner.nextLine()));

        System.out.print("Attendance Date (yyyy-mm-dd): ");
        attendance.setAttendanceDate(LocalDate.parse(scanner.nextLine()));

        System.out.print("Status (PRESENT/ABSENT): ");
        attendance.setStatus(
                AttendanceStatus.valueOf(scanner.nextLine().toUpperCase()));

        if (controller.addAttendance(attendance))

            System.out.println("Attendance Added Successfully.");

        else

            System.out.println("Failed.");

    }

    private void viewAttendance() {

        List<Attendance> attendanceList =
                controller.getAllAttendance();

        for (Attendance attendance : attendanceList) {

            System.out.println(attendance);

        }

    }

    private void searchAttendance() {

        System.out.print("Attendance ID : ");

        int id = Integer.parseInt(scanner.nextLine());

        Attendance attendance =
                controller.getAttendanceById(id);

        if (attendance != null)

            System.out.println(attendance);

        else

            System.out.println("Attendance Record Not Found.");

    }

    private void updateAttendance() {

        System.out.print("Attendance ID : ");

        int id = Integer.parseInt(scanner.nextLine());

        Attendance attendance =
                controller.getAttendanceById(id);

        if (attendance == null) {

            System.out.println("Attendance Record Not Found.");

            return;

        }

        System.out.print("New Status (PRESENT/ABSENT): ");

        attendance.setStatus(
                AttendanceStatus.valueOf(scanner.nextLine().toUpperCase()));

        if (controller.updateAttendance(attendance))

            System.out.println("Attendance Updated Successfully.");

        else

            System.out.println("Update Failed.");

    }

    private void deleteAttendance() {

        System.out.print("Attendance ID : ");

        int id = Integer.parseInt(scanner.nextLine());

        if (controller.deleteAttendance(id))

            System.out.println("Deleted Successfully.");

        else

            System.out.println("Delete Failed.");

    }

    private void attendanceByStudent() {

        System.out.print("Student ID : ");

        int studentId = Integer.parseInt(scanner.nextLine());

        List<Attendance> attendanceList =
                controller.getAttendanceByStudent(studentId);

        for (Attendance attendance : attendanceList) {

            System.out.println(attendance);

        }

    }

}