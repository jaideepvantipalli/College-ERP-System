package service;

import dao.StudentDAO;
import dao.impl.StudentDAOImpl;
import model.Student;

import java.util.List;

public class StudentService {

    private final StudentDAO studentDAO;

    public StudentService() {

        studentDAO = new StudentDAOImpl();

    }

    public boolean addStudent(Student student) {

        return studentDAO.addStudent(student);

    }

    public List<Student> getAllStudents() {

        return studentDAO.getAllStudents();

    }

    public Student getStudentById(int id) {

        return studentDAO.getStudentById(id);

    }

    public List<Student> getStudentsByDepartment(int departmentId) {

        return studentDAO.getStudentsByDepartment(departmentId);

    }

    public boolean updateStudent(Student student) {

        return studentDAO.updateStudent(student);

    }

    public boolean deleteStudent(int id) {

        return studentDAO.deleteStudent(id);

    }

}