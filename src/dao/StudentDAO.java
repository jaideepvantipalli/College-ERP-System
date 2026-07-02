package dao;

import model.Student;

import java.util.List;

public interface StudentDAO {

    boolean addStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(int studentId);

    List<Student> getStudentsByDepartment(int departmentId);

    boolean updateStudent(Student student);

    boolean deleteStudent(int studentId);

}