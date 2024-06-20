package com.example.db.controllers;

import com.example.db.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class TransportPageController {

    @FXML
    private TextField orderNumberField;

    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleTransport() {
        String orderNumber = orderNumberField.getText();
        // Логика перевозки товаров по номеру заказа
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
