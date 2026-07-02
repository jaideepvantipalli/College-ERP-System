package model;

import java.util.Objects;

/**
 * Model class representing a Book.
 * Maps to the 'books' table.
 *
 * Author : Jaideep
 * Project : College ERP Management System
 */
public class Book {

    private int bookId;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String category;
    private int quantity;
    private int availableQuantity;

    // Default Constructor
    public Book() {
    }

    // Parameterized Constructor
    public Book(int bookId,
                String isbn,
                String title,
                String author,
                String publisher,
                String category,
                int quantity,
                int availableQuantity) {

        this.bookId = bookId;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
        this.quantity = quantity;
        this.availableQuantity = availableQuantity;
    }

    // Getters

    public int getBookId() {
        return bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    // Setters

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                ", availableQuantity=" + availableQuantity +
                '}';
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Book))
            return false;

        Book book = (Book) obj;

        return bookId == book.bookId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId);
    }

}