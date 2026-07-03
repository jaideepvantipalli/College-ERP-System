package menu;

import controller.StudentController;
import model.Student;
import util.InputUtil;
import util.ValidationUtil;
import util.ConsolePrinter;
import util.TablePrinter;

import java.time.LocalDate;
import java.util.List;

public class StudentMenu {

    private final StudentController controller;

    public StudentMenu() {

        controller = new StudentController();

    }

    public void start() {

        while (true) {

            ConsolePrinter.title("Student Management");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Students By Department");
            System.out.println("0. Back");

            int choice = InputUtil.readInt("Choice : ");

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
                    ConsolePrinter.warning("Invalid Choice.");
            }

        }

    }

    private void addStudent() {

        Student student = new Student();

        student.setRollNumber(InputUtil.readString("Roll Number : "));

        String firstName = InputUtil.readString("First Name : ");
        while (!ValidationUtil.isValidName(firstName)) {
            ConsolePrinter.warning("First Name must be at least 2 characters. Please try again.");
            firstName = InputUtil.readString("First Name : ");
        }
        student.setFirstName(firstName);

        student.setLastName(InputUtil.readString("Last Name : "));
        student.setGender(InputUtil.readString("Gender : "));
        student.setDateOfBirth(InputUtil.readDate("Date of Birth (yyyy-mm-dd): "));

        String email = InputUtil.readString("Email : ");
        while (!ValidationUtil.isValidEmail(email)) {
            ConsolePrinter.warning("Invalid Email format. Please try again.");
            email = InputUtil.readString("Email : ");
        }
        student.setEmail(email);

        String phone = InputUtil.readString("Phone : ");
        while (!ValidationUtil.isValidPhone(phone)) {
            ConsolePrinter.warning("Phone number must be 10 digits. Please try again.");
            phone = InputUtil.readString("Phone : ");
        }
        student.setPhone(phone);

        student.setDepartmentId(InputUtil.readInt("Department ID : "));
        student.setAcademicYear(InputUtil.readInt("Academic Year : "));
        student.setSection(InputUtil.readChar("Section : "));
        student.setAddress(InputUtil.readString("Address : "));
        student.setAdmissionDate(InputUtil.readDate("Admission Date (yyyy-mm-dd): "));
        student.setStatus("ACTIVE");

        if (controller.addStudent(student))

            ConsolePrinter.success("Student Added Successfully.");

        else

            ConsolePrinter.error("Failed.");

    }

    private void viewStudents() {

        List<Student> students = controller.getAllStudents();

        if (students.isEmpty()) {
            ConsolePrinter.info("No student records found.");
            return;
        }

        TablePrinter.heading("ID", "Roll Number", "Name", "Gender", "Email", "Phone", "Dept ID", "Year", "Sec", "Status");

        for (Student s : students) {

            System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%n",
                    s.getStudentId(),
                    s.getRollNumber(),
                    s.getFirstName() + " " + (s.getLastName() != null ? s.getLastName() : ""),
                    s.getGender(),
                    s.getEmail(),
                    s.getPhone(),
                    s.getDepartmentId(),
                    s.getAcademicYear(),
                    s.getSection(),
                    s.getStatus());

        }

        TablePrinter.line();

    }

    private void searchStudent() {

        int id = InputUtil.readInt("Student ID : ");

        Student s = controller.getStudentById(id);

        if (s != null) {

            TablePrinter.heading("ID", "Roll Number", "Name", "Gender", "Email", "Phone", "Dept ID", "Year", "Sec", "Status");
            System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%n",
                    s.getStudentId(),
                    s.getRollNumber(),
                    s.getFirstName() + " " + (s.getLastName() != null ? s.getLastName() : ""),
                    s.getGender(),
                    s.getEmail(),
                    s.getPhone(),
                    s.getDepartmentId(),
                    s.getAcademicYear(),
                    s.getSection(),
                    s.getStatus());
            TablePrinter.line();

        } else

            ConsolePrinter.error("Student Not Found.");

    }

    private void updateStudent() {

        int id = InputUtil.readInt("Student ID : ");

        Student student = controller.getStudentById(id);

        if (student == null) {

            ConsolePrinter.error("Student Not Found.");

            return;

        }

        String email = InputUtil.readString("New Email : ");
        while (!ValidationUtil.isValidEmail(email)) {
            ConsolePrinter.warning("Invalid Email format. Please try again.");
            email = InputUtil.readString("New Email : ");
        }
        student.setEmail(email);

        String phone = InputUtil.readString("New Phone : ");
        while (!ValidationUtil.isValidPhone(phone)) {
            ConsolePrinter.warning("Phone number must be 10 digits. Please try again.");
            phone = InputUtil.readString("New Phone : ");
        }
        student.setPhone(phone);

        student.setAddress(InputUtil.readString("New Address : "));

        if (controller.updateStudent(student))

            ConsolePrinter.success("Updated Successfully.");

        else

            ConsolePrinter.error("Update Failed.");

    }

    private void deleteStudent() {

        int id = InputUtil.readInt("Student ID : ");

        if (controller.deleteStudent(id))

            ConsolePrinter.success("Deleted Successfully.");

        else

            ConsolePrinter.error("Delete Failed.");

    }

    private void studentsByDepartment() {

        int departmentId = InputUtil.readInt("Department ID : ");

        List<Student> students =
                controller.getStudentsByDepartment(departmentId);

        if (students.isEmpty()) {
            ConsolePrinter.info("No students found in this department.");
            return;
        }

        TablePrinter.heading("ID", "Roll Number", "Name", "Gender", "Email", "Phone", "Dept ID", "Year", "Sec", "Status");

        for (Student s : students) {

            System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%n",
                    s.getStudentId(),
                    s.getRollNumber(),
                    s.getFirstName() + " " + (s.getLastName() != null ? s.getLastName() : ""),
                    s.getGender(),
                    s.getEmail(),
                    s.getPhone(),
                    s.getDepartmentId(),
                    s.getAcademicYear(),
                    s.getSection(),
                    s.getStatus());

        }

        TablePrinter.line();

    }

}