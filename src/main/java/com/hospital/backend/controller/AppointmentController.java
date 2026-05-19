package com.hospital.backend.controller;

import com.hospital.backend.entity.Appointment;
import com.hospital.backend.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin("*")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    // CREATE APPOINTMENT
    @PostMapping
    public String createAppointment(
            @RequestBody Appointment appointment
    ) {

        return service.saveAppointment(appointment);
    }

    // GET ALL APPOINTMENTS
    @GetMapping
    public List<Appointment> getAppointments() {

        return service.getAllAppointments();
    }

    // DELETE APPOINTMENT
    @DeleteMapping("/{id}")
    public String deleteAppointment(
            @PathVariable Long id
    ) {

        return service.deleteAppointment(id);
    }
}