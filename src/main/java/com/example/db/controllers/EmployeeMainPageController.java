package com.example.db.controllers;

import com.example.db.MainApp;
import javafx.fxml.FXML;

public class EmployeeMainPageController {

    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleLogout() {
        try {
            mainApp.showRoleSelection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleTransport() throws Exception {
        // Открыть страницу перевозки
        mainApp.showTransportPage();
    }

    @FXML
    private void handleIssue() throws Exception {
        // Открыть страницу выдачи
        mainApp.showIssuePage();
    }
}
