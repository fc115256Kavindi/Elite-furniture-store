package com.elite.elitefurniturestore.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "custom_orders")
public class CustomOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String email;
    private String phone;
    private String furnitureType;
    private String preferredMaterial;
    private String preferredColor;
    private String dimensions;
    private Double estimatedBudget;

    @Column(length = 1200)
    private String designDetails;

    private LocalDateTime createdAt;

    public CustomOrder() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFurnitureType() {
        return furnitureType;
    }

    public void setFurnitureType(String furnitureType) {
        this.furnitureType = furnitureType;
    }

    public String getPreferredMaterial() {
        return preferredMaterial;
    }

    public void setPreferredMaterial(String preferredMaterial) {
        this.preferredMaterial = preferredMaterial;
    }

    public String getPreferredColor() {
        return preferredColor;
    }

    public void setPreferredColor(String preferredColor) {
        this.preferredColor = preferredColor;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public Double getEstimatedBudget() {
        return estimatedBudget;
    }

    public void setEstimatedBudget(Double estimatedBudget) {
        this.estimatedBudget = estimatedBudget;
    }

    public String getDesignDetails() {
        return designDetails;
    }

    public void setDesignDetails(String designDetails) {
        this.designDetails = designDetails;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}