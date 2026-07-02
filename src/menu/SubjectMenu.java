package menu;

import controller.SubjectController;
import model.Subject;

import java.util.List;
import java.util.Scanner;

public class SubjectMenu {

    private final Scanner scanner;
    private final SubjectController controller;

    public SubjectMenu() {

        scanner = new Scanner(System.in);
        controller = new SubjectController();

    }

    public void start() {

        while (true) {

            System.out.println("\n================================");
            System.out.println(" SUBJECT MANAGEMENT ");
            System.out.println("================================");
            System.out.println("1. Add Subject");
            System.out.println("2. View Subjects");
            System.out.println("3. Search Subject");
            System.out.println("4. Update Subject");
            System.out.println("5. Delete Subject");
            System.out.println("6. Subjects By Department");
            System.out.println("7. Subjects By Faculty");
            System.out.println("0. Back");

            System.out.print("Choice : ");

            int choice = Integer.parseInt(scanner.nextLine());

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
                    System.out.println("Invalid Choice.");

            }

        }

    }

    private void addSubject() {

        Subject subject = new Subject();

        System.out.print("Subject Code : ");
        subject.setSubjectCode(scanner.nextLine());

        System.out.print("Subject Name : ");
        subject.setSubjectName(scanner.nextLine());

        System.out.print("Semester : ");
        subject.setSemester(Integer.parseInt(scanner.nextLine()));

        System.out.print("Credits : ");
        subject.setCredits(Integer.parseInt(scanner.nextLine()));

        System.out.print("Department ID : ");
        subject.setDepartmentId(Integer.parseInt(scanner.nextLine()));

        System.out.print("Faculty ID : ");
        subject.setFacultyId(Integer.parseInt(scanner.nextLine()));

        subject.setStatus("ACTIVE");

        if (controller.addSubject(subject))

            System.out.println("Subject Added Successfully.");

        else

            System.out.println("Failed.");

    }

    private void viewSubjects() {

        List<Subject> subjects = controller.getAllSubjects();

        for (Subject subject : subjects) {

            System.out.println(subject);

        }

    }

    private void searchSubject() {

        System.out.print("Subject ID : ");

        int id = Integer.parseInt(scanner.nextLine());

        Subject subject = controller.getSubjectById(id);

        if (subject != null)

            System.out.println(subject);

        else

            System.out.println("Subject Not Found.");

    }

    private void updateSubject() {

        System.out.print("Subject ID : ");

        int id = Integer.parseInt(scanner.nextLine());

        Subject subject = controller.getSubjectById(id);

        if (subject == null) {

            System.out.println("Subject Not Found.");

            return;

        }

        System.out.print("New Subject Name : ");
        subject.setSubjectName(scanner.nextLine());

        System.out.print("Semester : ");
        subject.setSemester(Integer.parseInt(scanner.nextLine()));

        System.out.print("Credits : ");
        subject.setCredits(Integer.parseInt(scanner.nextLine()));

        if (controller.updateSubject(subject))

            System.out.println("Updated Successfully.");

        else

            System.out.println("Update Failed.");

    }

    private void deleteSubject() {

        System.out.print("Subject ID : ");

        int id = Integer.parseInt(scanner.nextLine());

        if (controller.deleteSubject(id))

            System.out.println("Deleted Successfully.");

        else

            System.out.println("Delete Failed.");

    }

    private void subjectsByDepartment() {

        System.out.print("Department ID : ");

        int departmentId = Integer.parseInt(scanner.nextLine());

        List<Subject> subjects =
                controller.getSubjectsByDepartment(departmentId);

        for (Subject subject : subjects) {

            System.out.println(subject);

        }

    }

    private void subjectsByFaculty() {

        System.out.print("Faculty ID : ");

        int facultyId = Integer.parseInt(scanner.nextLine());

        List<Subject> subjects =
                controller.getSubjectsByFaculty(facultyId);

        for (Subject subject : subjects) {

            System.out.println(subject);

        }

    }

}