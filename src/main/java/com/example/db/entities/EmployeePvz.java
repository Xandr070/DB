package com.example.db.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_pvz")
@IdClass(EmployeePvzId.class)
public class EmployeePvz {

    @Id
    @Column(name = "username")
    private String username;

    @Id
    @Column(name = "pvz_code")
    private int pvzCode;

    @ManyToOne
    private Pvz pvz;

    private String phoneNumber;
    private String fullName;
    private String accessLevel;
    private String password;

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

    public Pvz getPvz() {
        return pvz;
    }

    public void setPvz(Pvz pvz) {
        this.pvz = pvz;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
