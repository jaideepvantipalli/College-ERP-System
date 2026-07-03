package controller;

import model.BookIssue;
import service.BookIssueService;

import java.util.List;

public class BookIssueController {

    private final BookIssueService issueService;

    public BookIssueController() {

        issueService = new BookIssueService();

    }

    public boolean issueBook(BookIssue issue) {

        return issueService.issueBook(issue);

    }

    public List<BookIssue> getAllIssuedBooks() {

        return issueService.getAllIssuedBooks();

    }

    public BookIssue getIssueById(int issueId) {

        return issueService.getIssueById(issueId);

    }

    public boolean updateIssue(BookIssue issue) {

        return issueService.updateIssue(issue);

    }

    public boolean deleteIssue(int issueId) {

        return issueService.deleteIssue(issueId);

    }

}