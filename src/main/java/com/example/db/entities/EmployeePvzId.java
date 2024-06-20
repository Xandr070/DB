package com.example.db.entities;

import java.io.Serializable;
import java.util.Objects;

public class EmployeePvzId implements Serializable {

    private String username;
    private int pvzCode;

    public EmployeePvzId() {}

    public EmployeePvzId(String username, int pvzCode) {
        this.username = username;
        this.pvzCode = pvzCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeePvzId that = (EmployeePvzId) o;
        return pvzCode == that.pvzCode && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, pvzCode);
    }
}
