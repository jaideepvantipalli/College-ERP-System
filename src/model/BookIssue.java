package model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Model class representing Book Issue.
 * Maps to the 'book_issues' table.
 *
 * Author : Jaideep
 * Project : College ERP Management System
 */
public class BookIssue {

    private int issueId;
    private int studentId;
    private int bookId;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private double fine;

    // Default Constructor
    public BookIssue() {
    }

    // Parameterized Constructor
    public BookIssue(int issueId,
                     int studentId,
                     int bookId,
                     LocalDate issueDate,
                     LocalDate dueDate,
                     LocalDate returnDate,
                     double fine) {

        this.issueId = issueId;
        this.studentId = studentId;
        this.bookId = bookId;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.fine = fine;
    }

    // Getters

    public int getIssueId() {
        return issueId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getBookId() {
        return bookId;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public double getFine() {
        return fine;
    }

    // Setters

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "BookIssue{" +
                "issueId=" + issueId +
                ", studentId=" + studentId +
                ", bookId=" + bookId +
                ", issueDate=" + issueDate +
                ", dueDate=" + dueDate +
                ", returnDate=" + returnDate +
                ", fine=" + fine +
                '}';
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof BookIssue))
            return false;

        BookIssue issue = (BookIssue) obj;

        return issueId == issue.issueId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(issueId);
    }

}