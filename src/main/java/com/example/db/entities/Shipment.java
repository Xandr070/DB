package com.example.db.entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "shipment")
@IdClass(ShipmentId.class)
public class Shipment {

    @Id
    @Column(name = "username")
    private String username;

    @Id
    @Column(name = "pvz_code")
    private int pvzCode;

    @Id
    @Column(name = "order_number")
    private int orderNumber;

    @Id
    @Column(name = "product_code")
    private int productCode;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false),
            @JoinColumn(name = "pvz_code", referencedColumnName = "pvz_code", insertable = false, updatable = false)
    })
    private EmployeePvz employee;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "order_number", referencedColumnName = "order_number", insertable = false, updatable = false),
            @JoinColumn(name = "product_code", referencedColumnName = "product_code", insertable = false, updatable = false)
    })
    private Cart cart;

    private Date deliveryDate;

    // Getters and Setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPvzCode() {
        return pvzCode;
    }

    public void setPvzCode(int pvzCode) {
        this.pvzCode = pvzCode;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public EmployeePvz getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeePvz employee) {
        this.employee = employee;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shipment shipment = (Shipment) o;
        return pvzCode == shipment.pvzCode &&
                orderNumber == shipment.orderNumber &&
                productCode == shipment.productCode &&
                Objects.equals(username, shipment.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, pvzCode, orderNumber, productCode);
    }
}
