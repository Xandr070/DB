package com.example.db.controllers;

import com.example.db.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class IssuePageController {

    @FXML
    private TextField orderNumberField;

    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleIssue() {
        String orderNumber = orderNumberField.getText();
        // Логика выдачи товаров по номеру заказа
    }

    @FXML
    private void handleBack() {
        try {
            mainApp.showEmployeeMainPage(); // Показываем главную страницу сотрудника
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
