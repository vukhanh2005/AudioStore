package com.nvk.apicrud.Services;

import com.nvk.apicrud.DTO.ContactRequest;
import com.nvk.apicrud.DTO.ContactResponse;
import com.nvk.apicrud.Entity.Contact;
import com.nvk.apicrud.Repository.ContactRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public ContactResponse createContact(ContactRequest request) {
        validate(request);

        Contact contact = new Contact();
        contact.setFullName(request.getFullName().trim());
        contact.setEmail(request.getEmail().trim());
        contact.setPhone(blankToEmpty(request.getPhone()));
        contact.setMessage(request.getMessage().trim());

        Contact savedContact = contactRepository.save(contact);
        return new ContactResponse(savedContact.getId(), "Gửi liên hệ thành công");
    }

    private void validate(ContactRequest request) {
        if (request.getFullName() == null || request.getFullName().isBlank()) {
            throw new IllegalArgumentException("Vui lòng nhập họ tên");
        }
        if (request.getEmail() == null || request.getEmail().isBlank()) {
            throw new IllegalArgumentException("Vui lòng nhập email");
        }
        if (request.getMessage() == null || request.getMessage().isBlank()) {
            throw new IllegalArgumentException("Vui lòng nhập nội dung liên hệ");
        }
    }

    private String blankToEmpty(String value) {
        return value == null || value.isBlank() ? "" : value.trim();
    }
}
