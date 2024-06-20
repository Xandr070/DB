package com.example.db.entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "issuance")
@IdClass(IssuanceId.class)
public class Issuance {

    @Id
    @Column(name = "order_number")
    private int orderNumber;

    @Id
    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "order_number", referencedColumnName = "order_number", insertable = false, updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "email", referencedColumnName = "email", insertable = false, updatable = false)
    private Customer customer;

/*    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "username", referencedColumnName = "username"),
            @JoinColumn(name = "pvz_code", referencedColumnName = "pvz_code")
    })
    private EmployeePvz employee;*/

    private Date issuanceDate;

    // Getters and Setters

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

/*    public EmployeePvz getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeePvz employee) {
        this.employee = employee;
    }*/

    public Date getIssuanceDate() {
        return issuanceDate;
    }

    public void setIssuanceDate(Date issuanceDate) {
        this.issuanceDate = issuanceDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Issuance issuance = (Issuance) o;
        return orderNumber == issuance.orderNumber &&
                Objects.equals(email, issuance.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, email);
    }
}
