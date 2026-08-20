package com.example.HMS.HospitalManagement.repository;

import com.example.HMS.HospitalManagement.dto.BloodGroupCountResponseEntity;
import com.example.HMS.HospitalManagement.entity.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findPatientByName(String name);
    List<Patient> findPatientByBirthDateOrEmail(LocalDate birthDate, String email);
    List<Patient> findPatientByNameContaining(String query);

    @Query("SELECT p FROM Patient p where p.email = ?1")
    List<Patient> findByEmail(@Param("email") String email);

    @Query("SELECT p FROM Patient p where p.birthDate > :birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);

    @Query("SELECT p.email, Count(p) FROM Patient p group by p.email")
    List<Object[]> countEachPatientByEmail();

    @Query(value = "select * from patient", nativeQuery = true)
    Page<Patient> findAllPatients(Pageable pageable);    // this shows PAGINATION in JPQL

    @Query("SELECT new com.example.HMS.HospitalManagement.dto.BloodGroupCountResponseEntity(p.bloodGroup, Count(p)) FROM Patient p group by p.bloodGroup")
//    List<Object[]> countEachBloodGroupTypePatients();
    List<BloodGroupCountResponseEntity> countEachBloodGroupTypePatients();      // this shows PROJECTION in JPQL

    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.name = :name where p.id = :id")
    int updatePatientNameWithId(@Param("name") String name, @Param("id") Long id);
}
