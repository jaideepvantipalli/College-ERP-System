package model;

import java.util.Objects;

/**
 * Model class representing a Department.
 * This class maps to the 'departments' table in the database.
 *
 * Author: Jaideep
 * Project: College ERP Management System
 */
public class Department {

    // ==========================
    // Fields
    // ==========================

    private int departmentId;
    private String departmentName;
    private String departmentCode;
    private String hodName;
    private String status;

    // ==========================
    // Default Constructor
    // ==========================

    public Department() {
    }

    // ==========================
    // Parameterized Constructor
    // ==========================

    public Department(int departmentId,
                      String departmentName,
                      String departmentCode,
                      String hodName,
                      String status) {

        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
        this.hodName = hodName;
        this.status = status;
    }

    // ==========================
    // Getters
    // ==========================

    public int getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public String getHodName() {
        return hodName;
    }

    public String getStatus() {
        return status;
    }

    // ==========================
    // Setters
    // ==========================

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public void setHodName(String hodName) {
        this.hodName = hodName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // ==========================
    // toString()
    // ==========================

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                ", hodName='" + hodName + '\'' +
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

        Department department = (Department) obj;

        return departmentId == department.departmentId;
    }

    // ==========================
    // hashCode()
    // ==========================

    @Override
    public int hashCode() {
        return Objects.hash(departmentId);
    }

}