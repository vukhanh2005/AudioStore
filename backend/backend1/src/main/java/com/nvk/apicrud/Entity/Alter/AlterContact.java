package com.nvk.apicrud.Entity.Alter;

import java.sql.Timestamp;

public class AlterContact {
    public int id;
    public String full_name;
    public String email;
    public String phone;
    public String message;
    public Timestamp created_at;

    public AlterContact(int id, String full_name, String email, String phone, String message, Timestamp created_at) {
        this.id = id;
        this.full_name = full_name;
        this.email = email;
        this.phone = phone;
        this.message = message;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
}
