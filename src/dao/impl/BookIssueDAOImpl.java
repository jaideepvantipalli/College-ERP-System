package dao.impl;

import config.DBConnection;
import constants.SQLConstants;
import dao.BookIssueDAO;
import model.BookIssue;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookIssueDAOImpl implements BookIssueDAO {

    private BookIssue mapIssue(ResultSet rs) throws SQLException{

        BookIssue issue=new BookIssue();

        issue.setIssueId(rs.getInt("issue_id"));
        issue.setStudentId(rs.getInt("student_id"));
        issue.setBookId(rs.getInt("book_id"));
        issue.setIssueDate(rs.getDate("issue_date").toLocalDate());
        issue.setDueDate(rs.getDate("due_date").toLocalDate());

        Date returnDate=rs.getDate("return_date");

        if(returnDate!=null){

            issue.setReturnDate(returnDate.toLocalDate());

        }

        issue.setFine(rs.getDouble("fine"));

        return issue;

    }

    @Override

    public boolean issueBook(BookIssue issue){

        try (Connection connection = DBConnection.getConnection();

             PreparedStatement ps = connection.prepareStatement(SQLConstants.ISSUE_BOOK)) {

            ps.setInt(1,issue.getStudentId());

            ps.setInt(2,issue.getBookId());

            ps.setDate(3,Date.valueOf(issue.getIssueDate()));

            ps.setDate(4,Date.valueOf(issue.getDueDate()));

            if(issue.getReturnDate()==null)

                ps.setNull(5,Types.DATE);

            else

                ps.setDate(5,Date.valueOf(issue.getReturnDate()));

            ps.setDouble(6,issue.getFine());

            return ps.executeUpdate()>0;

        } catch(SQLException e){

            e.printStackTrace();

        }

        return false;

    }

    @Override

    public List<BookIssue> getAllIssuedBooks(){

        List<BookIssue> list=new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();

             PreparedStatement ps = connection.prepareStatement(SQLConstants.GET_ALL_ISSUES);

             ResultSet rs = ps.executeQuery()) {

            while(rs.next()){

                list.add(mapIssue(rs));

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

        return list;

    }

    @Override

    public BookIssue getIssueById(int issueId){

        try (Connection connection = DBConnection.getConnection();

             PreparedStatement ps = connection.prepareStatement(SQLConstants.GET_ISSUE_BY_ID)) {

            ps.setInt(1,issueId);

            try (ResultSet rs = ps.executeQuery()) {

                if(rs.next())

                    return mapIssue(rs);

            }

        } catch(SQLException e){

            e.printStackTrace();

        }

        return null;

    }

    @Override

    public boolean updateIssue(BookIssue issue){

        try (Connection connection = DBConnection.getConnection();

             PreparedStatement ps = connection.prepareStatement(SQLConstants.UPDATE_ISSUE)) {

            ps.setInt(1,issue.getStudentId());

            ps.setInt(2,issue.getBookId());

            ps.setDate(3,Date.valueOf(issue.getIssueDate()));

            ps.setDate(4,Date.valueOf(issue.getDueDate()));

            if(issue.getReturnDate()==null)

                ps.setNull(5,Types.DATE);

            else

                ps.setDate(5,Date.valueOf(issue.getReturnDate()));

            ps.setDouble(6,issue.getFine());

            ps.setInt(7,issue.getIssueId());

            return ps.executeUpdate()>0;

        } catch(SQLException e){

            e.printStackTrace();

        }

        return false;

    }

    @Override

    public boolean deleteIssue(int issueId){

        try (Connection connection = DBConnection.getConnection();

             PreparedStatement ps = connection.prepareStatement(SQLConstants.DELETE_ISSUE)) {

            ps.setInt(1,issueId);

            return ps.executeUpdate()>0;

        } catch(SQLException e){

            e.printStackTrace();

        }

        return false;

    }

}