package controller;

import model.Marks;
import service.MarksService;

import java.util.List;

public class MarksController {

    private final MarksService marksService;

    public MarksController() {

        marksService = new MarksService();

    }

    public boolean addMarks(Marks marks) {

        return marksService.addMarks(marks);

    }

    public List<Marks> getAllMarks() {

        return marksService.getAllMarks();

    }

    public Marks getMarksById(int markId) {

        return marksService.getMarksById(markId);

    }

    public List<Marks> getMarksByStudent(int studentId) {

        return marksService.getMarksByStudent(studentId);

    }

    public boolean updateMarks(Marks marks) {

        return marksService.updateMarks(marks);

    }

    public boolean deleteMarks(int markId) {

        return marksService.deleteMarks(markId);

    }

}