package service;

import dao.BookIssueDAO;
import dao.impl.BookIssueDAOImpl;
import model.BookIssue;

import java.util.List;

public class BookIssueService {

    private final BookIssueDAO issueDAO;

    public BookIssueService(){

        issueDAO=new BookIssueDAOImpl();

    }

    public boolean issueBook(BookIssue issue){

        return issueDAO.issueBook(issue);

    }

    public List<BookIssue> getAllIssuedBooks(){

        return issueDAO.getAllIssuedBooks();

    }

    public BookIssue getIssueById(int id){

        return issueDAO.getIssueById(id);

    }

    public boolean updateIssue(BookIssue issue){

        return issueDAO.updateIssue(issue);

    }

    public boolean deleteIssue(int id){

        return issueDAO.deleteIssue(id);

    }

}