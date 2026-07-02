package service;

import dao.FacultyDAO;
import dao.impl.FacultyDAOImpl;
import model.Faculty;

import java.util.List;

public class FacultyService {

    private final FacultyDAO facultyDAO;

    public FacultyService() {

        facultyDAO = new FacultyDAOImpl();

    }

    public boolean addFaculty(Faculty faculty) {

        return facultyDAO.addFaculty(faculty);

    }

    public List<Faculty> getAllFaculty() {

        return facultyDAO.getAllFaculty();

    }

    public Faculty getFacultyById(int id) {

        return facultyDAO.getFacultyById(id);

    }

    public List<Faculty> getFacultyByDepartment(int departmentId) {

        return facultyDAO.getFacultyByDepartment(departmentId);

    }

    public boolean updateFaculty(Faculty faculty) {

        return facultyDAO.updateFaculty(faculty);

    }

    public boolean deleteFaculty(int id) {

        return facultyDAO.deleteFaculty(id);

    }

}