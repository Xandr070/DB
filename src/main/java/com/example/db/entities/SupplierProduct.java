package com.example.db.entities;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "supplier_products")
public class SupplierProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_code")
    private int productCode;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

    @Column(name = "weight")
    private double weight;

    @Column(name = "name")
    private String name;

    // JavaFX properties (for UI binding, not persisted in DB)
    private transient StringProperty nameProperty;
    private transient IntegerProperty quantityProperty;
    private transient DoubleProperty priceProperty;
    private transient DoubleProperty productCodeProperty;

    // Constructor
    public SupplierProduct() {
        this.nameProperty = new SimpleStringProperty();
        this.quantityProperty = new SimpleIntegerProperty();
        this.priceProperty = new SimpleDoubleProperty();
        this.productCodeProperty = new SimpleDoubleProperty();
    }

    // Getters and Setters for Hibernate fields
    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getters and Setters for JavaFX properties
    public StringProperty nameProperty() {
        return nameProperty;
    }

    public String getNameProperty() {
        return nameProperty.get();
    }

    public void setNameProperty(String name) {
        this.nameProperty.set(name);
    }

    public IntegerProperty quantityProperty() {
        return quantityProperty;
    }

    public int getQuantityProperty() {
        return quantityProperty.get();
    }

    public void setQuantityProperty(int quantity) {
        this.quantityProperty.set(quantity);
    }

    public DoubleProperty priceProperty() {
        return priceProperty;
    }

    public double getPriceProperty() {
        return priceProperty.get();
    }

    public void setPriceProperty(double price) {
        this.priceProperty.set(price);
    }


}
