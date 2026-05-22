package com.nvk.apicrud.Entity.Alter;

import java.sql.Timestamp;

public class AlterProduct {
    public int id;
    public String name;
    public int price;
    public int old_price;
    public String image;
    public int status;
    public String category;
    public int soLuong;
    public Timestamp created_at;
    public Timestamp updated_at;

    public AlterProduct(int id, String name, int price, int old_price, String image, int status, String category, int soLuong, Timestamp created_at, Timestamp updated_at) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.old_price = old_price;
        this.image = image;
        this.status = status;
        this.category = category;
        this.soLuong = soLuong;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOld_price() {
        return old_price;
    }

    public void setOld_price(int old_price) {
        this.old_price = old_price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}
