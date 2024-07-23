package com.HibernateJPASpringBootDemo.Hibernate.and.JPA.SpringBoot.Project.service;

import com.HibernateJPASpringBootDemo.Hibernate.and.JPA.SpringBoot.Project.entity.Department;
// Importing required classes
import java.util.List;

// Interface
public interface DepartmentService {

    //Save Operation
    Department saveDepartment(Department department);

    //Read Operation
    List<Department> fetchDepartmentList();

    //Update operation
    Department updateDepartment(Department department, Long departmentId);

    //Delete Operation
    void deleteDepartmentById(Long departmentId);
}
