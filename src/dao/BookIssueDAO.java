package dao;

import model.BookIssue;

import java.util.List;

public interface BookIssueDAO {

    boolean issueBook(BookIssue issue);

    List<BookIssue> getAllIssuedBooks();

    BookIssue getIssueById(int issueId);

    boolean updateIssue(BookIssue issue);

    boolean deleteIssue(int issueId);

}