package com.example.HMS.HospitalManagement.service;

import com.example.HMS.HospitalManagement.entity.Patient;
import com.example.HMS.HospitalManagement.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    @Transactional  // if success then commit, if failure then rollback
    public Patient getPatientById(Long id){
        Patient p1 = patientRepository.findById(id).orElseThrow();  // this will be stored in persistent context

        Patient p2 = patientRepository.findById(id).orElseThrow();  // this won't call Hibernate, as same object already found of same id, so it will point to same object i.e. p1==p2

        p1.setName("Xyz");
//        patientRepository.save(p1);   // this is not even required since it is under transactional method, which commits automatically by dirty checking in Persistent state
        return p1;
    }
}
