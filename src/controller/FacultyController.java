package controller;

import model.Faculty;
import service.FacultyService;

import java.util.List;

public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController() {

        facultyService = new FacultyService();

    }

    public boolean addFaculty(Faculty faculty) {

        return facultyService.addFaculty(faculty);

    }

    public List<Faculty> getAllFaculty() {

        return facultyService.getAllFaculty();

    }

    public Faculty getFacultyById(int facultyId) {

        return facultyService.getFacultyById(facultyId);

    }

    public List<Faculty> getFacultyByDepartment(int departmentId) {

        return facultyService.getFacultyByDepartment(departmentId);

    }

    public boolean updateFaculty(Faculty faculty) {

        return facultyService.updateFaculty(faculty);

    }

    public boolean deleteFaculty(int facultyId) {

        return facultyService.deleteFaculty(facultyId);

    }

}