package menu;

import controller.StudentController;
import model.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class StudentMenu {

    private final Scanner scanner;
    private final StudentController controller;

    public StudentMenu() {

        scanner = new Scanner(System.in);
        controller = new StudentController();

    }

    public void start() {

        while (true) {

            System.out.println("\n==================================");
            System.out.println(" STUDENT MANAGEMENT ");
            System.out.println("==================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Students By Department");
            System.out.println("0. Back");

            System.out.print("Choice : ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    studentsByDepartment();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid Choice.");
            }

        }

    }

    private void addStudent() {

        Student student = new Student();

        System.out.print("Roll Number : ");
        student.setRollNumber(scanner.nextLine());

        System.out.print("First Name : ");
        student.setFirstName(scanner.nextLine());

        System.out.print("Last Name : ");
        student.setLastName(scanner.nextLine());

        System.out.print("Gender : ");
        student.setGender(scanner.nextLine());

        System.out.print("Date of Birth (yyyy-mm-dd): ");
        student.setDateOfBirth(LocalDate.parse(scanner.nextLine()));

        System.out.print("Email : ");
        student.setEmail(scanner.nextLine());

        System.out.print("Phone : ");
        student.setPhone(scanner.nextLine());

        System.out.print("Department ID : ");
        student.setDepartmentId(Integer.parseInt(scanner.nextLine()));

        System.out.print("Academic Year : ");
        student.setAcademicYear(Integer.parseInt(scanner.nextLine()));

        System.out.print("Section : ");
        student.setSection(scanner.nextLine().charAt(0));

        System.out.print("Address : ");
        student.setAddress(scanner.nextLine());

        System.out.print("Admission Date (yyyy-mm-dd): ");
        student.setAdmissionDate(LocalDate.parse(scanner.nextLine()));

        student.setStatus("ACTIVE");

        if (controller.addStudent(student))

            System.out.println("Student Added Successfully.");

        else

            System.out.println("Failed.");

    }

    private void viewStudents() {

        List<Student> students = controller.getAllStudents();

        for (Student student : students) {

            System.out.println(student);

        }

    }

    private void searchStudent() {

        System.out.print("Student ID : ");

        int id = Integer.parseInt(scanner.nextLine());

        Student student = controller.getStudentById(id);

        if (student != null)

            System.out.println(student);

        else

            System.out.println("Student Not Found.");

    }

    private void updateStudent() {

        System.out.print("Student ID : ");

        int id = Integer.parseInt(scanner.nextLine());

        Student student = controller.getStudentById(id);

        if (student == null) {

            System.out.println("Student Not Found.");

            return;

        }

        System.out.print("New Email : ");
        student.setEmail(scanner.nextLine());

        System.out.print("New Phone : ");
        student.setPhone(scanner.nextLine());

        System.out.print("New Address : ");
        student.setAddress(scanner.nextLine());

        if (controller.updateStudent(student))

            System.out.println("Updated Successfully.");

        else

            System.out.println("Update Failed.");

    }

    private void deleteStudent() {

        System.out.print("Student ID : ");

        int id = Integer.parseInt(scanner.nextLine());

        if (controller.deleteStudent(id))

            System.out.println("Deleted Successfully.");

        else

            System.out.println("Delete Failed.");

    }

    private void studentsByDepartment() {

        System.out.print("Department ID : ");

        int departmentId = Integer.parseInt(scanner.nextLine());

        List<Student> students =
                controller.getStudentsByDepartment(departmentId);

        for (Student student : students) {

            System.out.println(student);

        }

    }

}