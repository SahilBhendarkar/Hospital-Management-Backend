package com.hospital.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "doctors")
@Data
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String specialization;

    private String qualification;

    private String experience;

    private String image;

    private String profileUrl;

    @ElementCollection
    private List<String> departments;
}