package com.nvk.apicrud.DTO;

import java.time.LocalDateTime;

public class OrderResponse {
    private final Integer id;
    private final Integer productId;
    private final String productName;
    private final Integer price;
    private final Integer quantity;
    private final String status;
    private final String message;
    private final LocalDateTime createdAt;

    public OrderResponse(Integer id, Integer productId, String productName, Integer price, Integer quantity, String status, String message, LocalDateTime createdAt) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.message = message;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public Integer getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
