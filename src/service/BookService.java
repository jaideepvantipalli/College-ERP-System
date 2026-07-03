package service;

import dao.BookDAO;
import dao.impl.BookDAOImpl;
import model.Book;

import java.util.List;

public class BookService {

    private final BookDAO bookDAO;

    public BookService() {

        bookDAO = new BookDAOImpl();

    }

    public boolean addBook(Book book) {

        return bookDAO.addBook(book);

    }

    public List<Book> getAllBooks() {

        return bookDAO.getAllBooks();

    }

    public Book getBookById(int id) {

        return bookDAO.getBookById(id);

    }

    public boolean updateBook(Book book) {

        return bookDAO.updateBook(book);

    }

    public boolean deleteBook(int id) {

        return bookDAO.deleteBook(id);

    }

}