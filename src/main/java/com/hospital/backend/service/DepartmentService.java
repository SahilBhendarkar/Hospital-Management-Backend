package com.hospital.backend.service;

import com.hospital.backend.entity.Department;
import com.hospital.backend.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    // SAVE SINGLE DEPARTMENT
    public String saveDepartment(
            Department department
    ) {

        // NULL VALIDATION
        if (
                department.getTitle() == null ||
                        department.getTitle().trim().isEmpty()
        ) {

            return "Department Title Required";
        }

        // DUPLICATE CHECK
        if (
                repository.existsByTitle(
                        department.getTitle()
                )
        ) {

            return "Department Already Exists";
        }

        repository.save(department);

        return "Department Saved Successfully";
    }

    // SAVE MULTIPLE DEPARTMENTS
    public List<Department> saveDepartments(
            List<Department> departments
    ) {

        return repository.saveAll(departments);
    }

    // GET ALL DEPARTMENTS
    public List<Department> getAllDepartments() {

        return repository.findAll();
    }

    // DELETE DEPARTMENT
    public String deleteDepartment(Long id) {

        if (repository.existsById(id)) {

            repository.deleteById(id);

            return "Department Deleted Successfully";
        }

        return "Department Not Found";
    }
}