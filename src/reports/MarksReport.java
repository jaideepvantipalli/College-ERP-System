package reports;

public class MarksReport {

    private int studentId;
    private String studentName;
    private String subjectName;
    private double total;
    private String grade;

    public MarksReport() {
    }

    public MarksReport(int studentId,
                       String studentName,
                       String subjectName,
                       double total,
                       String grade) {

        this.studentId = studentId;
        this.studentName = studentName;
        this.subjectName = subjectName;
        this.total = total;
        this.grade = grade;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {

        return "MarksReport{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", total=" + total +
                ", grade='" + grade + '\'' +
                '}';
    }

}