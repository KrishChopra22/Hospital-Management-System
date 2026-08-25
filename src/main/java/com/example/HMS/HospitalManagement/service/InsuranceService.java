package com.example.HMS.HospitalManagement.service;

import com.example.HMS.HospitalManagement.entity.Insurance;
import com.example.HMS.HospitalManagement.entity.Patient;
import com.example.HMS.HospitalManagement.repository.InsuranceRepository;
import com.example.HMS.HospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional  //dirty checking and updates in DB
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + patientId));
        patient.setInsurance(insurance);    // since it's owning side
        insurance.setPatient(patient);      // bidirectional consistency maintained
        return patient;
    }

    @Transactional
    public Patient disassociateInsuranceFromPatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + patientId));
        patient.setInsurance(null);     // dirty checking, since orphanRemoval is true, it will delete this insurance from DB
        return patient;
    }
}
