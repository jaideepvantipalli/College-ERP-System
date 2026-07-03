package menu;

import controller.FacultyController;
import model.Faculty;
import util.InputUtil;
import util.ValidationUtil;
import util.ConsolePrinter;
import util.TablePrinter;

import java.time.LocalDate;
import java.util.List;

public class FacultyMenu {

    private final FacultyController controller;

    public FacultyMenu() {

        controller = new FacultyController();

    }

    public void start() {

        while (true) {

            ConsolePrinter.title("Faculty Management");
            System.out.println("1. Add Faculty");
            System.out.println("2. View Faculty");
            System.out.println("3. Search Faculty");
            System.out.println("4. Update Faculty");
            System.out.println("5. Delete Faculty");
            System.out.println("6. Faculty By Department");
            System.out.println("0. Back");

            int choice = InputUtil.readInt("Choice : ");

            switch (choice) {

                case 1:
                    addFaculty();
                    break;

                case 2:
                    viewFaculty();
                    break;

                case 3:
                    searchFaculty();
                    break;

                case 4:
                    updateFaculty();
                    break;

                case 5:
                    deleteFaculty();
                    break;

                case 6:
                    facultyByDepartment();
                    break;

                case 0:
                    return;

                default:
                    ConsolePrinter.warning("Invalid Choice.");
            }

        }

    }

    private void addFaculty() {

        Faculty faculty = new Faculty();

        faculty.setEmployeeId(InputUtil.readString("Employee ID : "));

        String firstName = InputUtil.readString("First Name : ");
        while (!ValidationUtil.isValidName(firstName)) {
            ConsolePrinter.warning("First Name must be at least 2 characters. Please try again.");
            firstName = InputUtil.readString("First Name : ");
        }
        faculty.setFirstName(firstName);

        faculty.setLastName(InputUtil.readString("Last Name : "));

        String email = InputUtil.readString("Email : ");
        while (!ValidationUtil.isValidEmail(email)) {
            ConsolePrinter.warning("Invalid Email format. Please try again.");
            email = InputUtil.readString("Email : ");
        }
        faculty.setEmail(email);

        String phone = InputUtil.readString("Phone : ");
        while (!ValidationUtil.isValidPhone(phone)) {
            ConsolePrinter.warning("Phone number must be 10 digits. Please try again.");
            phone = InputUtil.readString("Phone : ");
        }
        faculty.setPhone(phone);

        faculty.setDesignation(InputUtil.readString("Designation : "));
        faculty.setDepartmentId(InputUtil.readInt("Department ID : "));
        faculty.setJoiningDate(InputUtil.readDate("Joining Date (yyyy-mm-dd) : "));
        faculty.setStatus("ACTIVE");

        if (controller.addFaculty(faculty))

            ConsolePrinter.success("Faculty Added Successfully.");

        else

            ConsolePrinter.error("Failed.");

    }

    private void viewFaculty() {

        List<Faculty> list = controller.getAllFaculty();

        if (list.isEmpty()) {
            ConsolePrinter.info("No faculty records found.");
            return;
        }

        TablePrinter.heading("ID", "Employee ID", "Name", "Email", "Phone", "Designation", "Dept ID", "Joining Date", "Status");

        for (Faculty f : list) {

            System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%n",
                    f.getFacultyId(),
                    f.getEmployeeId(),
                    f.getFirstName() + " " + (f.getLastName() != null ? f.getLastName() : ""),
                    f.getEmail(),
                    f.getPhone(),
                    f.getDesignation(),
                    f.getDepartmentId(),
                    f.getJoiningDate(),
                    f.getStatus());

        }

        TablePrinter.line();

    }

    private void searchFaculty() {

        int id = InputUtil.readInt("Faculty ID : ");

        Faculty f = controller.getFacultyById(id);

        if (f != null) {

            TablePrinter.heading("ID", "Employee ID", "Name", "Email", "Phone", "Designation", "Dept ID", "Joining Date", "Status");
            System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%n",
                    f.getFacultyId(),
                    f.getEmployeeId(),
                    f.getFirstName() + " " + (f.getLastName() != null ? f.getLastName() : ""),
                    f.getEmail(),
                    f.getPhone(),
                    f.getDesignation(),
                    f.getDepartmentId(),
                    f.getJoiningDate(),
                    f.getStatus());
            TablePrinter.line();

        } else

            ConsolePrinter.error("Faculty Not Found.");

    }

    private void updateFaculty() {

        int id = InputUtil.readInt("Faculty ID : ");

        Faculty faculty = controller.getFacultyById(id);

        if (faculty == null) {

            ConsolePrinter.error("Faculty Not Found.");

            return;

        }

        String email = InputUtil.readString("New Email : ");
        while (!ValidationUtil.isValidEmail(email)) {
            ConsolePrinter.warning("Invalid Email format. Please try again.");
            email = InputUtil.readString("New Email : ");
        }
        faculty.setEmail(email);

        String phone = InputUtil.readString("New Phone : ");
        while (!ValidationUtil.isValidPhone(phone)) {
            ConsolePrinter.warning("Phone number must be 10 digits. Please try again.");
            phone = InputUtil.readString("New Phone : ");
        }
        faculty.setPhone(phone);

        faculty.setDesignation(InputUtil.readString("New Designation : "));

        if (controller.updateFaculty(faculty))

            ConsolePrinter.success("Updated Successfully.");

        else

            ConsolePrinter.error("Update Failed.");

    }

    private void deleteFaculty() {

        int id = InputUtil.readInt("Faculty ID : ");

        if (controller.deleteFaculty(id))

            ConsolePrinter.success("Deleted Successfully.");

        else

            ConsolePrinter.error("Delete Failed.");

    }

    private void facultyByDepartment() {

        int departmentId = InputUtil.readInt("Department ID : ");

        List<Faculty> list =
                controller.getFacultyByDepartment(departmentId);

        if (list.isEmpty()) {
            ConsolePrinter.info("No faculty found in this department.");
            return;
        }

        TablePrinter.heading("ID", "Employee ID", "Name", "Email", "Phone", "Designation", "Dept ID", "Joining Date", "Status");

        for (Faculty f : list) {

            System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%n",
                    f.getFacultyId(),
                    f.getEmployeeId(),
                    f.getFirstName() + " " + (f.getLastName() != null ? f.getLastName() : ""),
                    f.getEmail(),
                    f.getPhone(),
                    f.getDesignation(),
                    f.getDepartmentId(),
                    f.getJoiningDate(),
                    f.getStatus());

        }

        TablePrinter.line();

    }

}