package dao;

import model.User;

public interface LoginDAO {

    User login(String username,
               String password);

}