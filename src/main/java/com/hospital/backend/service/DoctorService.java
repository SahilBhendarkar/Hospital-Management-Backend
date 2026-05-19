package com.hospital.backend.service;

import com.hospital.backend.entity.Doctor;
import com.hospital.backend.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    // SAVE DOCTOR
    public String saveDoctor(Doctor doctor) {

        // VALIDATION
        if (
                doctor.getName() == null ||
                        doctor.getName().trim().isEmpty()
        ) {

            return "Doctor Name Required";
        }

        // DUPLICATE CHECK
        if (
                repository.existsByName(
                        doctor.getName()
                )
        ) {

            return "Doctor Already Exists";
        }

        repository.save(doctor);

        return "Doctor Saved Successfully";
    }

    // GET ALL DOCTORS
    public List<Doctor> getAllDoctors() {

        return repository.findAll();
    }

    // DELETE DOCTOR
    public String deleteDoctor(Long id) {

        if (repository.existsById(id)) {

            repository.deleteById(id);

            return "Doctor Deleted Successfully";
        }

        return "Doctor Not Found";
    }
}