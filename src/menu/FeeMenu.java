package menu;

import controller.FeeController;
import enums.FeeStatus;
import java.time.LocalDate;
import java.util.List;
import model.Fee;
import util.InputUtil;
import util.ConsolePrinter;
import util.TablePrinter;

public class FeeMenu {

    private final FeeController controller;

    public FeeMenu() {

        controller = new FeeController();

    }

    public void start() {

        while (true) {

            ConsolePrinter.title("Fee Management");
            System.out.println("1. Add Fee");
            System.out.println("2. View Fees");
            System.out.println("3. Search Fee");
            System.out.println("4. Update Fee");
            System.out.println("5. Delete Fee");
            System.out.println("6. Fee By Student");
            System.out.println("0. Back");

            int choice = InputUtil.readInt("Choice : ");

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
                    ConsolePrinter.warning("Invalid Choice.");

            }

        }

    }

    private void addFee() {

        Fee fee = new Fee();

        fee.setStudentId(InputUtil.readInt("Student ID : "));
        fee.setTotalFee(InputUtil.readDouble("Total Fee : "));
        fee.setPaidFee(InputUtil.readDouble("Paid Fee : "));

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

            ConsolePrinter.success("Fee Record Added Successfully.");

        else

            ConsolePrinter.error("Failed.");

    }

    private void viewFees() {

        List<Fee> fees = controller.getAllFees();

        if (fees.isEmpty()) {
            ConsolePrinter.info("No fee records found.");
            return;
        }

        TablePrinter.heading("ID", "Student ID", "Total Fee", "Paid Fee", "Balance", "Payment Date", "Status");

        for (Fee f : fees) {

            System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%-18s%n",
                    f.getFeeId(),
                    f.getStudentId(),
                    f.getTotalFee(),
                    f.getPaidFee(),
                    f.getBalance(),
                    f.getPaymentDate() != null ? f.getPaymentDate() : "N/A",
                    f.getStatus());

        }

        TablePrinter.line();

    }

    private void searchFee() {

        int id = InputUtil.readInt("Fee ID : ");

        Fee f = controller.getFeeById(id);

        if (f != null) {

            TablePrinter.heading("ID", "Student ID", "Total Fee", "Paid Fee", "Balance", "Payment Date", "Status");
            System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%-18s%n",
                    f.getFeeId(),
                    f.getStudentId(),
                    f.getTotalFee(),
                    f.getPaidFee(),
                    f.getBalance(),
                    f.getPaymentDate() != null ? f.getPaymentDate() : "N/A",
                    f.getStatus());
            TablePrinter.line();

        } else

            ConsolePrinter.error("Fee Record Not Found.");

    }

    private void updateFee() {

        int id = InputUtil.readInt("Fee ID : ");

        Fee fee = controller.getFeeById(id);

        if (fee == null) {

            ConsolePrinter.error("Fee Record Not Found.");

            return;

        }

        fee.setPaidFee(InputUtil.readDouble("Paid Fee : "));

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

            ConsolePrinter.success("Updated Successfully.");

        else

            ConsolePrinter.error("Update Failed.");

    }

    private void deleteFee() {

        int id = InputUtil.readInt("Fee ID : ");

        if (controller.deleteFee(id))

            ConsolePrinter.success("Deleted Successfully.");

        else

            ConsolePrinter.error("Delete Failed.");

    }

    private void feeByStudent() {

        int studentId = InputUtil.readInt("Student ID : ");

        List<Fee> fees = controller.getFeeByStudent(studentId);

        if (fees.isEmpty()) {
            ConsolePrinter.info("No fee records found for this student.");
            return;
        }

        TablePrinter.heading("ID", "Student ID", "Total Fee", "Paid Fee", "Balance", "Payment Date", "Status");

        for (Fee f : fees) {

            System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%-18s%n",
                    f.getFeeId(),
                    f.getStudentId(),
                    f.getTotalFee(),
                    f.getPaidFee(),
                    f.getBalance(),
                    f.getPaymentDate() != null ? f.getPaymentDate() : "N/A",
                    f.getStatus());

        }

        TablePrinter.line();

    }

}