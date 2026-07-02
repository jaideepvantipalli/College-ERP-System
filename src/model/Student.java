package model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Model class representing a Student.
 * Maps to the 'students' table in the database.
 *
 * Author : Jaideep
 * Project : College ERP Management System
 */
public class Student {

    // ==========================
    // Fields
    // ==========================

    private int studentId;
    private String rollNumber;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate dateOfBirth;
    private String email;
    private String phone;
    private int departmentId;
    private int academicYear;
    private char section;
    private String address;
    private LocalDate admissionDate;
    private String status;

    // ==========================
    // Default Constructor
    // ==========================

    public Student() {
    }

    // ==========================
    // Parameterized Constructor
    // ==========================

    public Student(int studentId,
                   String rollNumber,
                   String firstName,
                   String lastName,
                   String gender,
                   LocalDate dateOfBirth,
                   String email,
                   String phone,
                   int departmentId,
                   int academicYear,
                   char section,
                   String address,
                   LocalDate admissionDate,
                   String status) {

        this.studentId = studentId;
        this.rollNumber = rollNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phone = phone;
        this.departmentId = departmentId;
        this.academicYear = academicYear;
        this.section = section;
        this.address = address;
        this.admissionDate = admissionDate;
        this.status = status;
    }

    // ==========================
    // Getters
    // ==========================

    public int getStudentId() {
        return studentId;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public int getAcademicYear() {
        return academicYear;
    }

    public char getSection() {
        return section;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public String getStatus() {
        return status;
    }

    // ==========================
    // Setters
    // ==========================

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }

    public void setSection(char section) {
        this.section = section;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // ==========================
    // toString()
    // ==========================

    @Override
    public String toString() {

        return "Student{" +
                "studentId=" + studentId +
                ", rollNumber='" + rollNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", departmentId=" + departmentId +
                ", academicYear=" + academicYear +
                ", section=" + section +
                ", address='" + address + '\'' +
                ", admissionDate=" + admissionDate +
                ", status='" + status + '\'' +
                '}';
    }

    // ==========================
    // equals()
    // ==========================

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Student student = (Student) obj;

        return studentId == student.studentId;
    }

    // ==========================
    // hashCode()
    // ==========================

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }
}