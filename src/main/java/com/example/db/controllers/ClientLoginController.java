package com.example.db.controllers;

import com.example.db.HibernateRunner;
import com.example.db.MainApp;
import com.example.db.entities.Customer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import jakarta.persistence.Query;
import java.util.List;

public class ClientLoginController {
    private MainApp mainApp;
    @FXML
    private TextField registerEmailField;
    @FXML
    private PasswordField registerPasswordField;
    @FXML
    private TextField registerFirstNameField;
    @FXML
    private TextField registerLastNameField;
    @FXML
    private TextField registerPhoneNumberField;

    @FXML
    private TextField loginEmailField;
    @FXML
    private PasswordField loginPasswordField;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleBackButton() {
        try {
            mainApp.showRoleSelection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleRegister() {
        String emailValue = registerEmailField.getText();
        String passwordValue = registerPasswordField.getText();
        String firstNameValue = registerFirstNameField.getText();
        String lastNameValue = registerLastNameField.getText();
        String phoneNumberValue = registerPhoneNumberField.getText();

        if (emailValue.isEmpty() || passwordValue.isEmpty() || firstNameValue.isEmpty() || lastNameValue.isEmpty() || phoneNumberValue.isEmpty()) {
            showAlert("Ошибка", "Не все поля заполнены", "Пожалуйста, заполните все поля для регистрации.");
            return;
        }

        Platform.runLater(() -> {
            HibernateRunner.session().inTransaction(session -> {
                String nativeQuery = """
                        INSERT INTO Customer(email, password, first_name, last_name, phone_number)
                        VALUES (:email, :password, :firstName, :lastName, :phoneNumber)
                        """;

                try {
                    // Создаем нативный SQL-запрос
                    Query query = session.createNativeQuery(nativeQuery);
                    query.setParameter("email", emailValue);
                    query.setParameter("password", passwordValue);
                    query.setParameter("firstName", firstNameValue);
                    query.setParameter("lastName", lastNameValue);
                    query.setParameter("phoneNumber", phoneNumberValue);

                    // Выполняем операцию вставки
                    int rowsUpdated = query.executeUpdate();
                    if (rowsUpdated > 0) {
                        System.out.println("Запись успешно добавлена в базу данных");
                        // После успешной регистрации можно переходить на главную страницу клиента
                        mainApp.showClientMainPage();
                    } else {
                        System.out.println("Не удалось добавить запись в базу данных");
                        showAlert("Ошибка", "Не удалось добавить запись в базу данных", "Попробуйте еще раз или обратитесь к администратору.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    showAlert("Ошибка", "Ошибка при выполнении запроса", "Пожалуйста, проверьте правильность введенных данных или обратитесь к администратору.");
                }
            });
        });
    }

    @FXML
    private void handleLogin() {
        String email = loginEmailField.getText();
        String password = loginPasswordField.getText();

        if (email.isEmpty() || password.isEmpty()) {
            showAlert("Ошибка", "Не все поля заполнены", "Пожалуйста, заполните все поля для входа.");
            return;
        }

        Platform.runLater(() -> {
            HibernateRunner.session().inTransaction(session -> {
                String checkQuery = "FROM Customer WHERE email = :email AND password = :password";

                try {
                    Query query = session.createQuery(checkQuery, Customer.class);
                    query.setParameter("email", email);
                    query.setParameter("password", password);

                    List<Customer> resultList = query.getResultList();
                    if (!resultList.isEmpty()) {
                        // Если пользователь найден, показываем главную страницу клиента
                        mainApp.showClientMainPage();
                    } else {
                        // Если пользователь не найден, можно вывести сообщение об ошибке
                        System.out.println("Пользователь с таким email и паролем не найден");
                        showAlert("Ошибка", "Пользователь не найден", "Проверьте правильность введенных данных или зарегистрируйтесь.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    showAlert("Ошибка", "Ошибка при выполнении запроса", "Пожалуйста, проверьте правильность введенных данных или обратитесь к администратору.");
                }
            });
        });
    }

    private void showAlert(String title, String headerText, String contentText) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
}
