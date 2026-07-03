package menu;

import controller.MarksController;
import java.util.List;
import model.Marks;
import util.InputUtil;
import util.ConsolePrinter;
import util.TablePrinter;

public class MarksMenu {

    private final MarksController controller;

    public MarksMenu() {

        controller = new MarksController();

    }

    public void start() {

        while (true) {

            ConsolePrinter.title("Marks Management");
            System.out.println("1. Add Marks");
            System.out.println("2. View Marks");
            System.out.println("3. Search Marks");
            System.out.println("4. Update Marks");
            System.out.println("5. Delete Marks");
            System.out.println("6. Marks By Student");
            System.out.println("0. Back");

            int choice = InputUtil.readInt("Choice : ");

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
                    ConsolePrinter.warning("Invalid Choice.");

            }

        }

    }

    private void addMarks() {

        Marks marks = new Marks();

        marks.setStudentId(InputUtil.readInt("Student ID : "));
        marks.setSubjectId(InputUtil.readInt("Subject ID : "));
        marks.setInternal1(InputUtil.readDouble("Internal 1 : "));
        marks.setInternal2(InputUtil.readDouble("Internal 2 : "));
        marks.setAssignment(InputUtil.readDouble("Assignment : "));
        marks.setSemesterExam(InputUtil.readDouble("Semester Exam : "));

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

            ConsolePrinter.success("Marks Added Successfully.");

        else

            ConsolePrinter.error("Failed.");

    }

    private void viewMarks() {

        List<Marks> marksList = controller.getAllMarks();

        if (marksList.isEmpty()) {
            ConsolePrinter.info("No marks records found.");
            return;
        }

        TablePrinter.heading("ID", "Student ID", "Subject ID", "Internal 1", "Internal 2", "Assignment", "Sem Exam", "Total", "Grade");

        for (Marks m : marksList) {

            System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%n",
                    m.getMarkId(),
                    m.getStudentId(),
                    m.getSubjectId(),
                    m.getInternal1(),
                    m.getInternal2(),
                    m.getAssignment(),
                    m.getSemesterExam(),
                    m.getTotal(),
                    m.getGrade());

        }

        TablePrinter.line();

    }

    private void searchMarks() {

        int id = InputUtil.readInt("Mark ID : ");

        Marks m = controller.getMarksById(id);

        if (m != null) {

            TablePrinter.heading("ID", "Student ID", "Subject ID", "Internal 1", "Internal 2", "Assignment", "Sem Exam", "Total", "Grade");
            System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%n",
                    m.getMarkId(),
                    m.getStudentId(),
                    m.getSubjectId(),
                    m.getInternal1(),
                    m.getInternal2(),
                    m.getAssignment(),
                    m.getSemesterExam(),
                    m.getTotal(),
                    m.getGrade());
            TablePrinter.line();

        } else

            ConsolePrinter.error("Marks Not Found.");

    }

    private void updateMarks() {

        int id = InputUtil.readInt("Mark ID : ");

        Marks marks = controller.getMarksById(id);

        if (marks == null) {

            ConsolePrinter.error("Marks Not Found.");

            return;

        }

        marks.setInternal1(InputUtil.readDouble("Internal 1 : "));
        marks.setInternal2(InputUtil.readDouble("Internal 2 : "));
        marks.setAssignment(InputUtil.readDouble("Assignment : "));
        marks.setSemesterExam(InputUtil.readDouble("Semester Exam : "));

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

            ConsolePrinter.success("Updated Successfully.");

        else

            ConsolePrinter.error("Update Failed.");

    }

    private void deleteMarks() {

        int id = InputUtil.readInt("Mark ID : ");

        if (controller.deleteMarks(id))

            ConsolePrinter.success("Deleted Successfully.");

        else

            ConsolePrinter.error("Delete Failed.");

    }

    private void marksByStudent() {

        int studentId = InputUtil.readInt("Student ID : ");

        List<Marks> marksList = controller.getMarksByStudent(studentId);

        if (marksList.isEmpty()) {
            ConsolePrinter.info("No marks records found for this student.");
            return;
        }

        TablePrinter.heading("ID", "Student ID", "Subject ID", "Internal 1", "Internal 2", "Assignment", "Sem Exam", "Total", "Grade");

        for (Marks m : marksList) {

            System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%n",
                    m.getMarkId(),
                    m.getStudentId(),
                    m.getSubjectId(),
                    m.getInternal1(),
                    m.getInternal2(),
                    m.getAssignment(),
                    m.getSemesterExam(),
                    m.getTotal(),
                    m.getGrade());

        }

        TablePrinter.line();

    }

}