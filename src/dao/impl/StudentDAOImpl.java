package dao.impl;

import config.DBConnection;
import constants.SQLConstants;
import dao.StudentDAO;
import model.Student;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    /**
     * Maps ResultSet row to Student object.
     */
    private Student mapStudent(ResultSet rs) throws SQLException {

        Student student = new Student();

        student.setStudentId(rs.getInt("student_id"));
        student.setRollNumber(rs.getString("roll_number"));
        student.setFirstName(rs.getString("first_name"));
        student.setLastName(rs.getString("last_name"));
        student.setGender(rs.getString("gender"));
        student.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());
        student.setEmail(rs.getString("email"));
        student.setPhone(rs.getString("phone"));
        student.setDepartmentId(rs.getInt("department_id"));
        student.setAcademicYear(rs.getInt("academic_year"));
        student.setSection(rs.getString("section").charAt(0));
        student.setAddress(rs.getString("address"));
        student.setAdmissionDate(rs.getDate("admission_date").toLocalDate());
        student.setStatus(rs.getString("status"));

        return student;
    }

    @Override
    public boolean addStudent(Student student) {

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(SQLConstants.INSERT_STUDENT);

            ps.setString(1, student.getRollNumber());
            ps.setString(2, student.getFirstName());
            ps.setString(3, student.getLastName());
            ps.setString(4, student.getGender());
            ps.setDate(5, Date.valueOf(student.getDateOfBirth()));
            ps.setString(6, student.getEmail());
            ps.setString(7, student.getPhone());
            ps.setInt(8, student.getDepartmentId());
            ps.setInt(9, student.getAcademicYear());
            ps.setString(10, String.valueOf(student.getSection()));
            ps.setString(11, student.getAddress());
            ps.setDate(12, Date.valueOf(student.getAdmissionDate()));
            ps.setString(13, student.getStatus());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;
    }

    @Override
    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(SQLConstants.GET_ALL_STUDENTS);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                students.add(mapStudent(rs));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return students;
    }

    @Override
    public Student getStudentById(int studentId) {

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(SQLConstants.GET_STUDENT_BY_ID);

            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return mapStudent(rs);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;
    }

    @Override
    public List<Student> getStudentsByDepartment(int departmentId) {

        List<Student> students = new ArrayList<>();

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement ps = connection.prepareStatement(
                    SQLConstants.GET_STUDENTS_BY_DEPARTMENT);

            ps.setInt(1, departmentId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                students.add(mapStudent(rs));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return students;
    }

    @Override
    public boolean updateStudent(Student student) {

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(SQLConstants.UPDATE_STUDENT);

            ps.setString(1, student.getRollNumber());
            ps.setString(2, student.getFirstName());
            ps.setString(3, student.getLastName());
            ps.setString(4, student.getGender());
            ps.setDate(5, Date.valueOf(student.getDateOfBirth()));
            ps.setString(6, student.getEmail());
            ps.setString(7, student.getPhone());
            ps.setInt(8, student.getDepartmentId());
            ps.setInt(9, student.getAcademicYear());
            ps.setString(10, String.valueOf(student.getSection()));
            ps.setString(11, student.getAddress());
            ps.setDate(12, Date.valueOf(student.getAdmissionDate()));
            ps.setString(13, student.getStatus());
            ps.setInt(14, student.getStudentId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;
    }

    @Override
    public boolean deleteStudent(int studentId) {

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(SQLConstants.DELETE_STUDENT);

            ps.setInt(1, studentId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;
    }

}