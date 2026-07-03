package dao;

import model.Book;

import java.util.List;

public interface BookDAO {

    boolean addBook(Book book);

    List<Book> getAllBooks();

    Book getBookById(int bookId);

    boolean updateBook(Book book);

    boolean deleteBook(int bookId);

}