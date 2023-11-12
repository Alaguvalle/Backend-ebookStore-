package com.iamneo.ebookstore.controller;

import com.iamneo.ebookstore.impl.ContactRequest;
import com.iamneo.ebookstore.repository.ContactRepository;
import com.iamneo.ebookstore.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class ContactController {
    private final ContactService contactService;

    @Autowired
    @GetMapping("/all")
    public String getMessage() {
        return "messages";
    }
    @PostMapping("/msg")
    public ResponseEntity<String> saveMessage(
       @RequestBody ContactRequest contactRequest)
    {
        return contactService.contact(contactRequest);
    }
}