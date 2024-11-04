package com.mycompany.app;

import com.mycompany.database.SQLCommandsApp;
import com.mycompany.screen.PrincipalScreen;

public class GIManagerApp {

    public static void main(String[] args) {
        SQLCommandsApp.loadDriver();
        SQLCommandsApp.createConnection();
        PrincipalScreen.main(args);
    }
}