package dao.impl;

import config.DBConnection;
import constants.SQLConstants;
import dao.DepartmentDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Department;

public class DepartmentDAOImpl implements DepartmentDAO {

    @Override
    public boolean addDepartment(Department department) {

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(
                            SQLConstants.INSERT_DEPARTMENT);

            ps.setString(1, department.getDepartmentName());

            ps.setString(2, department.getDepartmentCode());

            ps.setString(3, department.getHodName());

            ps.setString(4, department.getStatus());

            return ps.executeUpdate() > 0;

        }

        catch (SQLException e) {

            e.printStackTrace();

        }

        return false;

    }

    @Override
    public List<Department> getAllDepartments() {

        List<Department> departments =
                new ArrayList<>();

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(
                            SQLConstants.GET_ALL_DEPARTMENTS);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Department department =
                        new Department();

                department.setDepartmentId(
                        rs.getInt("department_id"));

                department.setDepartmentName(
                        rs.getString("department_name"));

                department.setDepartmentCode(
                        rs.getString("department_code"));

                department.setHodName(
                        rs.getString("hod_name"));

                department.setStatus(
                        rs.getString("status"));

                departments.add(department);

            }

        }

        catch (SQLException e) {

            e.printStackTrace();

        }

        return departments;

    }

    @Override
    public Department getDepartmentById(int departmentId) {

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(
                            SQLConstants.GET_DEPARTMENT_BY_ID);

            ps.setInt(1, departmentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Department department =
                        new Department();

                department.setDepartmentId(
                        rs.getInt("department_id"));

                department.setDepartmentName(
                        rs.getString("department_name"));

                department.setDepartmentCode(
                        rs.getString("department_code"));

                department.setHodName(
                        rs.getString("hod_name"));

                department.setStatus(
                        rs.getString("status"));

                return department;

            }

        }

        catch (SQLException e) {

            e.printStackTrace();

        }

        return null;

    }

    @Override
    public boolean updateDepartment(Department department) {

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(
                            SQLConstants.UPDATE_DEPARTMENT);

            ps.setString(1,
                    department.getDepartmentName());

            ps.setString(2,
                    department.getDepartmentCode());

            ps.setString(3,
                    department.getHodName());

            ps.setString(4,
                    department.getStatus());

            ps.setInt(5,
                    department.getDepartmentId());

            return ps.executeUpdate() > 0;

        }

        catch (SQLException e) {

            e.printStackTrace();

        }

        return false;

    }

    @Override
    public boolean deleteDepartment(int departmentId) {

        try {

            Connection connection =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    connection.prepareStatement(
                            SQLConstants.DELETE_DEPARTMENT);

            ps.setInt(1, departmentId);

            return ps.executeUpdate() > 0;

        }

        catch (SQLException e) {

            e.printStackTrace();

        }

        return false;

    }

}