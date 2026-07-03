package reports;

public class DashboardReport {

    private int totalStudents;
    private int totalFaculty;
    private int totalDepartments;
    private int totalSubjects;
    private int totalBooks;

    public DashboardReport() {
    }

    public DashboardReport(int totalStudents,
                           int totalFaculty,
                           int totalDepartments,
                           int totalSubjects,
                           int totalBooks) {

        this.totalStudents = totalStudents;
        this.totalFaculty = totalFaculty;
        this.totalDepartments = totalDepartments;
        this.totalSubjects = totalSubjects;
        this.totalBooks = totalBooks;
    }

    public int getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }

    public int getTotalFaculty() {
        return totalFaculty;
    }

    public void setTotalFaculty(int totalFaculty) {
        this.totalFaculty = totalFaculty;
    }

    public int getTotalDepartments() {
        return totalDepartments;
    }

    public void setTotalDepartments(int totalDepartments) {
        this.totalDepartments = totalDepartments;
    }

    public int getTotalSubjects() {
        return totalSubjects;
    }

    public void setTotalSubjects(int totalSubjects) {
        this.totalSubjects = totalSubjects;
    }

    public int getTotalBooks() {
        return totalBooks;
    }

    public void setTotalBooks(int totalBooks) {
        this.totalBooks = totalBooks;
    }

    @Override
    public String toString() {

        return "DashboardReport{" +
                "totalStudents=" + totalStudents +
                ", totalFaculty=" + totalFaculty +
                ", totalDepartments=" + totalDepartments +
                ", totalSubjects=" + totalSubjects +
                ", totalBooks=" + totalBooks +
                '}';
    }

}