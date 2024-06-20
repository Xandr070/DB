package com.example.db.controllers;

import com.example.db.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class EmployeeLoginController {

    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    private MainApp mainApp;
    @FXML
    private void handleBackButton() {
        try {
            mainApp.showRoleSelection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleLogin() {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (isValidCredentials(email, password)) {
            try {
                mainApp.showEmployeeMainPage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            showAlert("Ошибка входа", "Неверные учетные данные.");
        }
    }
    private boolean isValidCredentials(String email, String password) {
        // Пример простой проверки, замените на свою логику проверки
        return true;
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
