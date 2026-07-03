package dao.impl;

import config.DBConnection;
import constants.SQLConstants;
import dao.LoginDAO;
import enums.UserRole;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAOImpl implements LoginDAO {

    @Override

    public User login(String username, String password) {

        try (Connection connection = DBConnection.getConnection();

             PreparedStatement ps = connection.prepareStatement(SQLConstants.LOGIN)) {

            ps.setString(1, username);

            ps.setString(2, password);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    User user = new User();

                    user.setUserId(rs.getInt("user_id"));

                    user.setUsername(rs.getString("username"));

                    user.setPassword(rs.getString("password"));

                    user.setRole(UserRole.valueOf(rs.getString("role")));

                    user.setStatus(rs.getString("status"));

                    return user;

                }

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return null;

    }

}