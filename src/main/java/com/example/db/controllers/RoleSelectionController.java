package com.example.db.controllers;

import com.example.db.MainApp;
import javafx.fxml.FXML;

public class RoleSelectionController {
    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleEmployeeSelected() {
        try {
            mainApp.showEmployeeLoginForm();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleClientSelected() {
        try {
            mainApp.showClientLoginForm();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
