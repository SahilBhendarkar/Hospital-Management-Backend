package com.hospital.backend.controller;

import com.hospital.backend.entity.ContactEnquiry;
import com.hospital.backend.service.ContactEnquiryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
public class ContactEnquiryController {

    @Autowired
    private ContactEnquiryService service;

    @PostMapping
    public ContactEnquiry saveEnquiry(
            @RequestBody ContactEnquiry enquiry
    ) {

        return service.save(enquiry);
    }
}