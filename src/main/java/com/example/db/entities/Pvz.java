package com.example.db.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "pvz")
public class Pvz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pvz_code")
    private int pvzCode;

    private String address;
    private int rating;
    private String email;
    private String phoneNumber;

    @OneToMany(mappedBy = "pvz", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EmployeePvz> employees;

    // Getters and Setters

    public int getPvzCode() {
        return pvzCode;
    }

    public void setPvzCode(int pvzCode) {
        this.pvzCode = pvzCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<EmployeePvz> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeePvz> employees) {
        this.employees = employees;
    }
}
