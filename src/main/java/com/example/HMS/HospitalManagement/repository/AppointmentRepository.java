package com.example.HMS.HospitalManagement.repository;

import com.example.HMS.HospitalManagement.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}