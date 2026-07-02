package model;

import java.time.LocalDate;
import java.util.Objects;
import enums.FeeStatus;

/**
 * Model class representing Fee.
 * Maps to the 'fees' table.
 *
 * Author : Jaideep
 * Project : College ERP Management System
 */
public class Fee {

    private int feeId;
    private int studentId;
    private double totalFee;
    private double paidFee;
    private double balance;
    private LocalDate paymentDate;
    private FeeStatus status;

    // Default Constructor
    public Fee() {
    }

    // Parameterized Constructor
    public Fee(int feeId,
               int studentId,
               double totalFee,
               double paidFee,
               double balance,
               LocalDate paymentDate,
               FeeStatus status) {

        this.feeId = feeId;
        this.studentId = studentId;
        this.totalFee = totalFee;
        this.paidFee = paidFee;
        this.balance = balance;
        this.paymentDate = paymentDate;
        this.status = status;
    }

    // Getters

    public int getFeeId() {
        return feeId;
    }

    public int getStudentId() {
        return studentId;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public double getPaidFee() {
        return paidFee;
    }

    public double getBalance() {
        return balance;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public FeeStatus getStatus() {
        return status;
    }

    // Setters

    public void setFeeId(int feeId) {
        this.feeId = feeId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    public void setPaidFee(double paidFee) {
        this.paidFee = paidFee;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setStatus(FeeStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Fee{" +
                "feeId=" + feeId +
                ", studentId=" + studentId +
                ", totalFee=" + totalFee +
                ", paidFee=" + paidFee +
                ", balance=" + balance +
                ", paymentDate=" + paymentDate +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Fee))
            return false;

        Fee fee = (Fee) obj;

        return feeId == fee.feeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(feeId);
    }

}