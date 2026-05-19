package com.hospital.backend.service;

import com.hospital.backend.entity.ContactEnquiry;
import com.hospital.backend.repository.ContactEnquiryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactEnquiryService {

    @Autowired
    private ContactEnquiryRepository repository;

    public ContactEnquiry save(ContactEnquiry enquiry) {

        return repository.save(enquiry);
    }
}