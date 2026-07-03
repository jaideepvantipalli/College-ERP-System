package reports;

public class AttendanceReport {

    private int studentId;
    private String studentName;
    private String subjectName;
    private int totalClasses;
    private int presentClasses;
    private double percentage;

    public AttendanceReport() {
    }

    public AttendanceReport(int studentId,
                            String studentName,
                            String subjectName,
                            int totalClasses,
                            int presentClasses,
                            double percentage) {

        this.studentId = studentId;
        this.studentName = studentName;
        this.subjectName = subjectName;
        this.totalClasses = totalClasses;
        this.presentClasses = presentClasses;
        this.percentage = percentage;
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

    public int getTotalClasses() {
        return totalClasses;
    }

    public void setTotalClasses(int totalClasses) {
        this.totalClasses = totalClasses;
    }

    public int getPresentClasses() {
        return presentClasses;
    }

    public void setPresentClasses(int presentClasses) {
        this.presentClasses = presentClasses;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {

        return "AttendanceReport{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", totalClasses=" + totalClasses +
                ", presentClasses=" + presentClasses +
                ", percentage=" + percentage +
                '}';
    }

}