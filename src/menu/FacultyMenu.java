package menu;

import controller.FacultyController;
import model.Faculty;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class FacultyMenu {

    private final Scanner scanner;
    private final FacultyController controller;

    public FacultyMenu() {

        scanner = new Scanner(System.in);

        controller = new FacultyController();

    }

    public void start() {

        while (true) {

            System.out.println("\n================================");
            System.out.println(" FACULTY MANAGEMENT ");
            System.out.println("================================");
            System.out.println("1. Add Faculty");
            System.out.println("2. View Faculty");
            System.out.println("3. Search Faculty");
            System.out.println("4. Update Faculty");
            System.out.println("5. Delete Faculty");
            System.out.println("6. Faculty By Department");
            System.out.println("0. Back");

            System.out.print("Choice : ");

            int choice = Integer.parseInt(scanner.nextLine());

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
                    System.out.println("Invalid Choice.");
            }

        }

    }

    private void addFaculty() {

        Faculty faculty = new Faculty();

        System.out.print("Employee ID : ");
        faculty.setEmployeeId(scanner.nextLine());

        System.out.print("First Name : ");
        faculty.setFirstName(scanner.nextLine());

        System.out.print("Last Name : ");
        faculty.setLastName(scanner.nextLine());

        System.out.print("Email : ");
        faculty.setEmail(scanner.nextLine());

        System.out.print("Phone : ");
        faculty.setPhone(scanner.nextLine());

        System.out.print("Designation : ");
        faculty.setDesignation(scanner.nextLine());

        System.out.print("Department ID : ");
        faculty.setDepartmentId(Integer.parseInt(scanner.nextLine()));

        System.out.print("Joining Date (yyyy-mm-dd) : ");
        faculty.setJoiningDate(LocalDate.parse(scanner.nextLine()));

        faculty.setStatus("ACTIVE");

        if (controller.addFaculty(faculty))

            System.out.println("Faculty Added Successfully.");

        else

            System.out.println("Failed.");

    }

    private void viewFaculty() {

        List<Faculty> list = controller.getAllFaculty();

        for (Faculty faculty : list) {

            System.out.println(faculty);

        }

    }

    private void searchFaculty() {

        System.out.print("Faculty ID : ");

        int id = Integer.parseInt(scanner.nextLine());

        Faculty faculty = controller.getFacultyById(id);

        if (faculty != null)

            System.out.println(faculty);

        else

            System.out.println("Faculty Not Found.");

    }

    private void updateFaculty() {

        System.out.print("Faculty ID : ");

        int id = Integer.parseInt(scanner.nextLine());

        Faculty faculty = controller.getFacultyById(id);

        if (faculty == null) {

            System.out.println("Faculty Not Found.");

            return;

        }

        System.out.print("New Email : ");
        faculty.setEmail(scanner.nextLine());

        System.out.print("New Phone : ");
        faculty.setPhone(scanner.nextLine());

        System.out.print("New Designation : ");
        faculty.setDesignation(scanner.nextLine());

        if (controller.updateFaculty(faculty))

            System.out.println("Updated Successfully.");

        else

            System.out.println("Update Failed.");

    }

    private void deleteFaculty() {

        System.out.print("Faculty ID : ");

        int id = Integer.parseInt(scanner.nextLine());

        if (controller.deleteFaculty(id))

            System.out.println("Deleted Successfully.");

        else

            System.out.println("Delete Failed.");

    }

    private void facultyByDepartment() {

        System.out.print("Department ID : ");

        int departmentId = Integer.parseInt(scanner.nextLine());

        List<Faculty> list =
                controller.getFacultyByDepartment(departmentId);

        for (Faculty faculty : list) {

            System.out.println(faculty);

        }

    }

}