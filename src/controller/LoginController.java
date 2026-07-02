package controller;

import model.User;
import service.LoginService;

public class LoginController {

    private final LoginService loginService;

    public LoginController() {

        loginService = new LoginService();

    }

    public User login(String username,
                      String password) {

        return loginService.authenticate(username,
                                         password);

    }

}