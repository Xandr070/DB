package com.example.db.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cart")
@IdClass(CartId.class)
public class Cart {

    @Id
    @ManyToOne
    @JoinColumn(name = "order_number")
    private Order order;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_code")
    private SupplierProduct product;

    private String name;

    private double price;

    private int quantity;

    // Getters and Setters

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public SupplierProduct getProduct() {
        return product;
    }

    public void setProduct(SupplierProduct product) {
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
