package com.example.db.entities;

import java.io.Serializable;
import java.util.Objects;

public class IssuanceId implements Serializable {

    private int orderNumber;
    private String email;

    public IssuanceId() {}

    public IssuanceId(int orderNumber, String email) {
        this.orderNumber = orderNumber;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IssuanceId that = (IssuanceId) o;
        return orderNumber == that.orderNumber && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, email);
    }
}
