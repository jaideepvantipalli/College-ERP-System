package dao.impl;

import config.DBConnection;
import constants.SQLConstants;
import dao.AttendanceDAO;
import enums.AttendanceStatus;
import model.Attendance;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAOImpl implements AttendanceDAO {

    private Attendance mapAttendance(ResultSet rs) throws SQLException {

        Attendance attendance = new Attendance();

        attendance.setAttendanceId(rs.getInt("attendance_id"));
        attendance.setStudentId(rs.getInt("student_id"));
        attendance.setSubjectId(rs.getInt("subject_id"));
        attendance.setFacultyId(rs.getInt("faculty_id"));
        attendance.setAttendanceDate(
                rs.getDate("attendance_date").toLocalDate());

        attendance.setStatus(
                AttendanceStatus.valueOf(rs.getString("status")));

        return attendance;

    }

    @Override
    public boolean addAttendance(Attendance attendance) {

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(
                            SQLConstants.INSERT_ATTENDANCE);

            ps.setInt(1, attendance.getStudentId());
            ps.setInt(2, attendance.getSubjectId());
            ps.setInt(3, attendance.getFacultyId());
            ps.setDate(4,
                    Date.valueOf(attendance.getAttendanceDate()));
            ps.setString(5,
                    attendance.getStatus().name());

            return ps.executeUpdate() > 0;

        }

        catch (SQLException e) {

            e.printStackTrace();

        }

        return false;

    }

    @Override
    public List<Attendance> getAllAttendance() {

        List<Attendance> attendanceList =
                new ArrayList<>();

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(
                            SQLConstants.GET_ALL_ATTENDANCE);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                attendanceList.add(mapAttendance(rs));

            }

        }

        catch (SQLException e) {

            e.printStackTrace();

        }

        return attendanceList;

    }

    @Override
    public Attendance getAttendanceById(int attendanceId) {

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(
                            SQLConstants.GET_ATTENDANCE_BY_ID);

            ps.setInt(1, attendanceId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return mapAttendance(rs);

            }

        }

        catch (SQLException e) {

            e.printStackTrace();

        }

        return null;

    }

    @Override
    public List<Attendance> getAttendanceByStudent(int studentId) {

        List<Attendance> attendanceList =
                new ArrayList<>();

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(
                            SQLConstants.GET_ATTENDANCE_BY_STUDENT);

            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                attendanceList.add(mapAttendance(rs));

            }

        }

        catch (SQLException e) {

            e.printStackTrace();

        }

        return attendanceList;

    }

    @Override
    public boolean updateAttendance(Attendance attendance) {

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(
                            SQLConstants.UPDATE_ATTENDANCE);

            ps.setInt(1, attendance.getStudentId());
            ps.setInt(2, attendance.getSubjectId());
            ps.setInt(3, attendance.getFacultyId());
            ps.setDate(4,
                    Date.valueOf(attendance.getAttendanceDate()));
            ps.setString(5,
                    attendance.getStatus().name());
            ps.setInt(6,
                    attendance.getAttendanceId());

            return ps.executeUpdate() > 0;

        }

        catch (SQLException e) {

            e.printStackTrace();

        }

        return false;

    }

    @Override
    public boolean deleteAttendance(int attendanceId) {

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(
                            SQLConstants.DELETE_ATTENDANCE);

            ps.setInt(1, attendanceId);

            return ps.executeUpdate() > 0;

        }

        catch (SQLException e) {

            e.printStackTrace();

        }

        return false;

    }

}