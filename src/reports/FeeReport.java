package reports;

public class FeeReport {

    private int studentId;
    private String studentName;
    private double totalFee;
    private double paidFee;
    private double balance;

    public FeeReport() {
    }

    public FeeReport(int studentId,
                     String studentName,
                     double totalFee,
                     double paidFee,
                     double balance) {

        this.studentId = studentId;
        this.studentName = studentName;
        this.totalFee = totalFee;
        this.paidFee = paidFee;
        this.balance = balance;
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

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    public double getPaidFee() {
        return paidFee;
    }

    public void setPaidFee(double paidFee) {
        this.paidFee = paidFee;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {

        return "FeeReport{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", totalFee=" + totalFee +
                ", paidFee=" + paidFee +
                ", balance=" + balance +
                '}';
    }

}