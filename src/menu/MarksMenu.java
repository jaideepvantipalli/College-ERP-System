package menu;

import controller.MarksController;
import java.util.List;
import java.util.Scanner;
import model.Marks;

public class MarksMenu {

    private final Scanner scanner;
    private final MarksController controller;

    public MarksMenu() {

        scanner = new Scanner(System.in);
        controller = new MarksController();

    }

    public void start() {

        while (true) {

            System.out.println("\n================================");
            System.out.println(" MARKS MANAGEMENT ");
            System.out.println("================================");
            System.out.println("1. Add Marks");
            System.out.println("2. View Marks");
            System.out.println("3. Search Marks");
            System.out.println("4. Update Marks");
            System.out.println("5. Delete Marks");
            System.out.println("6. Marks By Student");
            System.out.println("0. Back");

            System.out.print("Choice : ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    addMarks();
                    break;

                case 2:
                    viewMarks();
                    break;

                case 3:
                    searchMarks();
                    break;

                case 4:
                    updateMarks();
                    break;

                case 5:
                    deleteMarks();
                    break;

                case 6:
                    marksByStudent();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid Choice.");

            }

        }

    }

    private void addMarks() {

        Marks marks = new Marks();

        System.out.print("Student ID : ");
        marks.setStudentId(Integer.parseInt(scanner.nextLine()));

        System.out.print("Subject ID : ");
        marks.setSubjectId(Integer.parseInt(scanner.nextLine()));

        System.out.print("Internal 1 : ");
        marks.setInternal1(Double.parseDouble(scanner.nextLine()));

        System.out.print("Internal 2 : ");
        marks.setInternal2(Double.parseDouble(scanner.nextLine()));

        System.out.print("Assignment : ");
        marks.setAssignment(Double.parseDouble(scanner.nextLine()));

        System.out.print("Semester Exam : ");
        marks.setSemesterExam(Double.parseDouble(scanner.nextLine()));

        double total =
                marks.getInternal1()
                + marks.getInternal2()
                + marks.getAssignment()
                + marks.getSemesterExam();

        marks.setTotal(total);

        String grade;

        if (total >= 90)
            grade = "A";
        else if (total >= 80)
            grade = "B";
        else if (total >= 70)
            grade = "C";
        else if (total >= 60)
            grade = "D";
        else
            grade = "F";

        marks.setGrade(grade);

        if (controller.addMarks(marks))

            System.out.println("Marks Added Successfully.");

        else

            System.out.println("Failed.");

    }

    private void viewMarks() {

        List<Marks> marksList =
                controller.getAllMarks();

        for (Marks marks : marksList) {

            System.out.println(marks);

        }

    }

    private void searchMarks() {

        System.out.print("Mark ID : ");

        int id = Integer.parseInt(scanner.nextLine());

        Marks marks =
                controller.getMarksById(id);

        if (marks != null)

            System.out.println(marks);

        else

            System.out.println("Marks Not Found.");

    }

    private void updateMarks() {

        System.out.print("Mark ID : ");

        int id = Integer.parseInt(scanner.nextLine());

        Marks marks =
                controller.getMarksById(id);

        if (marks == null) {

            System.out.println("Marks Not Found.");

            return;

        }

        System.out.print("Internal 1 : ");
        marks.setInternal1(Double.parseDouble(scanner.nextLine()));

        System.out.print("Internal 2 : ");
        marks.setInternal2(Double.parseDouble(scanner.nextLine()));

        System.out.print("Assignment : ");
        marks.setAssignment(Double.parseDouble(scanner.nextLine()));

        System.out.print("Semester Exam : ");
        marks.setSemesterExam(Double.parseDouble(scanner.nextLine()));

        double total =
                marks.getInternal1()
                + marks.getInternal2()
                + marks.getAssignment()
                + marks.getSemesterExam();

        marks.setTotal(total);

        String grade;

        if (total >= 90)
            grade = "A";
        else if (total >= 80)
            grade = "B";
        else if (total >= 70)
            grade = "C";
        else if (total >= 60)
            grade = "D";
        else
            grade = "F";

        marks.setGrade(grade);

        if (controller.updateMarks(marks))

            System.out.println("Updated Successfully.");

        else

            System.out.println("Update Failed.");

    }

    private void deleteMarks() {

        System.out.print("Mark ID : ");

        int id = Integer.parseInt(scanner.nextLine());

        if (controller.deleteMarks(id))

            System.out.println("Deleted Successfully.");

        else

            System.out.println("Delete Failed.");

    }

    private void marksByStudent() {

        System.out.print("Student ID : ");

        int studentId =
                Integer.parseInt(scanner.nextLine());

        List<Marks> marksList =
                controller.getMarksByStudent(studentId);

        for (Marks marks : marksList) {

            System.out.println(marks);

        }

    }

}