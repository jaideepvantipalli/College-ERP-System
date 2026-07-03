package menu;

import controller.SubjectController;
import model.Subject;
import util.InputUtil;
import util.ConsolePrinter;
import util.TablePrinter;

import java.util.List;

public class SubjectMenu {

    private final SubjectController controller;

    public SubjectMenu() {

        controller = new SubjectController();

    }

    public void start() {

        while (true) {

            ConsolePrinter.title("Subject Management");
            System.out.println("1. Add Subject");
            System.out.println("2. View Subjects");
            System.out.println("3. Search Subject");
            System.out.println("4. Update Subject");
            System.out.println("5. Delete Subject");
            System.out.println("6. Subjects By Department");
            System.out.println("7. Subjects By Faculty");
            System.out.println("0. Back");

            int choice = InputUtil.readInt("Choice : ");

            switch (choice) {

                case 1:
                    addSubject();
                    break;

                case 2:
                    viewSubjects();
                    break;

                case 3:
                    searchSubject();
                    break;

                case 4:
                    updateSubject();
                    break;

                case 5:
                    deleteSubject();
                    break;

                case 6:
                    subjectsByDepartment();
                    break;

                case 7:
                    subjectsByFaculty();
                    break;

                case 0:
                    return;

                default:
                    ConsolePrinter.warning("Invalid Choice.");

            }

        }

    }

    private void addSubject() {

        Subject subject = new Subject();

        subject.setSubjectCode(InputUtil.readString("Subject Code : "));
        subject.setSubjectName(InputUtil.readString("Subject Name : "));
        subject.setSemester(InputUtil.readInt("Semester : "));
        subject.setCredits(InputUtil.readInt("Credits : "));
        subject.setDepartmentId(InputUtil.readInt("Department ID : "));
        subject.setFacultyId(InputUtil.readInt("Faculty ID : "));
        subject.setStatus("ACTIVE");

        if (controller.addSubject(subject))

            ConsolePrinter.success("Subject Added Successfully.");

        else

            ConsolePrinter.error("Failed.");

    }

    private void viewSubjects() {

        List<Subject> subjects = controller.getAllSubjects();

        if (subjects.isEmpty()) {
            ConsolePrinter.info("No subject records found.");
            return;
        }

        TablePrinter.heading("ID", "Code", "Name", "Semester", "Credits", "Dept ID", "Faculty ID", "Status");

        for (Subject s : subjects) {

            System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%n",
                    s.getSubjectId(),
                    s.getSubjectCode(),
                    s.getSubjectName(),
                    s.getSemester(),
                    s.getCredits(),
                    s.getDepartmentId(),
                    s.getFacultyId() > 0 ? s.getFacultyId() : "Unassigned",
                    s.getStatus());

        }

        TablePrinter.line();

    }

    private void searchSubject() {

        int id = InputUtil.readInt("Subject ID : ");

        Subject s = controller.getSubjectById(id);

        if (s != null) {

            TablePrinter.heading("ID", "Code", "Name", "Semester", "Credits", "Dept ID", "Faculty ID", "Status");
            System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%n",
                    s.getSubjectId(),
                    s.getSubjectCode(),
                    s.getSubjectName(),
                    s.getSemester(),
                    s.getCredits(),
                    s.getDepartmentId(),
                    s.getFacultyId() > 0 ? s.getFacultyId() : "Unassigned",
                    s.getStatus());
            TablePrinter.line();

        } else

            ConsolePrinter.error("Subject Not Found.");

    }

    private void updateSubject() {

        int id = InputUtil.readInt("Subject ID : ");

        Subject subject = controller.getSubjectById(id);

        if (subject == null) {

            ConsolePrinter.error("Subject Not Found.");

            return;

        }

        subject.setSubjectName(InputUtil.readString("New Subject Name : "));
        subject.setSemester(InputUtil.readInt("Semester : "));
        subject.setCredits(InputUtil.readInt("Credits : "));

        if (controller.updateSubject(subject))

            ConsolePrinter.success("Updated Successfully.");

        else

            ConsolePrinter.error("Update Failed.");

    }

    private void deleteSubject() {

        int id = InputUtil.readInt("Subject ID : ");

        if (controller.deleteSubject(id))

            ConsolePrinter.success("Deleted Successfully.");

        else

            ConsolePrinter.error("Delete Failed.");

    }

    private void subjectsByDepartment() {

        int departmentId = InputUtil.readInt("Department ID : ");

        List<Subject> subjects =
                controller.getSubjectsByDepartment(departmentId);

        if (subjects.isEmpty()) {
            ConsolePrinter.info("No subjects found for this department.");
            return;
        }

        TablePrinter.heading("ID", "Code", "Name", "Semester", "Credits", "Dept ID", "Faculty ID", "Status");

        for (Subject s : subjects) {

            System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%n",
                    s.getSubjectId(),
                    s.getSubjectCode(),
                    s.getSubjectName(),
                    s.getSemester(),
                    s.getCredits(),
                    s.getDepartmentId(),
                    s.getFacultyId() > 0 ? s.getFacultyId() : "Unassigned",
                    s.getStatus());

        }

        TablePrinter.line();

    }

    private void subjectsByFaculty() {

        int facultyId = InputUtil.readInt("Faculty ID : ");

        List<Subject> subjects =
                controller.getSubjectsByFaculty(facultyId);

        if (subjects.isEmpty()) {
            ConsolePrinter.info("No subjects found assigned to this faculty.");
            return;
        }

        TablePrinter.heading("ID", "Code", "Name", "Semester", "Credits", "Dept ID", "Faculty ID", "Status");

        for (Subject s : subjects) {

            System.out.printf("%-18s%-18s%-18s%-18s%-18s%-18s%-18s%-18s%n",
                    s.getSubjectId(),
                    s.getSubjectCode(),
                    s.getSubjectName(),
                    s.getSemester(),
                    s.getCredits(),
                    s.getDepartmentId(),
                    s.getFacultyId() > 0 ? s.getFacultyId() : "Unassigned",
                    s.getStatus());

        }

        TablePrinter.line();

    }

}