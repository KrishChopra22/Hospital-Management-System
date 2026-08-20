package com.example.HMS.HospitalManagement;

import com.example.HMS.HospitalManagement.dto.BloodGroupCountResponseEntity;
import com.example.HMS.HospitalManagement.entity.Patient;
import com.example.HMS.HospitalManagement.repository.PatientRepository;
import com.example.HMS.HospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
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

//        List<Patient> patientList = patientRepository.findPatientByBirthDateOrEmail(LocalDate.of(1989,4,12),".@gmail.com");
        List<Patient> patientList = patientRepository.findPatientByNameContaining("ja");

        int rowsUpdated = patientRepository.updatePatientNameWithId("Arun", 4L);
        System.out.println(rowsUpdated);

        List<BloodGroupCountResponseEntity> bloodGroupPatientsList = patientRepository.countEachBloodGroupTypePatients();
        for(BloodGroupCountResponseEntity bloodGroupCountResponse : bloodGroupPatientsList){
            System.out.println(bloodGroupCountResponse);
        }

        Page<Patient> patientPage = patientRepository.findAllPatients(PageRequest.of(0,3, Sort.by("name")));
        for(Patient p : patientPage){
            System.out.println(p);
        }
    }
}
