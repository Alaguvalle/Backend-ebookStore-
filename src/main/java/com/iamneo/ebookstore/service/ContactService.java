package com.iamneo.ebookstore.service;

import com.iamneo.ebookstore.impl.ContactRequest;
import com.iamneo.ebookstore.model.Contact;
import com.iamneo.ebookstore.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepository repository;

    public ResponseEntity <String> contact(ContactRequest contactRequest) {
        Optional<Contact> contactOptional=repository.findByEmail(contactRequest.getEmail());
        if (contactOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Request Already Exists");
        } else {
             Contact contact= Contact.builder()
                    .name(contactRequest.getName())
                    .email(contactRequest.getEmail())
                    .message(contactRequest.getMessage())
                    .build();
             repository.save(contact);
            return ResponseEntity.status(HttpStatus.OK).body("Message saved successfully");
        }
    }

    }

