package model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Model class representing a Faculty.
 * Maps to the 'faculty' table in the database.
 *
 * Author : Jaideep
 * Project : College ERP Management System
 */
public class Faculty {

    // ==========================
    // Fields
    // ==========================

    private int facultyId;
    private String employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String designation;
    private int departmentId;
    private LocalDate joiningDate;
    private String status;

    // ==========================
    // Default Constructor
    // ==========================

    public Faculty() {
    }

    // ==========================
    // Parameterized Constructor
    // ==========================

    public Faculty(int facultyId,
                   String employeeId,
                   String firstName,
                   String lastName,
                   String email,
                   String phone,
                   String designation,
                   int departmentId,
                   LocalDate joiningDate,
                   String status) {

        this.facultyId = facultyId;
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.designation = designation;
        this.departmentId = departmentId;
        this.joiningDate = joiningDate;
        this.status = status;
    }

    // ==========================
    // Getters
    // ==========================

    public int getFacultyId() {
        return facultyId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getDesignation() {
        return designation;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public String getStatus() {
        return status;
    }

    // ==========================
    // Setters
    // ==========================

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // ==========================
    // toString()
    // ==========================

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyId=" + facultyId +
                ", employeeId='" + employeeId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", designation='" + designation + '\'' +
                ", departmentId=" + departmentId +
                ", joiningDate=" + joiningDate +
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

        Faculty faculty = (Faculty) obj;

        return facultyId == faculty.facultyId;
    }

    // ==========================
    // hashCode()
    // ==========================

    @Override
    public int hashCode() {
        return Objects.hash(facultyId);
    }

}