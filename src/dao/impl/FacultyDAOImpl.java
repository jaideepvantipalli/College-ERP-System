package dao.impl;

import config.DBConnection;
import constants.SQLConstants;
import dao.FacultyDAO;
import model.Faculty;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacultyDAOImpl implements FacultyDAO {

    /**
     * Maps ResultSet row to Faculty object.
     */
    private Faculty mapFaculty(ResultSet rs) throws SQLException {

        Faculty faculty = new Faculty();

        faculty.setFacultyId(rs.getInt("faculty_id"));
        faculty.setEmployeeId(rs.getString("employee_id"));
        faculty.setFirstName(rs.getString("first_name"));
        faculty.setLastName(rs.getString("last_name"));
        faculty.setEmail(rs.getString("email"));
        faculty.setPhone(rs.getString("phone"));
        faculty.setDesignation(rs.getString("designation"));
        faculty.setDepartmentId(rs.getInt("department_id"));
        faculty.setJoiningDate(rs.getDate("joining_date").toLocalDate());
        faculty.setStatus(rs.getString("status"));

        return faculty;
    }

    @Override
    public boolean addFaculty(Faculty faculty) {

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(SQLConstants.INSERT_FACULTY);

            ps.setString(1, faculty.getEmployeeId());
            ps.setString(2, faculty.getFirstName());
            ps.setString(3, faculty.getLastName());
            ps.setString(4, faculty.getEmail());
            ps.setString(5, faculty.getPhone());
            ps.setString(6, faculty.getDesignation());
            ps.setInt(7, faculty.getDepartmentId());
            ps.setDate(8, Date.valueOf(faculty.getJoiningDate()));
            ps.setString(9, faculty.getStatus());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;
    }

    @Override
    public List<Faculty> getAllFaculty() {

        List<Faculty> facultyList = new ArrayList<>();

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(SQLConstants.GET_ALL_FACULTY);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                facultyList.add(mapFaculty(rs));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return facultyList;
    }

    @Override
    public Faculty getFacultyById(int facultyId) {

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(SQLConstants.GET_FACULTY_BY_ID);

            ps.setInt(1, facultyId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return mapFaculty(rs);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;
    }

    @Override
    public List<Faculty> getFacultyByDepartment(int departmentId) {

        List<Faculty> facultyList = new ArrayList<>();

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(SQLConstants.GET_FACULTY_BY_DEPARTMENT);

            ps.setInt(1, departmentId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                facultyList.add(mapFaculty(rs));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return facultyList;
    }

    @Override
    public boolean updateFaculty(Faculty faculty) {

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(SQLConstants.UPDATE_FACULTY);

            ps.setString(1, faculty.getEmployeeId());
            ps.setString(2, faculty.getFirstName());
            ps.setString(3, faculty.getLastName());
            ps.setString(4, faculty.getEmail());
            ps.setString(5, faculty.getPhone());
            ps.setString(6, faculty.getDesignation());
            ps.setInt(7, faculty.getDepartmentId());
            ps.setDate(8, Date.valueOf(faculty.getJoiningDate()));
            ps.setString(9, faculty.getStatus());
            ps.setInt(10, faculty.getFacultyId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;
    }

    @Override
    public boolean deleteFaculty(int facultyId) {

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(SQLConstants.DELETE_FACULTY);

            ps.setInt(1, facultyId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;
    }

}