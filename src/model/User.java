package model;

import java.util.Objects;
import enums.UserRole;
/**
 * Model class representing a User.
 * Maps to the 'users' table in the database.
 *
 * Author : Jaideep
 * Project : College ERP Management System
 */
public class User {

    // ==========================
    // Fields
    // ==========================

    private int userId;
    private String username;
    private String password;
    private UserRole role;
    private String status;

    // ==========================
    // Default Constructor
    // ==========================

    public User() {
    }

    // ==========================
    // Parameterized Constructor
    // ==========================

    public User(int userId,
                String username,
                String password,
                UserRole role,
                String status) {

        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    // ==========================
    // Getters
    // ==========================

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }

    public String getStatus() {
        return status;
    }

    // ==========================
    // Setters
    // ==========================

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // ==========================
    // toString()
    // ==========================

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    // ==========================
    // equals()
    // ==========================

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        User user = (User) obj;

        return userId == user.userId;
    }

    // ==========================
    // hashCode()
    // ==========================

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

}