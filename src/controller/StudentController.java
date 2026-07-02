package controller;

import model.Student;
import service.StudentService;

import java.util.List;

public class StudentController {

    private final StudentService studentService;

    public StudentController() {
        studentService = new StudentService();
    }

    public boolean addStudent(Student student) {
        return studentService.addStudent(student);
    }

    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    public Student getStudentById(int studentId) {
        return studentService.getStudentById(studentId);
    }

    public List<Student> getStudentsByDepartment(int departmentId) {
        return studentService.getStudentsByDepartment(departmentId);
    }

    public boolean updateStudent(Student student) {
        return studentService.updateStudent(student);
    }

    public boolean deleteStudent(int studentId) {
        return studentService.deleteStudent(studentId);
    }
}