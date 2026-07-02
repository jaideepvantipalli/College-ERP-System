package controller;

import java.util.List;
import model.Department;
import service.DepartmentService;

public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController() {

        departmentService = new DepartmentService();

    }

    public boolean addDepartment(Department department) {

        return departmentService.addDepartment(department);

    }

    public List<Department> getAllDepartments() {

        return departmentService.getAllDepartments();

    }

    public Department getDepartmentById(int id) {

        return departmentService.getDepartmentById(id);

    }

    public boolean updateDepartment(Department department) {

        return departmentService.updateDepartment(department);

    }

    public boolean deleteDepartment(int id) {

        return departmentService.deleteDepartment(id);

    }

}