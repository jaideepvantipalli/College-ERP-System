package dao;

import model.Marks;
import java.util.List;

public interface MarksDAO {

    boolean addMarks(Marks marks);

    List<Marks> getAllMarks();

    Marks getMarksById(int markId);

    List<Marks> getMarksByStudent(int studentId);

    boolean updateMarks(Marks marks);

    boolean deleteMarks(int markId);

}