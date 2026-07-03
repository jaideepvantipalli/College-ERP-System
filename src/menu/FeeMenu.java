package menu;

import controller.FeeController;
import enums.FeeStatus;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import model.Fee;

public class FeeMenu {

    private final Scanner scanner;
    private final FeeController controller;

    public FeeMenu() {

        scanner = new Scanner(System.in);
        controller = new FeeController();

    }

    public void start() {

        while (true) {

            System.out.println("\n================================");
            System.out.println(" FEE MANAGEMENT ");
            System.out.println("================================");
            System.out.println("1. Add Fee");
            System.out.println("2. View Fees");
            System.out.println("3. Search Fee");
            System.out.println("4. Update Fee");
            System.out.println("5. Delete Fee");
            System.out.println("6. Fee By Student");
            System.out.println("0. Back");

            System.out.print("Choice : ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    addFee();
                    break;

                case 2:
                    viewFees();
                    break;

                case 3:
                    searchFee();
                    break;

                case 4:
                    updateFee();
                    break;

                case 5:
                    deleteFee();
                    break;

                case 6:
                    feeByStudent();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid Choice.");

            }

        }

    }

    private void addFee() {

        Fee fee = new Fee();

        System.out.print("Student ID : ");
        fee.setStudentId(Integer.parseInt(scanner.nextLine()));

        System.out.print("Total Fee : ");
        fee.setTotalFee(Double.parseDouble(scanner.nextLine()));

        System.out.print("Paid Fee : ");
        fee.setPaidFee(Double.parseDouble(scanner.nextLine()));

        fee.setBalance(fee.getTotalFee() - fee.getPaidFee());

        fee.setPaymentDate(LocalDate.now());

        if (fee.getBalance() == 0) {

            fee.setStatus(FeeStatus.PAID);

        } else if (fee.getPaidFee() > 0) {

            fee.setStatus(FeeStatus.PARTIAL);

        } else {

            fee.setStatus(FeeStatus.PENDING);

        }

        if (controller.addFee(fee))

            System.out.println("Fee Record Added Successfully.");

        else

            System.out.println("Failed.");

    }

    private void viewFees() {

        List<Fee> fees = controller.getAllFees();

        for (Fee fee : fees) {

            System.out.println(fee);

        }

    }

    private void searchFee() {

        System.out.print("Fee ID : ");

        int id = Integer.parseInt(scanner.nextLine());

        Fee fee = controller.getFeeById(id);

        if (fee != null)

            System.out.println(fee);

        else

            System.out.println("Fee Record Not Found.");

    }

    private void updateFee() {

        System.out.print("Fee ID : ");

        int id = Integer.parseInt(scanner.nextLine());

        Fee fee = controller.getFeeById(id);

        if (fee == null) {

            System.out.println("Fee Record Not Found.");

            return;

        }

        System.out.print("Paid Fee : ");

        fee.setPaidFee(Double.parseDouble(scanner.nextLine()));

        fee.setBalance(fee.getTotalFee() - fee.getPaidFee());

        if (fee.getBalance() == 0) {

            fee.setStatus(FeeStatus.PAID);

        } else if (fee.getPaidFee() > 0) {

            fee.setStatus(FeeStatus.PARTIAL);

        } else {

            fee.setStatus(FeeStatus.PENDING);

        }

        fee.setPaymentDate(LocalDate.now());

        if (controller.updateFee(fee))

            System.out.println("Updated Successfully.");

        else

            System.out.println("Update Failed.");

    }

    private void deleteFee() {

        System.out.print("Fee ID : ");

        int id = Integer.parseInt(scanner.nextLine());

        if (controller.deleteFee(id))

            System.out.println("Deleted Successfully.");

        else

            System.out.println("Delete Failed.");

    }

    private void feeByStudent() {

        System.out.print("Student ID : ");

        int studentId = Integer.parseInt(scanner.nextLine());

        List<Fee> fees = controller.getFeeByStudent(studentId);

        for (Fee fee : fees) {

            System.out.println(fee);

        }

    }

}