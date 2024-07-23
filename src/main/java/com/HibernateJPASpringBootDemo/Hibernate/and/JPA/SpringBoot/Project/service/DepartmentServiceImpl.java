package com.HibernateJPASpringBootDemo.Hibernate.and.JPA.SpringBoot.Project.service;

import com.HibernateJPASpringBootDemo.Hibernate.and.JPA.SpringBoot.Project.entity.Department;
import com.HibernateJPASpringBootDemo.Hibernate.and.JPA.SpringBoot.Project.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    //Save Operation
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    //Read Operation
    @Override
    public List<Department> fetchDepartmentList() {
        return (List<Department>)
                departmentRepository.findAll();
    }

    // Update operation
    @Override
    public Department updateDepartment(Department department, Long departmentId) {
        Department depDB
                = departmentRepository.findById(departmentId)
                .get();

        if (Objects.nonNull(department.getDepartmentName())
                && !"".equalsIgnoreCase(
                department.getDepartmentName())) {
            depDB.setDepartmentName(
                    department.getDepartmentName());
        }

        if (Objects.nonNull(
                department.getDepartmentAddress())
                && !"".equalsIgnoreCase(
                department.getDepartmentAddress())) {
            depDB.setDepartmentAddress(
                    department.getDepartmentAddress());
        }

        if (Objects.nonNull(department.getDepartmentCode())
                && !"".equalsIgnoreCase(
                department.getDepartmentCode())) {
            depDB.setDepartmentCode(
                    department.getDepartmentCode());
        }

        return departmentRepository.save(depDB);
    }

        // Delete operation
        @Override
    public void deleteDepartmentById(Long departmentId) {
            departmentRepository.deleteById(departmentId);
        }
}
