package com.hospital.backend.service;

import com.hospital.backend.entity.Appointment;
import com.hospital.backend.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    // SAVE APPOINTMENT
    public String saveAppointment(
            Appointment appointment
    ) {

        // VALIDATION
        if (
                appointment.getFullName() == null ||
                        appointment.getFullName().trim().isEmpty()
        ) {

            return "Full Name Required";
        }

        if (
                appointment.getDoctorName() == null ||
                        appointment.getDoctorName().trim().isEmpty()
        ) {

            return "Doctor Name Required";
        }

        repository.save(appointment);

        return "Appointment Booked Successfully";
    }

    // GET ALL APPOINTMENTS
    public List<Appointment> getAllAppointments() {

        return repository.findAll();
    }

    // DELETE APPOINTMENT
    public String deleteAppointment(Long id) {

        if (repository.existsById(id)) {

            repository.deleteById(id);

            return "Appointment Deleted Successfully";
        }

        return "Appointment Not Found";
    }
}