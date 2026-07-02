package service;

import dao.AttendanceDAO;
import dao.impl.AttendanceDAOImpl;
import model.Attendance;

import java.util.List;

public class AttendanceService {

    private final AttendanceDAO attendanceDAO;

    public AttendanceService() {

        attendanceDAO = new AttendanceDAOImpl();

    }

    public boolean addAttendance(Attendance attendance) {

        return attendanceDAO.addAttendance(attendance);

    }

    public List<Attendance> getAllAttendance() {

        return attendanceDAO.getAllAttendance();

    }

    public Attendance getAttendanceById(int attendanceId) {

        return attendanceDAO.getAttendanceById(attendanceId);

    }

    public List<Attendance> getAttendanceByStudent(int studentId) {

        return attendanceDAO.getAttendanceByStudent(studentId);

    }

    public boolean updateAttendance(Attendance attendance) {

        return attendanceDAO.updateAttendance(attendance);

    }

    public boolean deleteAttendance(int attendanceId) {

        return attendanceDAO.deleteAttendance(attendanceId);

    }

}