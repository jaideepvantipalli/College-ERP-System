package dao.impl;

import config.DBConnection;
import constants.SQLConstants;
import dao.MarksDAO;
import model.Marks;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarksDAOImpl implements MarksDAO {

    private Marks mapMarks(ResultSet rs) throws SQLException {

        Marks marks = new Marks();

        marks.setMarkId(rs.getInt("mark_id"));
        marks.setStudentId(rs.getInt("student_id"));
        marks.setSubjectId(rs.getInt("subject_id"));
        marks.setInternal1(rs.getDouble("internal1"));
        marks.setInternal2(rs.getDouble("internal2"));
        marks.setAssignment(rs.getDouble("assignment"));
        marks.setSemesterExam(rs.getDouble("semester_exam"));
        marks.setTotal(rs.getDouble("total"));
        marks.setGrade(rs.getString("grade"));

        return marks;
    }

    @Override
    public boolean addMarks(Marks marks) {

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(SQLConstants.INSERT_MARKS);

            ps.setInt(1, marks.getStudentId());
            ps.setInt(2, marks.getSubjectId());
            ps.setDouble(3, marks.getInternal1());
            ps.setDouble(4, marks.getInternal2());
            ps.setDouble(5, marks.getAssignment());
            ps.setDouble(6, marks.getSemesterExam());
            ps.setDouble(7, marks.getTotal());
            ps.setString(8, marks.getGrade());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;
    }

    @Override
    public List<Marks> getAllMarks() {

        List<Marks> marksList = new ArrayList<>();

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(SQLConstants.GET_ALL_MARKS);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                marksList.add(mapMarks(rs));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return marksList;
    }

    @Override
    public Marks getMarksById(int markId) {

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(SQLConstants.GET_MARKS_BY_ID);

            ps.setInt(1, markId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return mapMarks(rs);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;
    }

    @Override
    public List<Marks> getMarksByStudent(int studentId) {

        List<Marks> marksList = new ArrayList<>();

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(SQLConstants.GET_MARKS_BY_STUDENT);

            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                marksList.add(mapMarks(rs));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return marksList;
    }

    @Override
    public boolean updateMarks(Marks marks) {

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(SQLConstants.UPDATE_MARKS);

            ps.setInt(1, marks.getStudentId());
            ps.setInt(2, marks.getSubjectId());
            ps.setDouble(3, marks.getInternal1());
            ps.setDouble(4, marks.getInternal2());
            ps.setDouble(5, marks.getAssignment());
            ps.setDouble(6, marks.getSemesterExam());
            ps.setDouble(7, marks.getTotal());
            ps.setString(8, marks.getGrade());
            ps.setInt(9, marks.getMarkId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;
    }

    @Override
    public boolean deleteMarks(int markId) {

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(SQLConstants.DELETE_MARKS);

            ps.setInt(1, markId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;
    }

}