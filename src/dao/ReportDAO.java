package dao;

import reports.AttendanceReport;
import reports.MarksReport;
import reports.FeeReport;
import reports.LibraryReport;
import reports.DashboardReport;

import java.util.List;

public interface ReportDAO {

    List<AttendanceReport> getAttendanceReport();

    List<MarksReport> getMarksReport();

    List<FeeReport> getFeeReport();

    List<LibraryReport> getLibraryReport();

    DashboardReport getDashboardReport();

}