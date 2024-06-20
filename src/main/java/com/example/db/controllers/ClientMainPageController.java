package com.example.db.controllers;

import javafx.fxml.FXML;
import com.example.db.MainApp;
import javafx.scene.control.ComboBox;

public class ClientMainPageController {
    private MainApp mainApp;
    @FXML
    private ComboBox<String> sortComboBox;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void initialize() {
        sortComboBox.getItems().addAll("По дате", "По цене", "По названию");
    }

    @FXML
    private void handleOrders() {
        mainApp.showOrdersPage();
    }

    @FXML
    private void handleCart() {
        mainApp.showCartPage();
    }

    @FXML
    private void handleLogout() {
        try {
            mainApp.showRoleSelection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
