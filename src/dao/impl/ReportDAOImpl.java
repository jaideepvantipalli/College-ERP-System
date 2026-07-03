package dao.impl;

import config.DBConnection;
import dao.ReportDAO;
import reports.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReportDAOImpl implements ReportDAO {

    @Override

    public List<AttendanceReport> getAttendanceReport() {

        List<AttendanceReport> list = new ArrayList<>();

        String sql =

                "SELECT s.student_id, " +

                "CONCAT(s.first_name,' ',s.last_name) student_name, " +

                "sub.subject_name, " +

                "COUNT(a.attendance_id) total_classes, " +

                "SUM(CASE WHEN a.status='PRESENT' THEN 1 ELSE 0 END) present_classes, " +

                "ROUND((SUM(CASE WHEN a.status='PRESENT' THEN 1 ELSE 0 END)/COUNT(*))*100,2) percentage " +

                "FROM attendance a " +

                "JOIN students s ON a.student_id=s.student_id " +

                "JOIN subjects sub ON a.subject_id=sub.subject_id " +

                "GROUP BY s.student_id,sub.subject_name";

        try (Connection connection = DBConnection.getConnection();

             PreparedStatement ps = connection.prepareStatement(sql);

             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                AttendanceReport report = new AttendanceReport();

                report.setStudentId(rs.getInt(1));

                report.setStudentName(rs.getString(2));

                report.setSubjectName(rs.getString(3));

                report.setTotalClasses(rs.getInt(4));

                report.setPresentClasses(rs.getInt(5));

                report.setPercentage(rs.getDouble(6));

                list.add(report);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return list;

    }

    @Override

    public List<MarksReport> getMarksReport() {

        List<MarksReport> list = new ArrayList<>();

        String sql =

                "SELECT s.student_id," +

                " CONCAT(s.first_name,' ',s.last_name)," +

                " sub.subject_name," +

                " m.total," +

                " m.grade " +

                "FROM marks m " +

                "JOIN students s ON m.student_id=s.student_id " +

                "JOIN subjects sub ON m.subject_id=sub.subject_id";

        try (Connection connection = DBConnection.getConnection();

             PreparedStatement ps = connection.prepareStatement(sql);

             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                MarksReport report = new MarksReport();

                report.setStudentId(rs.getInt(1));

                report.setStudentName(rs.getString(2));

                report.setSubjectName(rs.getString(3));

                report.setTotal(rs.getDouble(4));

                report.setGrade(rs.getString(5));

                list.add(report);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return list;

    }

    @Override

    public List<FeeReport> getFeeReport() {

        List<FeeReport> list = new ArrayList<>();

        String sql =

                "SELECT s.student_id," +

                " CONCAT(s.first_name,' ',s.last_name)," +

                " f.total_fee," +

                " f.paid_fee," +

                " f.balance " +

                "FROM fees f " +

                "JOIN students s ON f.student_id=s.student_id";

        try (Connection connection = DBConnection.getConnection();

             PreparedStatement ps = connection.prepareStatement(sql);

             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                FeeReport report = new FeeReport();

                report.setStudentId(rs.getInt(1));

                report.setStudentName(rs.getString(2));

                report.setTotalFee(rs.getDouble(3));

                report.setPaidFee(rs.getDouble(4));

                report.setBalance(rs.getDouble(5));

                list.add(report);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return list;

    }

    @Override

    public List<LibraryReport> getLibraryReport() {

        List<LibraryReport> list = new ArrayList<>();

        String sql =

                "SELECT bi.issue_id," +

                " CONCAT(s.first_name,' ',s.last_name)," +

                " b.title," +

                " bi.issue_date," +

                " bi.due_date," +

                " bi.return_date," +

                " bi.fine " +

                "FROM book_issues bi " +

                "JOIN students s ON bi.student_id=s.student_id " +

                "JOIN books b ON bi.book_id=b.book_id";

        try (Connection connection = DBConnection.getConnection();

             PreparedStatement ps = connection.prepareStatement(sql);

             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                LibraryReport report = new LibraryReport();

                report.setIssueId(rs.getInt(1));

                report.setStudentName(rs.getString(2));

                report.setBookTitle(rs.getString(3));

                report.setIssueDate(rs.getDate(4).toLocalDate());

                report.setDueDate(rs.getDate(5).toLocalDate());

                if (rs.getDate(6) != null) {

                    report.setReturnDate(rs.getDate(6).toLocalDate());

                }

                report.setFine(rs.getDouble(7));

                list.add(report);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return list;

    }

    @Override

    public DashboardReport getDashboardReport() {

        DashboardReport report = new DashboardReport();

        try (Connection connection = DBConnection.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement("SELECT COUNT(*) FROM students");

                 ResultSet rs = ps.executeQuery()) {

                if (rs.next())

                    report.setTotalStudents(rs.getInt(1));

            }

            try (PreparedStatement ps = connection.prepareStatement("SELECT COUNT(*) FROM faculty");

                 ResultSet rs = ps.executeQuery()) {

                if (rs.next())

                    report.setTotalFaculty(rs.getInt(1));

            }

            try (PreparedStatement ps = connection.prepareStatement("SELECT COUNT(*) FROM departments");

                 ResultSet rs = ps.executeQuery()) {

                if (rs.next())

                    report.setTotalDepartments(rs.getInt(1));

            }

            try (PreparedStatement ps = connection.prepareStatement("SELECT COUNT(*) FROM subjects");

                 ResultSet rs = ps.executeQuery()) {

                if (rs.next())

                    report.setTotalSubjects(rs.getInt(1));

            }

            try (PreparedStatement ps = connection.prepareStatement("SELECT COUNT(*) FROM books");

                 ResultSet rs = ps.executeQuery()) {

                if (rs.next())

                    report.setTotalBooks(rs.getInt(1));

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return report;

    }

}