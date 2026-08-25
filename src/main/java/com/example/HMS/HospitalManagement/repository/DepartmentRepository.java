package com.example.HMS.HospitalManagement.repository;

import com.example.HMS.HospitalManagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}