package com.nvk.apicrud.Repository;

import com.nvk.apicrud.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
