package dao;

import model.Faculty;

import java.util.List;

public interface FacultyDAO {

    boolean addFaculty(Faculty faculty);

    List<Faculty> getAllFaculty();

    Faculty getFacultyById(int facultyId);

    List<Faculty> getFacultyByDepartment(int departmentId);

    boolean updateFaculty(Faculty faculty);

    boolean deleteFaculty(int facultyId);

}