package com.hospital.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "appointments")
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String phoneNumber;

    private String email;

    private String appointmentDate;

    private String doctorName;

    @Column(length = 1000)
    private String message;

    private String status = "PENDING";
}