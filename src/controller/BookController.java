package controller;

import model.Book;
import service.BookService;

import java.util.List;

public class BookController {

    private final BookService bookService;

    public BookController() {

        bookService = new BookService();

    }

    public boolean addBook(Book book) {

        return bookService.addBook(book);

    }

    public List<Book> getAllBooks() {

        return bookService.getAllBooks();

    }

    public Book getBookById(int id) {

        return bookService.getBookById(id);

    }

    public boolean updateBook(Book book) {

        return bookService.updateBook(book);

    }

    public boolean deleteBook(int id) {

        return bookService.deleteBook(id);

    }

}