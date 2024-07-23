package com.HibernateJPASpringBootDemo.Hibernate.and.JPA.SpringBoot.Project.controller;
import java.util.List;
import com.HibernateJPASpringBootDemo.Hibernate.and.JPA.SpringBoot.Project.entity.Department;
import com.HibernateJPASpringBootDemo.Hibernate.and.JPA.SpringBoot.Project.service.DepartmentService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    // Save operation
    @PostMapping("/departments")
    public Department saveDepartment(
            @Valid @RequestBody Department department)
    {
        return departmentService.saveDepartment(department);
    }

    // Read operation
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList()
    {
        return departmentService.fetchDepartmentList();
    }

    // Update operation
    @PutMapping("/departments/{id}")
    public Department
    updateDepartment(@RequestBody Department department,
                     @PathVariable("id") Long departmentId)
    {
        return departmentService.updateDepartment(
                department, departmentId);
    }

    // Delete operation
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id")
                                       Long departmentId)
    {
        departmentService.deleteDepartmentById(
                departmentId);

        return "Deleted Successfully";
    }
}
