package service;

import dao.LoginDAO;
import dao.impl.LoginDAOImpl;
import model.User;

public class LoginService {

    private final LoginDAO loginDAO;

    public LoginService() {

        loginDAO = new LoginDAOImpl();

    }

    public User authenticate(String username,
                             String password) {

        return loginDAO.login(username,
                              password);

    }

}