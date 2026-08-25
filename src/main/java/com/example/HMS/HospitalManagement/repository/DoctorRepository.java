package com.example.HMS.HospitalManagement.repository;

import com.example.HMS.HospitalManagement.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}