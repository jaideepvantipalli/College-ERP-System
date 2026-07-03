package service;

import dao.ReportDAO;
import dao.impl.ReportDAOImpl;
import java.util.List;
import reports.*;

public class ReportService {

    private final ReportDAO reportDAO;

    public ReportService() {

        reportDAO = new ReportDAOImpl();

    }

    public List<AttendanceReport> getAttendanceReport() {

        return reportDAO.getAttendanceReport();

    }

    public List<MarksReport> getMarksReport() {

        return reportDAO.getMarksReport();

    }

    public List<FeeReport> getFeeReport() {

        return reportDAO.getFeeReport();

    }

    public List<LibraryReport> getLibraryReport() {

        return reportDAO.getLibraryReport();

    }

    public DashboardReport getDashboardReport() {

        return reportDAO.getDashboardReport();

    }

}