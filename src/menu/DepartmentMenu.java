package menu;

import controller.DepartmentController;
import java.util.List;
import model.Department;
import util.InputUtil;
import util.ConsolePrinter;
import util.TablePrinter;

public class DepartmentMenu {

    private final DepartmentController controller;

    public DepartmentMenu() {

        controller = new DepartmentController();

    }

    public void start() {

        while (true) {

            ConsolePrinter.title("Department Management");
            System.out.println("1. Add Department");
            System.out.println("2. View Departments");
            System.out.println("3. Search Department");
            System.out.println("4. Update Department");
            System.out.println("5. Delete Department");
            System.out.println("0. Back");

            int choice = InputUtil.readInt("Enter Choice : ");

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
                    ConsolePrinter.warning("Invalid Choice");
            }

        }

    }

    private void addDepartment() {

        Department department = new Department();

        department.setDepartmentName(InputUtil.readString("Department Name : "));
        department.setDepartmentCode(InputUtil.readString("Department Code : "));
        department.setHodName(InputUtil.readString("HOD Name : "));
        department.setStatus("ACTIVE");

        if (controller.addDepartment(department))

            ConsolePrinter.success("Department Added Successfully.");

        else

            ConsolePrinter.error("Failed.");

    }

    private void viewDepartments() {

        List<Department> list = controller.getAllDepartments();

        if (list.isEmpty()) {
            ConsolePrinter.info("No department records found.");
            return;
        }

        TablePrinter.heading("ID", "Code", "Name", "HOD", "Status");

        for (Department d : list) {

            System.out.printf("%-18s%-18s%-18s%-18s%-18s%n",
                    d.getDepartmentId(),
                    d.getDepartmentCode(),
                    d.getDepartmentName(),
                    d.getHodName() != null ? d.getHodName() : "N/A",
                    d.getStatus());

        }

        TablePrinter.line();

    }

    private void searchDepartment() {

        int id = InputUtil.readInt("Department ID : ");

        Department d = controller.getDepartmentById(id);

        if (d != null) {

            TablePrinter.heading("ID", "Code", "Name", "HOD", "Status");
            System.out.printf("%-18s%-18s%-18s%-18s%-18s%n",
                    d.getDepartmentId(),
                    d.getDepartmentCode(),
                    d.getDepartmentName(),
                    d.getHodName() != null ? d.getHodName() : "N/A",
                    d.getStatus());
            TablePrinter.line();

        } else

            ConsolePrinter.error("Department Not Found.");

    }

    private void updateDepartment() {

        int id = InputUtil.readInt("Department ID : ");

        Department department = controller.getDepartmentById(id);

        if (department == null) {

            ConsolePrinter.error("Department Not Found.");

            return;

        }

        department.setDepartmentName(InputUtil.readString("New Department Name : "));
        department.setDepartmentCode(InputUtil.readString("New Department Code : "));
        department.setHodName(InputUtil.readString("New HOD : "));
        department.setStatus(InputUtil.readString("Status : "));

        if (controller.updateDepartment(department))

            ConsolePrinter.success("Updated Successfully.");

        else

            ConsolePrinter.error("Update Failed.");

    }

    private void deleteDepartment() {

        int id = InputUtil.readInt("Department ID : ");

        if (controller.deleteDepartment(id))

            ConsolePrinter.success("Deleted Successfully.");

        else

            ConsolePrinter.error("Delete Failed.");

    }

}