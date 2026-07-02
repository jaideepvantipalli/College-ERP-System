package model;

import java.time.LocalDate;
import java.util.Objects;
import enums.AttendanceStatus;

/**
 * Model class representing Attendance.
 * Maps to the 'attendance' table.
 */
public class Attendance {

    private int attendanceId;
    private int studentId;
    private int subjectId;
    private int facultyId;
    private LocalDate attendanceDate;
    private AttendanceStatus status;

    // Default Constructor
    public Attendance() {
    }

    // Parameterized Constructor
    public Attendance(int attendanceId,
                      int studentId,
                      int subjectId,
                      int facultyId,
                      LocalDate attendanceDate,
                      AttendanceStatus status) {

        this.attendanceId = attendanceId;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.facultyId = facultyId;
        this.attendanceDate = attendanceDate;
        this.status = status;
    }

    // Getters

    public int getAttendanceId() {
        return attendanceId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public LocalDate getAttendanceDate() {
        return attendanceDate;
    }

    public AttendanceStatus getStatus() {
        return status;
    }

    // Setters

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public void setAttendanceDate(LocalDate attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public void setStatus(AttendanceStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {

        return "Attendance{" +
                "attendanceId=" + attendanceId +
                ", studentId=" + studentId +
                ", subjectId=" + subjectId +
                ", facultyId=" + facultyId +
                ", attendanceDate=" + attendanceDate +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Attendance))
            return false;

        Attendance attendance = (Attendance) obj;

        return attendanceId == attendance.attendanceId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(attendanceId);
    }

}