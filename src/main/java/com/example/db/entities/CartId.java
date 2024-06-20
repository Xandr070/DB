package com.example.db.entities;

import java.io.Serializable;
import java.util.Objects;

public class CartId implements Serializable {

    private int order;
    private int product;

    public CartId() {}

    public CartId(int order, int product) {
        this.order = order;
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartId that = (CartId) o;
        return order == that.order && product == that.product;
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }
}
