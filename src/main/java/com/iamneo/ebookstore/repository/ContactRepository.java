package com.iamneo.ebookstore.repository;

import com.iamneo.ebookstore.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, Long> {
Optional<Contact> findByEmail(String email);
}
