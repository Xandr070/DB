package com.example.db;

import com.example.db.entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateRunner {

    public static SessionFactory session() {
        return new Configuration()
                .addAnnotatedClass(Cart.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(EmployeePvz.class)
                .addAnnotatedClass(Issuance.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(Pvz.class)
                .addAnnotatedClass(Shipment.class)
                .addAnnotatedClass(SupplierProduct.class)
                .addAnnotatedClass(EmployeePvzId.class)
                .addAnnotatedClass(IssuanceId.class)
                .addAnnotatedClass(ShipmentId.class)
                .addAnnotatedClass(CartId.class)

                .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:1234/test")
                .setProperty("hibernate.connection.username", "postgres")
                .setProperty("hibernate.connection.password", "postgres")
                .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
                .setProperty("hibernate.hbm2ddl.auto", "update")
                .buildSessionFactory();
    }
}