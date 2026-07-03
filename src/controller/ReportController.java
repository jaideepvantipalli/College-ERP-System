package controller;

import java.util.List;
import reports.*;
import service.ReportService;

public class ReportController {

    private final ReportService service;

    public ReportController() {

        service = new ReportService();

    }

    public List<AttendanceReport> attendanceReport() {

        return service.getAttendanceReport();

    }

    public List<MarksReport> marksReport() {

        return service.getMarksReport();

    }

    public List<FeeReport> feeReport() {

        return service.getFeeReport();

    }

    public List<LibraryReport> libraryReport() {

        return service.getLibraryReport();

    }

    public DashboardReport dashboardReport() {

        return service.getDashboardReport();

    }

}