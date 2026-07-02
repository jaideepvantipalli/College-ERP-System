package menu;

import controller.DepartmentController;
import java.util.List;
import java.util.Scanner;
import model.Department;

public class DepartmentMenu {

    private final Scanner scanner;
    private final DepartmentController controller;

    public DepartmentMenu() {

        scanner = new Scanner(System.in);

        controller = new DepartmentController();

    }

    public void start() {

        while (true) {

            System.out.println("\n===============================");
            System.out.println(" Department Management ");
            System.out.println("===============================");
            System.out.println("1. Add Department");
            System.out.println("2. View Departments");
            System.out.println("3. Search Department");
            System.out.println("4. Update Department");
            System.out.println("5. Delete Department");
            System.out.println("0. Back");
            System.out.print("Enter Choice : ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    addDepartment();
                    break;

                case 2:
                    viewDepartments();
                    break;

                case 3:
                    searchDepartment();
                    break;

                case 4:
                    updateDepartment();
                    break;

                case 5:
                    deleteDepartment();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid Choice");
            }

        }

    }

    // -----------------------------
    // Add Department
    // -----------------------------

    private void addDepartment() {

        Department department = new Department();

        System.out.print("Department Name : ");
        department.setDepartmentName(scanner.nextLine());

        System.out.print("Department Code : ");
        department.setDepartmentCode(scanner.nextLine());

        System.out.print("HOD Name : ");
        department.setHodName(scanner.nextLine());

        department.setStatus("ACTIVE");

        if (controller.addDepartment(department))

            System.out.println("Department Added Successfully.");

        else

            System.out.println("Failed.");

    }

    // -----------------------------
    // View All
    // -----------------------------

    private void viewDepartments() {

        List<Department> list =
                controller.getAllDepartments();

        System.out.println();

        for (Department department : list) {

            System.out.println(department);

        }

    }

    // -----------------------------
    // Search
    // -----------------------------

    private void searchDepartment() {

        System.out.print("Department ID : ");

        int id = Integer.parseInt(scanner.nextLine());

        Department department =
                controller.getDepartmentById(id);

        if (department != null)

            System.out.println(department);

        else

            System.out.println("Department Not Found.");

    }

    // -----------------------------
    // Update
    // -----------------------------

    private void updateDepartment() {

        System.out.print("Department ID : ");

        int id = Integer.parseInt(scanner.nextLine());

        Department department =
                controller.getDepartmentById(id);

        if (department == null) {

            System.out.println("Department Not Found.");

            return;

        }

        System.out.print("New Department Name : ");

        department.setDepartmentName(scanner.nextLine());

        System.out.print("New Department Code : ");

        department.setDepartmentCode(scanner.nextLine());

        System.out.print("New HOD : ");

        department.setHodName(scanner.nextLine());

        System.out.print("Status : ");

        department.setStatus(scanner.nextLine());

        if (controller.updateDepartment(department))

            System.out.println("Updated Successfully.");

        else

            System.out.println("Update Failed.");

    }

    // -----------------------------
    // Delete
    // -----------------------------

    private void deleteDepartment() {

        System.out.print("Department ID : ");

        int id = Integer.parseInt(scanner.nextLine());

        if (controller.deleteDepartment(id))

            System.out.println("Deleted Successfully.");

        else

            System.out.println("Delete Failed.");

    }

}