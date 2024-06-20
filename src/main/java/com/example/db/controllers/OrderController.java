package com.example.db.controllers;

import javafx.fxml.FXML;
import com.example.db.MainApp;

public class OrderController {

    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleLogout() throws Exception {
        mainApp.showRoleSelection();
    }

    @FXML
    private void handleMainPage() throws Exception {
        mainApp.showClientMainPage();
    }

    @FXML
    private void handleCart() {
        mainApp.showCartPage();
    }
}
