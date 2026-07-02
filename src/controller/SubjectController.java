package controller;

import java.util.List;
import model.Subject;
import service.SubjectService;

public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController() {

        subjectService = new SubjectService();

    }

    public boolean addSubject(Subject subject) {

        return subjectService.addSubject(subject);

    }

    public List<Subject> getAllSubjects() {

        return subjectService.getAllSubjects();

    }

    public Subject getSubjectById(int subjectId) {

        return subjectService.getSubjectById(subjectId);

    }

    public List<Subject> getSubjectsByDepartment(int departmentId) {

        return subjectService.getSubjectsByDepartment(departmentId);

    }

    public List<Subject> getSubjectsByFaculty(int facultyId) {

        return subjectService.getSubjectsByFaculty(facultyId);

    }

    public boolean updateSubject(Subject subject) {

        return subjectService.updateSubject(subject);

    }

    public boolean deleteSubject(int subjectId) {

        return subjectService.deleteSubject(subjectId);

    }

}