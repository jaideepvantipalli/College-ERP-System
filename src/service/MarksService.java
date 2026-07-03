package service;

import dao.MarksDAO;
import dao.impl.MarksDAOImpl;
import model.Marks;

import java.util.List;

public class MarksService {

    private final MarksDAO marksDAO;

    public MarksService() {

        marksDAO = new MarksDAOImpl();

    }

    public boolean addMarks(Marks marks) {

        return marksDAO.addMarks(marks);

    }

    public List<Marks> getAllMarks() {

        return marksDAO.getAllMarks();

    }

    public Marks getMarksById(int markId) {

        return marksDAO.getMarksById(markId);

    }

    public List<Marks> getMarksByStudent(int studentId) {

        return marksDAO.getMarksByStudent(studentId);

    }

    public boolean updateMarks(Marks marks) {

        return marksDAO.updateMarks(marks);

    }

    public boolean deleteMarks(int markId) {

        return marksDAO.deleteMarks(markId);

    }

}