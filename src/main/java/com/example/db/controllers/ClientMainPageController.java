package com.example.db.controllers;

import com.example.db.HibernateRunner;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import com.example.db.MainApp;
import com.example.db.entities.SupplierProduct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ClientMainPageController {
    private MainApp mainApp;

    @FXML
    private TableView<SupplierProduct> supplierProductTable;

    @FXML
    private TableColumn<SupplierProduct, Integer> productCodeColumn;

    @FXML
    private TableColumn<SupplierProduct, String> nameColumn;

    @FXML
    private TableColumn<SupplierProduct, Integer> quantityColumn;

    @FXML
    private TableColumn<SupplierProduct, Double> priceColumn;

    @FXML
    private ComboBox<String> sortComboBox;

    private SessionFactory sessionFactory;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void initialize() {
        sessionFactory = HibernateRunner.session();

        // Initialize columns

        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        quantityColumn.setCellValueFactory(cellData -> cellData.getValue().quantityProperty().asObject());
        priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());

        // Load data into table
        loadData();
    }

    private void loadData() {
        try (Session session = sessionFactory.openSession()) {
            Query<SupplierProduct> query = session.createQuery("from SupplierProduct", SupplierProduct.class);
            List<SupplierProduct> productList = query.list();
            supplierProductTable.getItems().addAll(productList);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
