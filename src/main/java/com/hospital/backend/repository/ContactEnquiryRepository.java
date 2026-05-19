package com.hospital.backend.repository;

import com.hospital.backend.entity.ContactEnquiry;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactEnquiryRepository
        extends JpaRepository<ContactEnquiry, Long> {
}