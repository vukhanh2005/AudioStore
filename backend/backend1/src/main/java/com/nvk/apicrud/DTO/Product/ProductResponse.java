package com.nvk.apicrud.DTO.Product;

import java.time.LocalDateTime;

public class ProductResponse {
    private Integer id;
    private String name;
    private String category;
    private Integer price;
    private Integer oldPrice;
    private String image;
    private Integer soluong;
    private Integer status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProductResponse(Integer id, String name, String category, Integer price, Integer oldPrice, String image, Integer soluong, Integer status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.oldPrice = oldPrice;
        this.image = image;
        this.soluong = soluong;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getOldPrice() {
        return oldPrice;
    }

    public String getImage() {
        return image;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public Integer getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
