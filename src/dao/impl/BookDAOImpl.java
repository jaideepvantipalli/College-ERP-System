package dao.impl;

import config.DBConnection;
import constants.SQLConstants;
import dao.BookDAO;
import model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {

    private Book mapBook(ResultSet rs) throws SQLException {

        Book book = new Book();

        book.setBookId(rs.getInt("book_id"));
        book.setIsbn(rs.getString("isbn"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setPublisher(rs.getString("publisher"));
        book.setCategory(rs.getString("category"));
        book.setQuantity(rs.getInt("quantity"));
        book.setAvailableQuantity(rs.getInt("available_quantity"));

        return book;

    }

    @Override

    public boolean addBook(Book book) {

        try (Connection connection = DBConnection.getConnection();

             PreparedStatement ps = connection.prepareStatement(SQLConstants.INSERT_BOOK)) {

            ps.setString(1, book.getIsbn());

            ps.setString(2, book.getTitle());

            ps.setString(3, book.getAuthor());

            ps.setString(4, book.getPublisher());

            ps.setString(5, book.getCategory());

            ps.setInt(6, book.getQuantity());

            ps.setInt(7, book.getAvailableQuantity());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;

    }

    @Override

    public List<Book> getAllBooks() {

        List<Book> books = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();

             PreparedStatement ps = connection.prepareStatement(SQLConstants.GET_ALL_BOOKS);

             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                books.add(mapBook(rs));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return books;

    }

    @Override

    public Book getBookById(int bookId) {

        try (Connection connection = DBConnection.getConnection();

             PreparedStatement ps = connection.prepareStatement(SQLConstants.GET_BOOK_BY_ID)) {

            ps.setInt(1, bookId);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    return mapBook(rs);

                }

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;

    }

    @Override

    public boolean updateBook(Book book) {

        try (Connection connection = DBConnection.getConnection();

             PreparedStatement ps = connection.prepareStatement(SQLConstants.UPDATE_BOOK)) {

            ps.setString(1, book.getIsbn());

            ps.setString(2, book.getTitle());

            ps.setString(3, book.getAuthor());

            ps.setString(4, book.getPublisher());

            ps.setString(5, book.getCategory());

            ps.setInt(6, book.getQuantity());

            ps.setInt(7, book.getAvailableQuantity());

            ps.setInt(8, book.getBookId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;

    }

    @Override

    public boolean deleteBook(int bookId) {

        try (Connection connection = DBConnection.getConnection();

             PreparedStatement ps = connection.prepareStatement(SQLConstants.DELETE_BOOK)) {

            ps.setInt(1, bookId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;

    }

}