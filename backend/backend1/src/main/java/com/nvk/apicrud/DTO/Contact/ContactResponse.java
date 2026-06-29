package com.nvk.apicrud.DTO.Contact;

public class ContactResponse {
    private final Integer id;
    private final String message;

    public ContactResponse(Integer id, String message) {
        this.id = id;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
