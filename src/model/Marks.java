package model;

import java.util.Objects;

/**
 * Model class representing Marks.
 * Maps to the 'marks' table.
 *
 * Author : Jaideep
 * Project : College ERP Management System
 */
public class Marks {

    private int markId;
    private int studentId;
    private int subjectId;
    private double internal1;
    private double internal2;
    private double assignment;
    private double semesterExam;
    private double total;
    private String grade;

    // Default Constructor
    public Marks() {
    }

    // Parameterized Constructor
    public Marks(int markId,
                 int studentId,
                 int subjectId,
                 double internal1,
                 double internal2,
                 double assignment,
                 double semesterExam,
                 double total,
                 String grade) {

        this.markId = markId;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.internal1 = internal1;
        this.internal2 = internal2;
        this.assignment = assignment;
        this.semesterExam = semesterExam;
        this.total = total;
        this.grade = grade;
    }

    // Getters

    public int getMarkId() {
        return markId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public double getInternal1() {
        return internal1;
    }

    public double getInternal2() {
        return internal2;
    }

    public double getAssignment() {
        return assignment;
    }

    public double getSemesterExam() {
        return semesterExam;
    }

    public double getTotal() {
        return total;
    }

    public String getGrade() {
        return grade;
    }

    // Setters

    public void setMarkId(int markId) {
        this.markId = markId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public void setInternal1(double internal1) {
        this.internal1 = internal1;
    }

    public void setInternal2(double internal2) {
        this.internal2 = internal2;
    }

    public void setAssignment(double assignment) {
        this.assignment = assignment;
    }

    public void setSemesterExam(double semesterExam) {
        this.semesterExam = semesterExam;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Marks{" +
                "markId=" + markId +
                ", studentId=" + studentId +
                ", subjectId=" + subjectId +
                ", internal1=" + internal1 +
                ", internal2=" + internal2 +
                ", assignment=" + assignment +
                ", semesterExam=" + semesterExam +
                ", total=" + total +
                ", grade='" + grade + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Marks))
            return false;

        Marks marks = (Marks) obj;

        return markId == marks.markId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(markId);
    }

}