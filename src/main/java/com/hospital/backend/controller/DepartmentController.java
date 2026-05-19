package com.hospital.backend.controller;

import com.hospital.backend.entity.Department;
import com.hospital.backend.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@CrossOrigin("*")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    // CREATE SINGLE DEPARTMENT
    @PostMapping
    public String createDepartment(
            @RequestBody Department department
    ) {

        return service.saveDepartment(department);
    }

    // CREATE MULTIPLE DEPARTMENTS
    @PostMapping("/bulk")
    public List<Department> createDepartments(
            @RequestBody List<Department> departments
    ) {

        return service.saveDepartments(departments);
    }

    // GET ALL DEPARTMENTS
    @GetMapping
    public List<Department> getDepartments() {

        return service.getAllDepartments();
    }

    // DELETE DEPARTMENT
    @DeleteMapping("/{id}")
    public String deleteDepartment(
            @PathVariable Long id
    ) {

        return service.deleteDepartment(id);
    }
}