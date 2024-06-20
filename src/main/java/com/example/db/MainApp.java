package com.example.db;

import com.example.db.controllers.*;
import com.example.db.entities.SupplierProduct;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class MainApp extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        showRoleSelection();
    }

    public void showRoleSelection() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/db/RoleSelection.fxml"));
        Parent root = loader.load();

        RoleSelectionController controller = loader.getController();
        controller.setMainApp(this);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Выбор Роли");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showClientMainPage() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/db/ClientMainPage.fxml"));
        Parent root = loader.load();

        ClientMainPageController controller = loader.getController();
        controller.setMainApp(this);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Основная страница клиента");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void showClientLoginForm() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/db/ClientLogin.fxml"));
        Parent root = loader.load();

        ClientLoginController controller = loader.getController();
        controller.setMainApp(this);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Вход в аккаунт клиента");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showEmployeeLoginForm() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/db/EmployeeLogin.fxml"));
        Parent root = loader.load();

        EmployeeLoginController controller = loader.getController();
        controller.setMainApp(this);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Вход в аккаунт сотрудника");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showEmployeeMainPage() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/db/EmployeeMainPage.fxml"));
        Parent root = loader.load();

        EmployeeMainPageController controller = loader.getController();
        controller.setMainApp(this);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Главная страница сотрудника");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showCartPage() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/com/example/db/cart-view.fxml"));
            VBox cartPage = loader.load();

            Scene scene = new Scene(cartPage);
            primaryStage.setScene(scene);
            primaryStage.show();

            CartController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showOrdersPage() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/com/example/db/orders-view.fxml"));
            VBox ordersPage = loader.load();

            Scene scene = new Scene(ordersPage);
            primaryStage.setScene(scene);
            primaryStage.show();

            OrderController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showTransportPage() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/db/TransportPage.fxml"));
        Parent root = loader.load();

        TransportPageController controller = loader.getController();
        controller.setMainApp(this);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Перевозка товаров");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showIssuePage() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/db/IssuePage.fxml"));
        Parent root = loader.load();

        IssuePageController controller = loader.getController();
        controller.setMainApp(this);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Выдача товаров");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
