package com.example.db.controllers;

import com.example.db.HibernateRunner;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import com.example.db.MainApp;
import com.example.db.entities.SupplierProduct;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ClientMainPageController implements Initializable {
    private MainApp mainApp;

    @FXML
    private TableView<SupplierProduct> supplierProductTable = new TableView<>();

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

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void initialize() {
//
//        // Initialize columns
//
////        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
////        quantityColumn.setCellValueFactory(cellData -> cellData.getValue().quantityProperty().asObject());
////        priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
//        // idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
//        productCodeColumn.setCellValueFactory(new PropertyValueFactory<>("productCode"));
//        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
//        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
//
//        // Load data into table
//        loadData();
    }

    private void loadData() {
//        try (Session session = sessionFactory.openSession()) {
//            Query<SupplierProduct> query = session.createQuery("from SupplierProduct", SupplierProduct.class);
//            List<SupplierProduct> productList = query.list();
//            supplierProductTable.getItems().addAll(productList);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        Platform.runLater(() -> {
            HibernateRunner.session().inTransaction(session -> {
                Query query = session.createQuery("from SupplierProduct", SupplierProduct.class);
                supplierProductTable.getItems().addAll(FXCollections.observableArrayList(query.getResultList()));
                System.out.println(query.getResultList());
            });
        });
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Initialize columns

//        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
//        quantityColumn.setCellValueFactory(cellData -> cellData.getValue().quantityProperty().asObject());
//        priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        // idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        productCodeColumn.setCellValueFactory(new PropertyValueFactory<>("productCode"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        // Load data into table
        loadData();
    }
}
