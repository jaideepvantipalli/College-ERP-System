package dao;

import java.util.List;
import model.Subject;

public interface SubjectDAO {

    boolean addSubject(Subject subject);

    List<Subject> getAllSubjects();

    Subject getSubjectById(int subjectId);

    List<Subject> getSubjectsByDepartment(int departmentId);

    List<Subject> getSubjectsByFaculty(int facultyId);

    boolean updateSubject(Subject subject);

    boolean deleteSubject(int subjectId);

}