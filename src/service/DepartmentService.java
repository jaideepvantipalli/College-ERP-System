package service;

import dao.DepartmentDAO;
import dao.impl.DepartmentDAOImpl;
import java.util.List;
import model.Department;

public class DepartmentService {

    private final DepartmentDAO departmentDAO;

    public DepartmentService() {

        departmentDAO = new DepartmentDAOImpl();

    }

    public boolean addDepartment(Department department) {

        return departmentDAO.addDepartment(department);

    }

    public List<Department> getAllDepartments() {

        return departmentDAO.getAllDepartments();

    }

    public Department getDepartmentById(int id) {

        return departmentDAO.getDepartmentById(id);

    }

    public boolean updateDepartment(Department department) {

        return departmentDAO.updateDepartment(department);

    }

    public boolean deleteDepartment(int id) {

        return departmentDAO.deleteDepartment(id);

    }

}