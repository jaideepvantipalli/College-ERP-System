package app;

import config.DBConnection;
import constants.AppConstants;
import constants.AppMessages;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        System.out.println();

        System.out.println("==============================================");

        System.out.println(AppConstants.APP_NAME);

        System.out.println("Version : " + AppConstants.APP_VERSION);

        System.out.println("==============================================");

        Connection connection = DBConnection.getConnection();

        if (connection != null) {

            System.out.println(AppMessages.DATABASE_CONNECTED);

        } else {

            System.out.println(AppMessages.DATABASE_FAILED);

        }

    }

}