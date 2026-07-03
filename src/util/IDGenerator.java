package util;

public class IDGenerator {

    private IDGenerator() {
    }

    public static String generateStudentCode(int id) {

        return String.format("STU%04d", id);

    }

    public static String generateFacultyCode(int id) {

        return String.format("FAC%04d", id);

    }

    public static String generateBookCode(int id) {

        return String.format("BOOK%04d", id);

    }

}