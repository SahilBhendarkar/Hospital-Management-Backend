package com.hospital.backend.controller;

import com.hospital.backend.entity.Doctor;
import com.hospital.backend.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@CrossOrigin("*")
public class DoctorController {

    @Autowired
    private DoctorService service;

    // CREATE DOCTOR
    @PostMapping
    public String createDoctor(
            @RequestBody Doctor doctor
    ) {

        return service.saveDoctor(doctor);
    }

    // GET ALL DOCTORS
    @GetMapping
    public List<Doctor> getDoctors() {

        return service.getAllDoctors();
    }

    // DELETE DOCTOR
    @DeleteMapping("/{id}")
    public String deleteDoctor(
            @PathVariable Long id
    ) {

        return service.deleteDoctor(id);
    }
}