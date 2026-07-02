package dao.impl;

import config.DBConnection;
import constants.SQLConstants;
import dao.SubjectDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Subject;

public class SubjectDAOImpl implements SubjectDAO {

    /**
     * Converts ResultSet row into Subject object.
     */
    private Subject mapSubject(ResultSet rs) throws SQLException {

        Subject subject = new Subject();

        subject.setSubjectId(rs.getInt("subject_id"));
        subject.setSubjectCode(rs.getString("subject_code"));
        subject.setSubjectName(rs.getString("subject_name"));
        subject.setSemester(rs.getInt("semester"));
        subject.setCredits(rs.getInt("credits"));
        subject.setDepartmentId(rs.getInt("department_id"));
        subject.setFacultyId(rs.getInt("faculty_id"));
        subject.setStatus(rs.getString("status"));

        return subject;

    }

    @Override
    public boolean addSubject(Subject subject) {

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(SQLConstants.INSERT_SUBJECT);

            ps.setString(1, subject.getSubjectCode());
            ps.setString(2, subject.getSubjectName());
            ps.setInt(3, subject.getSemester());
            ps.setInt(4, subject.getCredits());
            ps.setInt(5, subject.getDepartmentId());
            ps.setInt(6, subject.getFacultyId());
            ps.setString(7, subject.getStatus());

            return ps.executeUpdate() > 0;

        }

        catch (SQLException e) {

            e.printStackTrace();

        }

        return false;

    }

    @Override
    public List<Subject> getAllSubjects() {

        List<Subject> subjects = new ArrayList<>();

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(SQLConstants.GET_ALL_SUBJECTS);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                subjects.add(mapSubject(rs));

            }

        }

        catch (SQLException e) {

            e.printStackTrace();

        }

        return subjects;

    }

    @Override
    public Subject getSubjectById(int subjectId) {

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(SQLConstants.GET_SUBJECT_BY_ID);

            ps.setInt(1, subjectId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return mapSubject(rs);

            }

        }

        catch (SQLException e) {

            e.printStackTrace();

        }

        return null;

    }

    @Override
    public List<Subject> getSubjectsByDepartment(int departmentId) {

        List<Subject> subjects = new ArrayList<>();

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(SQLConstants.GET_SUBJECTS_BY_DEPARTMENT);

            ps.setInt(1, departmentId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                subjects.add(mapSubject(rs));

            }

        }

        catch (SQLException e) {

            e.printStackTrace();

        }

        return subjects;

    }

    @Override
    public List<Subject> getSubjectsByFaculty(int facultyId) {

        List<Subject> subjects = new ArrayList<>();

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(SQLConstants.GET_SUBJECTS_BY_FACULTY);

            ps.setInt(1, facultyId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                subjects.add(mapSubject(rs));

            }

        }

        catch (SQLException e) {

            e.printStackTrace();

        }

        return subjects;

    }

    @Override
    public boolean updateSubject(Subject subject) {

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(SQLConstants.UPDATE_SUBJECT);

            ps.setString(1, subject.getSubjectCode());
            ps.setString(2, subject.getSubjectName());
            ps.setInt(3, subject.getSemester());
            ps.setInt(4, subject.getCredits());
            ps.setInt(5, subject.getDepartmentId());
            ps.setInt(6, subject.getFacultyId());
            ps.setString(7, subject.getStatus());
            ps.setInt(8, subject.getSubjectId());

            return ps.executeUpdate() > 0;

        }

        catch (SQLException e) {

            e.printStackTrace();

        }

        return false;

    }

    @Override
    public boolean deleteSubject(int subjectId) {

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(SQLConstants.DELETE_SUBJECT);

            ps.setInt(1, subjectId);

            return ps.executeUpdate() > 0;

        }

        catch (SQLException e) {

            e.printStackTrace();

        }

        return false;

    }

}