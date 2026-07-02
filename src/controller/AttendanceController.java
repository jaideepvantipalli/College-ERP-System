package controller;

import model.Attendance;
import service.AttendanceService;

import java.util.List;

public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController() {

        attendanceService = new AttendanceService();

    }

    public boolean addAttendance(Attendance attendance) {

        return attendanceService.addAttendance(attendance);

    }

    public List<Attendance> getAllAttendance() {

        return attendanceService.getAllAttendance();

    }

    public Attendance getAttendanceById(int attendanceId) {

        return attendanceService.getAttendanceById(attendanceId);

    }

    public List<Attendance> getAttendanceByStudent(int studentId) {

        return attendanceService.getAttendanceByStudent(studentId);

    }

    public boolean updateAttendance(Attendance attendance) {

        return attendanceService.updateAttendance(attendance);

    }

    public boolean deleteAttendance(int attendanceId) {

        return attendanceService.deleteAttendance(attendanceId);

    }

}