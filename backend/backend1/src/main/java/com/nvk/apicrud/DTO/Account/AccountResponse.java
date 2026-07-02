package com.nvk.apicrud.DTO.Account;

public class AccountResponse {
    private final Integer id;
    private final String fullName;
    private final String username;
    private final String email;
    private final String message;
    private final String role;

    public AccountResponse(Integer id, String fullName, String username, String email, String message, String role) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.message = message;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
    
    public String getRole(){return role;}

    public String getMessage() {
        return message;
    }
}
