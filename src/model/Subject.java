package model;

import java.util.Objects;

/**
 * Model class representing a Subject.
 * Maps to the 'subjects' table.
 */
public class Subject {

    private int subjectId;
    private String subjectCode;
    private String subjectName;
    private int semester;
    private int credits;
    private int departmentId;
    private int facultyId;
    private String status;

    // Default Constructor
    public Subject() {
    }

    // Parameterized Constructor
    public Subject(int subjectId,
                   String subjectCode,
                   String subjectName,
                   int semester,
                   int credits,
                   int departmentId,
                   int facultyId,
                   String status) {

        this.subjectId = subjectId;
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.semester = semester;
        this.credits = credits;
        this.departmentId = departmentId;
        this.facultyId = facultyId;
        this.status = status;
    }

    // Getters

    public int getSubjectId() {
        return subjectId;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getSemester() {
        return semester;
    }

    public int getCredits() {
        return credits;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public String getStatus() {
        return status;
    }

    // Setters

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {

        return "Subject{" +
                "subjectId=" + subjectId +
                ", subjectCode='" + subjectCode + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", semester=" + semester +
                ", credits=" + credits +
                ", departmentId=" + departmentId +
                ", facultyId=" + facultyId +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Subject))
            return false;

        Subject subject = (Subject) obj;

        return subjectId == subject.subjectId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectId);
    }

}