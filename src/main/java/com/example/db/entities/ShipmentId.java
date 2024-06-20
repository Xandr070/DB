package com.example.db.entities;

import java.io.Serializable;
import java.util.Objects;

public class ShipmentId implements Serializable {

    private String username;
    private int pvzCode;
    private int orderNumber;
    private int productCode;

    public ShipmentId() {}

    public ShipmentId(String username, int pvzCode, int orderNumber, int productCode) {
        this.username = username;
        this.pvzCode = pvzCode;
        this.orderNumber = orderNumber;
        this.productCode = productCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShipmentId that = (ShipmentId) o;
        return pvzCode == that.pvzCode &&
                orderNumber == that.orderNumber &&
                productCode == that.productCode &&
                Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, pvzCode, orderNumber, productCode);
    }
}
