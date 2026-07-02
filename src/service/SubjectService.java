package service;

import dao.SubjectDAO;
import dao.impl.SubjectDAOImpl;
import java.util.List;
import model.Subject;

public class SubjectService {

    private final SubjectDAO subjectDAO;

    public SubjectService() {

        subjectDAO = new SubjectDAOImpl();

    }

    public boolean addSubject(Subject subject) {

        return subjectDAO.addSubject(subject);

    }

    public List<Subject> getAllSubjects() {

        return subjectDAO.getAllSubjects();

    }

    public Subject getSubjectById(int id) {

        return subjectDAO.getSubjectById(id);

    }

    public List<Subject> getSubjectsByDepartment(int departmentId) {

        return subjectDAO.getSubjectsByDepartment(departmentId);

    }

    public List<Subject> getSubjectsByFaculty(int facultyId) {

        return subjectDAO.getSubjectsByFaculty(facultyId);

    }

    public boolean updateSubject(Subject subject) {

        return subjectDAO.updateSubject(subject);

    }

    public boolean deleteSubject(int id) {

        return subjectDAO.deleteSubject(id);

    }

}