package dao;

import model.Attendance;

import java.util.List;

public interface AttendanceDAO {

    boolean addAttendance(Attendance attendance);

    List<Attendance> getAllAttendance();

    Attendance getAttendanceById(int attendanceId);

    List<Attendance> getAttendanceByStudent(int studentId);

    boolean updateAttendance(Attendance attendance);

    boolean deleteAttendance(int attendanceId);

}