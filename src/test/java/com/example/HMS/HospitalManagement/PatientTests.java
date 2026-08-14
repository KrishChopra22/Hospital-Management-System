package com.example.HMS.HospitalManagement;

import com.example.HMS.HospitalManagement.entity.Patient;
import com.example.HMS.HospitalManagement.repository.PatientRepository;
import com.example.HMS.HospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTests {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository() {
        List<Patient> patients = patientRepository.findAll();
        System.out.println(patients);
    }

    @Test
    public void testTransactionMethods(){
        Patient patient = patientService.getPatientById(1L);
        System.out.println(patient);
    }
}
